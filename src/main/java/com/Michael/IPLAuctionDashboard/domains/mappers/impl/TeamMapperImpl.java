package com.Michael.IPLAuctionDashboard.domains.mappers.impl;

import com.Michael.IPLAuctionDashboard.domains.dtos.TeamDTO;
import com.Michael.IPLAuctionDashboard.domains.entities.Team;
import com.Michael.IPLAuctionDashboard.domains.mappers.AllRounderMapper;
import com.Michael.IPLAuctionDashboard.domains.mappers.BatsmanMapper;
import com.Michael.IPLAuctionDashboard.domains.mappers.BowlerMapper;
import com.Michael.IPLAuctionDashboard.domains.mappers.TeamMapper;
import com.Michael.IPLAuctionDashboard.repositories.TeamRepository;
import org.springframework.stereotype.Component;

@Component
public class TeamMapperImpl implements TeamMapper {
    private final BatsmanMapper batsmanMapper;
    private final BowlerMapper bowlerMapper;
    private final AllRounderMapper allRounderMapper;

    public TeamMapperImpl(BatsmanMapper batsmanMapper, BowlerMapper bowlerMapper, AllRounderMapper allRounderMapper) {
        this.batsmanMapper = batsmanMapper;
        this.bowlerMapper = bowlerMapper;
        this.allRounderMapper = allRounderMapper;
    }

    @Override
    public Team fromDTO(TeamDTO teamDTO) {
        return new Team(
                teamDTO.id(),
                teamDTO.name(),
                teamDTO.balance(),
                teamDTO.batsmanDTOList() != null
                        ?teamDTO.batsmanDTOList().stream().map(batsmanMapper::fromDTO).toList()
                        :null,
                teamDTO.bowlerDTOList() != null
                        ?teamDTO.bowlerDTOList().stream().map(bowlerMapper::fromDTO).toList()
                        :null,
                teamDTO.allRounderDTOList() != null
                        ?teamDTO.allRounderDTOList().stream().map(allRounderMapper::fromDTO).toList()
                        :null
        );
    }

    @Override
    public TeamDTO toDTO(Team team) {
        return new TeamDTO(
                team.getId(),
                team.getName(),
                team.getBalance(),
                team.getBatsmenList() != null
                        ?team.getBatsmenList().stream().map(batsmanMapper::toDTO).toList()
                        :null,
                team.getBowlerList() != null
                        ?team.getBowlerList().stream().map(bowlerMapper::toDTO).toList()
                        :null,
                team.getAllRoundersList() != null
                        ?team.getAllRoundersList().stream().map(allRounderMapper::toDTO).toList()
                        :null
        );
    }
}
