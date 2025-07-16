package com.Michael.IPLAuctionDashboard.services.impl;

import com.Michael.IPLAuctionDashboard.domains.entities.Bowler;
import com.Michael.IPLAuctionDashboard.repositories.BowlerRepository;
import com.Michael.IPLAuctionDashboard.services.BowlerService;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BowlerServiceImpl implements BowlerService {

    private final BowlerRepository bowlerRepository;

    public BowlerServiceImpl(BowlerRepository bowlerRepository) {
        this.bowlerRepository = bowlerRepository;
    }

    @Override
    public List<Bowler> listBowlers() {
        return bowlerRepository.findAll();
    }

    @Override
    public Bowler findBowler(Integer id) {
        return bowlerRepository.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("No Such Bowler Exists in DB!"));
    }

    @Override
    public void updateBowler(Bowler bowler) {
        bowlerRepository.save(bowler);
    }
}
