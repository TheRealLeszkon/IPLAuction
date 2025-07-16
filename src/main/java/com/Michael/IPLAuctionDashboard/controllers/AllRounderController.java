package com.Michael.IPLAuctionDashboard.controllers;

import com.Michael.IPLAuctionDashboard.domains.dtos.AllRounderDTO;
import com.Michael.IPLAuctionDashboard.domains.entities.AllRounder;
import com.Michael.IPLAuctionDashboard.domains.mappers.AllRounderMapper;
import com.Michael.IPLAuctionDashboard.services.AllRounderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/all_rounders")
public class AllRounderController {

    private final AllRounderService allRounderService;
    private final AllRounderMapper allRounderMapper;

    public AllRounderController(AllRounderService allRounderService, AllRounderMapper allRounderMapper) {
        this.allRounderService = allRounderService;
        this.allRounderMapper = allRounderMapper;
    }

    @GetMapping
    public ResponseEntity<List<AllRounderDTO>> listAllRounders(){
        List<AllRounderDTO> foundAllRounders = allRounderService.getListOfAllRounders()
                .stream()
                .map(allRounderMapper::toDTO)
                .toList();
        return new ResponseEntity<>(foundAllRounders,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AllRounderDTO> sendAllRounder(@PathVariable Integer id){
        AllRounder foundAllRounder =allRounderService.findAllRounder(id);
        return new ResponseEntity<>(allRounderMapper.toDTO(foundAllRounder), HttpStatus.OK);
    }
}
