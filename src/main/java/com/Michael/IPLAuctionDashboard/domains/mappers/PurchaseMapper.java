package com.Michael.IPLAuctionDashboard.domains.mappers;

import com.Michael.IPLAuctionDashboard.domains.dtos.PurchaseDTO;
import com.Michael.IPLAuctionDashboard.domains.entities.Purchase;

public interface PurchaseMapper {
    Purchase fromDTO(PurchaseDTO purchaseDTO);
    PurchaseDTO toDTO(Purchase purchase);
}
