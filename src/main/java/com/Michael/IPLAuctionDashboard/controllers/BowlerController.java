package com.Michael.IPLAuctionDashboard.controllers;

import com.Michael.IPLAuctionDashboard.domains.dtos.BowlerDTO;
import com.Michael.IPLAuctionDashboard.domains.mappers.BowlerMapper;
import com.Michael.IPLAuctionDashboard.services.BowlerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bowlers")
public class BowlerController {

    private final BowlerService bowlerService;
    private final BowlerMapper bowlerMapper;

    public BowlerController(BowlerService bowlerService, BowlerMapper bowlerMapper) {
        this.bowlerService = bowlerService;
        this.bowlerMapper = bowlerMapper;
    }

    @GetMapping
    public ResponseEntity<List<BowlerDTO>> listAllBowlers(){
        List<BowlerDTO> foundBowlers = bowlerService.listBowlers().stream().map(bowlerMapper::toDTO).toList();
        return new ResponseEntity<>(foundBowlers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BowlerDTO> sendBowler(@PathVariable Integer id){
        return new ResponseEntity<>(
            bowlerMapper.toDTO(bowlerService.findBowler(id)),
            HttpStatus.OK
        );

    }
}
