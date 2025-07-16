package com.Michael.IPLAuctionDashboard.domains.mappers;

import com.Michael.IPLAuctionDashboard.domains.dtos.BowlerDTO;
import com.Michael.IPLAuctionDashboard.domains.entities.Bowler;

public interface BowlerMapper {
    Bowler fromDTO(BowlerDTO bowlerDTO);
    BowlerDTO toDTO(Bowler bowler);
}
