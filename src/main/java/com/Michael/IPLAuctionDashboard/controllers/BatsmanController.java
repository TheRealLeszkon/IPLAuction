package com.Michael.IPLAuctionDashboard.controllers;

import com.Michael.IPLAuctionDashboard.domains.dtos.BatsmanDTO;
import com.Michael.IPLAuctionDashboard.domains.mappers.BatsmanMapper;
import com.Michael.IPLAuctionDashboard.services.BatsmenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "batsmen")
public class BatsmanController {

    private final BatsmenService batsmenService;
    private final BatsmanMapper batsmanMapper;

    public BatsmanController(BatsmenService batsmenService, BatsmanMapper batsmanMapper) {
        this.batsmenService = batsmenService;
        this.batsmanMapper = batsmanMapper;
    }

    @GetMapping
    public ResponseEntity<List<BatsmanDTO>> listBatsmen(){
        List<BatsmanDTO> allBatsmen =batsmenService.listOfBatsmen().stream().map(batsmanMapper::toDTO).toList();
        return new ResponseEntity<>(allBatsmen, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BatsmanDTO> findBatsman(@PathVariable Integer id){
        return new ResponseEntity<>(
                batsmanMapper.toDTO(batsmenService.findBatsman(id)),
                HttpStatus.OK
        );
    }
}
