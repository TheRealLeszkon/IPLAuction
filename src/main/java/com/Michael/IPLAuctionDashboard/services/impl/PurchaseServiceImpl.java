package com.Michael.IPLAuctionDashboard.services.impl;

import com.Michael.IPLAuctionDashboard.domains.entities.*;
import com.Michael.IPLAuctionDashboard.repositories.PurchaseRepository;
import com.Michael.IPLAuctionDashboard.services.*;
import jakarta.transaction.Transactional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
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
        BigDecimal sellingPrice =purchase.getSoldPrice();
        Team purchasingTeam =teamService.findTeam(purchase.getTeamId());
        if(purchasingTeam.getBalance().compareTo(sellingPrice)<0){
            throw new IllegalArgumentException("Insufficient Funds! \nThe Team can't buy this player!");
        }
        switch (purchase.getPlayerType()){
            case "batsman":{
                Batsman batsman =batsmenService.findBatsman(purchase.getPlayerId());
                if(purchase.getSoldPrice().compareTo(batsman.getPrice())<0){
                    throw new IllegalArgumentException("Player can't be bought below base rate!");
                }
                if(batsman.getPlayerStatus() ==PlayerStatus.SOLD){
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
                if(purchase.getSoldPrice().compareTo(bowler.getPrice())<0){
                    throw new IllegalArgumentException("Player can't be bought below base rate!");
                }
                if(bowler.getPlayerStatus()==PlayerStatus.SOLD){
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
                if(purchase.getSoldPrice().compareTo(allRounder.getPrice())<0){
                    throw new IllegalArgumentException("Player can't be bought below base rate!");
                }
                if(allRounder.getPlayerStatus()==PlayerStatus.SOLD){
                    throw new IllegalArgumentException("Player Already Sold!");
                }
                allRounder.setTeam(purchasingTeam);
                allRounder.setPlayerStatus(PlayerStatus.SOLD);
                allRounder.setSoldPrice(sellingPrice);
                allRounderService.updateAllRounder(allRounder);
                break;
            }
            default:
                throw new IllegalArgumentException("Inappropriate Player Type, check your player type!");

        }
        BigDecimal deductedBalance =purchasingTeam.getBalance().subtract(sellingPrice);
        purchasingTeam.setBalance(deductedBalance);
        teamService.updateTeam(purchasingTeam);
        purchaseRepository.save(purchase);
    }

    @Override
    public List<Purchase> listAllPurchases() {
        return purchaseRepository.findAll();
    }

}
