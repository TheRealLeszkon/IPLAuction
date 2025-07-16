package com.Michael.IPLAuctionDashboard.services;

import com.Michael.IPLAuctionDashboard.domains.entities.Batsman;

import java.util.List;

public interface BatsmenService {
    List<Batsman> listOfBatsmen();
    Batsman findBatsman(Integer id);
    void updateBatsman(Batsman batsman);
}
