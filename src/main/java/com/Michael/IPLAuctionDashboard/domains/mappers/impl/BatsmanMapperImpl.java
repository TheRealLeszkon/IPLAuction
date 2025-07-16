package com.Michael.IPLAuctionDashboard.domains.mappers.impl;

import com.Michael.IPLAuctionDashboard.domains.dtos.BatsmanDTO;
import com.Michael.IPLAuctionDashboard.domains.entities.Batsman;
import com.Michael.IPLAuctionDashboard.domains.mappers.BatsmanMapper;
import org.springframework.stereotype.Component;

@Component
public class BatsmanMapperImpl implements BatsmanMapper {
    @Override
    public Batsman fromDTO(BatsmanDTO batsmanDTO) {
        return new Batsman(
                batsmanDTO.id(),
                batsmanDTO.name(),
                batsmanDTO.association(),
                batsmanDTO.price(),
                batsmanDTO.imageLink(),
                batsmanDTO.status(),
                batsmanDTO.soldPrice(),
                null,
                batsmanDTO.runs(),
                batsmanDTO.matches(),
                batsmanDTO.battingAvg(),
                batsmanDTO.strikeRate()
        );
    }

    @Override
    public BatsmanDTO toDTO(Batsman batsman) {
        return new BatsmanDTO(
                batsman.getId(),
                batsman.getName(),
                batsman.getAssociation(),
                batsman.getPrice(),
                batsman.getImageLink(),
                batsman.getPlayerStatus(),
                batsman.getSoldPrice(),
                batsman.getTeam() != null ? batsman.getTeam().getId() :null,
                batsman.getRuns(),
                batsman.getMatches(),
                batsman.getBattingAvg(),
                batsman.getStrikeRate()
        );
    }
}
