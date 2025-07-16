package com.Michael.IPLAuctionDashboard.domains.mappers;

import com.Michael.IPLAuctionDashboard.domains.dtos.AllRounderDTO;
import com.Michael.IPLAuctionDashboard.domains.entities.AllRounder;

public interface AllRounderMapper {
    AllRounder fromDTO(AllRounderDTO allRounderDTO);
    AllRounderDTO toDTO(AllRounder allRounder);
}
