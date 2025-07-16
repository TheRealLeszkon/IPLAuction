package com.Michael.IPLAuctionDashboard.domains.dtos;

import com.Michael.IPLAuctionDashboard.domains.entities.PlayerStatus;

import java.math.BigDecimal;

public record BatsmanDTO(
        Integer id,
        String name,
        String association,
        BigDecimal price,
        String imageLink,
        PlayerStatus status,
        BigDecimal soldPrice,
        Integer teamId,
        Integer runs,
        Integer matches,
        BigDecimal battingAvg,
        BigDecimal strikeRate
) {
}
