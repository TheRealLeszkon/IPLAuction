package com.Michael.IPLAuctionDashboard.domains.dtos;

import com.Michael.IPLAuctionDashboard.domains.entities.Batsman;

import java.math.BigDecimal;
import java.util.List;

public record TeamDTO (
        Integer id,
        String name,
        BigDecimal balance,
        List<BatsmanDTO> batsmanDTOList,
        List<BowlerDTO> bowlerDTOList,
        List<AllRounderDTO> allRounderDTOList
){}
