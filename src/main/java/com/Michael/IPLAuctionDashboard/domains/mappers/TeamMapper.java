package com.Michael.IPLAuctionDashboard.domains.mappers;

import com.Michael.IPLAuctionDashboard.domains.dtos.TeamDTO;
import com.Michael.IPLAuctionDashboard.domains.entities.Team;

public interface TeamMapper {
    Team fromDTO(TeamDTO teamDTO);
    TeamDTO toDTO(Team team);
}
