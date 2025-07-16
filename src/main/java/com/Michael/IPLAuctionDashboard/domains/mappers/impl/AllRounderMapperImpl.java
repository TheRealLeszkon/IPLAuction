package com.Michael.IPLAuctionDashboard.domains.mappers.impl;

import com.Michael.IPLAuctionDashboard.domains.dtos.AllRounderDTO;
import com.Michael.IPLAuctionDashboard.domains.entities.AllRounder;
import com.Michael.IPLAuctionDashboard.domains.mappers.AllRounderMapper;
import org.springframework.stereotype.Component;

@Component
public class AllRounderMapperImpl implements AllRounderMapper {
    @Override
    public AllRounder fromDTO(AllRounderDTO allRounderDTO) {
        return  new AllRounder(
                allRounderDTO.id(),
                allRounderDTO.name(),
                allRounderDTO.association(),
                allRounderDTO.price(),
                allRounderDTO.imageLink(),
                allRounderDTO.status(),
                allRounderDTO.soldPrice(),
                null,
                allRounderDTO.runs(),
                allRounderDTO.wickets(),
                allRounderDTO.matches(),
                allRounderDTO.strikeRate()
        );
    }

    @Override
    public AllRounderDTO toDTO(AllRounder allRounder) {
        return new AllRounderDTO(
                allRounder.getId(),
                allRounder.getName(),
                allRounder.getAssociation(),
                allRounder.getPrice(),
                allRounder.getImageLink(),
                allRounder.getPlayerStatus(),
                allRounder.getSoldPrice(),
                allRounder.getTeam() != null ? allRounder.getTeam().getId() :null,
                allRounder.getRuns(),
                allRounder.getWickets(),
                allRounder.getMatches(),
                allRounder.getStrikeRate()
        );
    }
}
