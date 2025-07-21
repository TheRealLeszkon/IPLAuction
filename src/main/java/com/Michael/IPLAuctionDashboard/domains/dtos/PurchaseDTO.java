package com.Michael.IPLAuctionDashboard.domains.dtos;

import java.math.BigDecimal;

public record PurchaseDTO(
        Integer id,
        String teamId,
        Integer playerId,
        BigDecimal soldPrice,
        String playerType
) {
}