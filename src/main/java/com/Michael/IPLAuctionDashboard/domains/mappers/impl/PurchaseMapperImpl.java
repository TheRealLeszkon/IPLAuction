package com.Michael.IPLAuctionDashboard.domains.mappers.impl;

import com.Michael.IPLAuctionDashboard.domains.dtos.PurchaseDTO;
import com.Michael.IPLAuctionDashboard.domains.entities.Purchase;
import com.Michael.IPLAuctionDashboard.domains.mappers.PurchaseMapper;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapperImpl implements PurchaseMapper {
    @Override
    public Purchase fromDTO(PurchaseDTO purchaseDTO) {
        return new Purchase(
                purchaseDTO.id(),
                purchaseDTO.teamId(),
                purchaseDTO.playerId(),
                purchaseDTO.soldPrice(),
                purchaseDTO.playerType()
        );
    }

    @Override
    public PurchaseDTO toDTO(Purchase purchase) {
        return new PurchaseDTO(
                purchase.getId(),
                purchase.getTeamId(),
                purchase.getPlayerId(),
                purchase.getSoldPrice(),
                purchase.getPlayerType()
        );
    }
}
