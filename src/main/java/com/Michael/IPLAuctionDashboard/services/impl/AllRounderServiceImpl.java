package com.Michael.IPLAuctionDashboard.services.impl;

import com.Michael.IPLAuctionDashboard.domains.entities.AllRounder;
import com.Michael.IPLAuctionDashboard.domains.entities.PlayerStatus;
import com.Michael.IPLAuctionDashboard.repositories.AllRounderRepository;
import com.Michael.IPLAuctionDashboard.services.AllRounderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AllRounderServiceImpl implements AllRounderService {

    private final AllRounderRepository allRounderRepository;

    public AllRounderServiceImpl(AllRounderRepository allRounderRepository) {
        this.allRounderRepository = allRounderRepository;
    }


    @Override
    public List<AllRounder> getListOfAllRounders() {
        return allRounderRepository.findAll();
    }

    @Override
    public AllRounder findAllRounder(Integer id) {
        return allRounderRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("No Player By that ID Exists"));
    }

    @Override
    public void updateAllRounder(AllRounder allRounder) {
        allRounderRepository.save(allRounder);
    }
}
