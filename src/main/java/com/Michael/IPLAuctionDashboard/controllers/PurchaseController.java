package com.Michael.IPLAuctionDashboard.controllers;

import com.Michael.IPLAuctionDashboard.domains.dtos.PurchaseDTO;
import com.Michael.IPLAuctionDashboard.domains.mappers.*;
import com.Michael.IPLAuctionDashboard.services.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;
    private final PurchaseMapper purchaseMapper;

    public PurchaseController(PurchaseService purchaseService, PurchaseMapper purchaseMapper) {
        this.purchaseService = purchaseService;
        this.purchaseMapper = purchaseMapper;
    }


    @PostMapping
    public ResponseEntity<String> purchaseBatsman(@RequestBody PurchaseDTO purchaseDTO) {
       purchaseService.purchasePlayer(purchaseMapper.fromDTO(purchaseDTO));
       return new ResponseEntity<>("Purchased Successfully!", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseDTO>> showAllPurchases(){
        List<PurchaseDTO> allPurchases =purchaseService.listAllPurchases().stream().map(purchaseMapper::toDTO).toList();
        return new ResponseEntity<>(allPurchases,HttpStatus.OK);
    }
}
