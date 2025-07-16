package com.Michael.IPLAuctionDashboard.services.impl;

import com.Michael.IPLAuctionDashboard.domains.entities.Team;
import com.Michael.IPLAuctionDashboard.repositories.TeamRepository;
import com.Michael.IPLAuctionDashboard.services.TeamService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
@Component
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> listTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team findTeam(Integer id) {
        return teamRepository.findById(id)
                .orElseThrow(() ->new IllegalArgumentException("No Such Team Exists in DB!"));
    }

    @Override
    public Team createTeam(Team team) {
        team.setBalance(new BigDecimal("1000000000.00"));
        return teamRepository.save(team);
    }

    @Override
    public void updateTeam(Team team) {
        teamRepository.save(team);
    }
}
