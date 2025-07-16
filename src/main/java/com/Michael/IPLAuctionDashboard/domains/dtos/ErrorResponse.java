package com.Michael.IPLAuctionDashboard.domains.dtos;

public record ErrorResponse(
        int status,
        String message,
        String details

) {
}
