package com.Michael.IPLAuctionDashboard.services.impl;

import com.Michael.IPLAuctionDashboard.domains.entities.*;
import com.Michael.IPLAuctionDashboard.repositories.PurchaseRepository;
import com.Michael.IPLAuctionDashboard.services.*;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    private static final Logger log = LoggerFactory.getLogger(PurchaseServiceImpl.class);
    private final BatsmenService batsmenService;
    private final BowlerService bowlerService;
    private final AllRounderService allRounderService;
    private final TeamService teamService;
    private final PurchaseRepository purchaseRepository;

    public PurchaseServiceImpl(BatsmenService batsmenService, BowlerService bowlerService, AllRounderService allRounderService, TeamService teamService, PurchaseRepository purchaseRepository) {
        this.batsmenService = batsmenService;
        this.bowlerService = bowlerService;
        this.allRounderService = allRounderService;
        this.teamService = teamService;
        this.purchaseRepository = purchaseRepository;
    }
    @Transactional
    @Override
    public void purchasePlayer(Purchase purchase) {
        String playerName;
        BigDecimal sellingPrice =purchase.getSoldPrice();
        Team purchasingTeam =teamService.findTeam(purchase.getTeamId());
        if(purchasingTeam.getBalance().compareTo(sellingPrice)<0){
            log.info("Insufficient Funds! \nThe Team can't buy this player!");
            throw new IllegalArgumentException("Insufficient Funds! \nThe Team can't buy this player!");
        }
        switch (purchase.getPlayerType()){
            case "batsman":{
                Batsman batsman =batsmenService.findBatsman(purchase.getPlayerId());
                playerName =batsman.getName();
//                if(purchase.getSoldPrice().compareTo(batsman.getPrice())<0){
//                    log.info("Player can't be bought below base rate!");
//                    throw new IllegalArgumentException("Player can't be bought below base rate!");
//                }
                if(batsman.getPlayerStatus() ==PlayerStatus.SOLD){
                    log.info("Batsman Already Sold!");
                    throw new IllegalArgumentException("Player Already Sold!");
                }
                batsman.setTeam(purchasingTeam);
                batsman.setPlayerStatus(PlayerStatus.SOLD);
                batsman.setSoldPrice(sellingPrice);
                batsmenService.updateBatsman(batsman);
                break;

            }
            case "bowler":{
                Bowler bowler =bowlerService.findBowler(purchase.getPlayerId());
                playerName =bowler.getName();
//                if(purchase.getSoldPrice().compareTo(bowler.getPrice())<0){
//                    throw new IllegalArgumentException("Player can't be bought below base rate!");
//                }
                if(bowler.getPlayerStatus()==PlayerStatus.SOLD){
                    log.info("Bowler Already Sold!");
                    throw new IllegalArgumentException("Player Already Sold!");
                }
                bowler.setTeam(purchasingTeam);
                bowler.setPlayerStatus(PlayerStatus.SOLD);
                bowler.setSoldPrice(sellingPrice);
                bowlerService.updateBowler(bowler);

                break;
            }
            case "all_rounder":{
                AllRounder allRounder =allRounderService.findAllRounder(purchase.getPlayerId());
                playerName =allRounder.getName();
//                if(purchase.getSoldPrice().compareTo(allRounder.getPrice())<0){
//                    throw new IllegalArgumentException("Player can't be bought below base rate!");
//                }
                if(allRounder.getPlayerStatus()==PlayerStatus.SOLD){
                    log.info("All Rounder Already Sold!");
                    throw new IllegalArgumentException("Player Already Sold!");
                }
                allRounder.setTeam(purchasingTeam);
                allRounder.setPlayerStatus(PlayerStatus.SOLD);
                allRounder.setSoldPrice(sellingPrice);
                allRounderService.updateAllRounder(allRounder);
                break;
            }
            default: {
                log.info("Inappropriate Player Type, check your player type!");
                throw new IllegalArgumentException("Inappropriate Player Type, check your player type!");
            }
        }
        BigDecimal deductedBalance =purchasingTeam.getBalance().subtract(sellingPrice);
        purchasingTeam.setBalance(deductedBalance);
        teamService.updateTeam(purchasingTeam);
        purchaseRepository.save(purchase);
        log.info("PLAYER: {} was purchased by TEAM: {}",playerName,purchasingTeam.getName());

    }

    @Override
    public List<Purchase> listAllPurchases() {
        return purchaseRepository.findAll();
    }
    @Transactional
    @Override
    public void refundPlayer(String playerType, Integer id) {
        String playerName;
        switch (playerType){
            case "batsman":{
                Batsman batsman =batsmenService.findBatsman(id);
                playerName =batsman.getName();
                if(batsman.getPlayerStatus() == PlayerStatus.FOR_SALE){
                    log.info("Batsman wasn't sold in the first place!");
                    throw new IllegalArgumentException("Player wasn't sold in the first place!");
                }
                Team team = teamService.findTeam(batsman.getTeam().getId());
                team.setBalance(
                        team.getBalance().add(batsman.getSoldPrice())
                );
                batsman.setSoldPrice(null);
                batsman.setPlayerStatus(PlayerStatus.FOR_SALE);
                batsman.setTeam(null);
                teamService.updateTeam(team);
                batsmenService.updateBatsman(batsman);
                break;
            }
            case "bowler":{
                Bowler bowler =bowlerService.findBowler(id);
                playerName =bowler.getName();
                if(bowler.getPlayerStatus() == PlayerStatus.FOR_SALE){
                    log.info("Bowler wasn't sold in the first place!");
                    throw new IllegalArgumentException("Player wasn't sold in the first place!");
                }
                Team team = teamService.findTeam(bowler.getTeam().getId());
                team.setBalance(
                        team.getBalance().add(bowler.getSoldPrice())
                );
                bowler.setSoldPrice(null);
                bowler.setPlayerStatus(PlayerStatus.FOR_SALE);
                bowler.setTeam(null);
                teamService.updateTeam(team);
                bowlerService.updateBowler(bowler);
                break;
            }
            case "all_rounder":{
                AllRounder allRounder =allRounderService.findAllRounder(id);
                playerName =allRounder.getName();
                if(allRounder.getPlayerStatus() == PlayerStatus.FOR_SALE){
                    log.info("AllRounder wasn't sold in the first place!");
                    throw new IllegalArgumentException("Player wasn't sold in the first place!");
                }
                Team team = teamService.findTeam(allRounder.getTeam().getId());
                team.setBalance(
                        team.getBalance().add(allRounder.getSoldPrice())
                );
                allRounder.setSoldPrice(null);
                allRounder.setPlayerStatus(PlayerStatus.FOR_SALE);
                allRounder.setTeam(null);
                teamService.updateTeam(team);
                allRounderService.updateAllRounder(allRounder);
                break;
            }
            default:{
                log.info("No such Player Type!");
                throw new IllegalArgumentException("No such Player Type!");
            }

        }
        log.info("PLAYER: {} was REFUNDED",playerName);
    }

}
