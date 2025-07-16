package com.Michael.IPLAuctionDashboard.domains.mappers;

import com.Michael.IPLAuctionDashboard.domains.dtos.BatsmanDTO;
import com.Michael.IPLAuctionDashboard.domains.entities.Batsman;

public interface BatsmanMapper {
    Batsman fromDTO(BatsmanDTO batsmanDTO);
    BatsmanDTO toDTO(Batsman batsman);
}
