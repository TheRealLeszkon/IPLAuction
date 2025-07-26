package com.Michael.IPLAuctionDashboard.services;

import com.Michael.IPLAuctionDashboard.domains.entities.Purchase;

import java.util.List;

public interface PurchaseService {
    void purchasePlayer(Purchase purchase);
    List<Purchase> listAllPurchases();
    void refundPlayer(String playerType,Integer id);

}
