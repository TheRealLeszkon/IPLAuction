package com.Michael.IPLAuctionDashboard.services;

import com.Michael.IPLAuctionDashboard.domains.entities.Bowler;

import java.util.List;

public interface BowlerService {
    List<Bowler> listBowlers();
    Bowler findBowler(Integer id);

    void updateBowler(Bowler bowler);
}
