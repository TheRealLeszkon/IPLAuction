package com.Michael.IPLAuctionDashboard.services.impl;

import com.Michael.IPLAuctionDashboard.domains.entities.Batsman;
import com.Michael.IPLAuctionDashboard.repositories.BatsmenRepository;
import com.Michael.IPLAuctionDashboard.services.BatsmenService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatsmanServiceImpl implements BatsmenService {

    private final BatsmenRepository batsmenRepository;

    public BatsmanServiceImpl(BatsmenRepository batsmenRepository) {
        this.batsmenRepository = batsmenRepository;
    }

    @Override
    public List<Batsman> listOfBatsmen() {
        return batsmenRepository.findAll();
    }

    @Override
    public Batsman findBatsman(Integer id) {
        return batsmenRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("No such Batsman Exists in DB!"));
    }

    @Override
    public void updateBatsman(Batsman batsman) {
        batsmenRepository.save(batsman);
    }
}
