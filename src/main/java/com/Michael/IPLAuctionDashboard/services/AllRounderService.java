package com.Michael.IPLAuctionDashboard.services;

import com.Michael.IPLAuctionDashboard.domains.entities.AllRounder;

import java.util.List;

public interface AllRounderService {
    List<AllRounder> getListOfAllRounders();
    AllRounder findAllRounder(Integer id);

    void updateAllRounder(AllRounder allRounder);
}
