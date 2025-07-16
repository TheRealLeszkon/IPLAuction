package com.Michael.IPLAuctionDashboard.domains.mappers.impl;

import com.Michael.IPLAuctionDashboard.domains.dtos.BowlerDTO;
import com.Michael.IPLAuctionDashboard.domains.entities.Bowler;
import com.Michael.IPLAuctionDashboard.domains.mappers.BowlerMapper;
import com.Michael.IPLAuctionDashboard.services.BowlerService;
import org.springframework.stereotype.Component;

@Component
public class BowlerMapperImpl implements BowlerMapper {

    @Override
    public Bowler fromDTO(BowlerDTO bowlerDTO) {
        return new Bowler(
                bowlerDTO.id(),
                bowlerDTO.name(),
                bowlerDTO.association(),
                bowlerDTO.price(),
                bowlerDTO.imageLink(),
                bowlerDTO.status(),
                bowlerDTO.soldPrice(),
                null,
                bowlerDTO.wickets(),
                bowlerDTO.matches(),
                bowlerDTO.economy(),
                bowlerDTO.best_figure()
        );
    }

    @Override
    public BowlerDTO toDTO(Bowler bowler) {
        return new BowlerDTO(
                bowler.getId(),
                bowler.getName(),
                bowler.getAssociation(),
                bowler.getPrice(),
                bowler.getImageLink(),
                bowler.getPlayerStatus(),
                bowler.getSoldPrice(),
                bowler.getTeam() != null? bowler.getTeam().getId() :null,
                bowler.getMatches(),
                bowler.getWickets(),
                bowler.getEconomy(),
                bowler.getBestFigure()
        );
    }
}
