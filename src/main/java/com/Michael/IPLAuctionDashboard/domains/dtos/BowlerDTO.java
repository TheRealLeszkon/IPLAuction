package com.Michael.IPLAuctionDashboard.domains.dtos;

import com.Michael.IPLAuctionDashboard.domains.entities.PlayerStatus;

import java.math.BigDecimal;

public record BowlerDTO (
        Integer id,
        String name,
        String association,
        BigDecimal price,
        String imageLink,
        PlayerStatus status,
        BigDecimal soldPrice,
        Integer teamId,
        Integer matches,
        Integer wickets,
        BigDecimal economy,
        String best_figure
) {}
