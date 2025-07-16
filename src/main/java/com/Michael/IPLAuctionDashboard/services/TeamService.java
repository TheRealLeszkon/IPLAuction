package com.Michael.IPLAuctionDashboard.services;

import com.Michael.IPLAuctionDashboard.domains.entities.Team;

import java.util.List;

public interface TeamService {
    List<Team> listTeams();
    Team findTeam(Integer id);

    Team createTeam(Team team);

    void updateTeam(Team team);
}
