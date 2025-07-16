package com.Michael.IPLAuctionDashboard.controllers;

import com.Michael.IPLAuctionDashboard.domains.dtos.BatsmanDTO;
import com.Michael.IPLAuctionDashboard.domains.dtos.TeamDTO;
import com.Michael.IPLAuctionDashboard.domains.entities.Team;
import com.Michael.IPLAuctionDashboard.domains.mappers.TeamMapper;
import com.Michael.IPLAuctionDashboard.services.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;
    private final TeamMapper teamMapper;

    public TeamController(TeamService teamService, TeamMapper teamMapper) {
        this.teamService = teamService;
        this.teamMapper = teamMapper;
    }

    @GetMapping
    public ResponseEntity<List<TeamDTO>> listAllTeams(){
        List<TeamDTO> foundTeams=teamService.listTeams().stream().map(teamMapper::toDTO).toList();
        return new ResponseEntity<>(
                foundTeams, HttpStatus.OK
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> findTeam(@PathVariable Integer id){
        TeamDTO foundTeam = teamMapper.toDTO(teamService.findTeam(id));
        return new ResponseEntity<>(foundTeam,HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<TeamDTO> createNewTeam(@RequestBody TeamDTO teamDTO){
        Team createdTeam =teamService.createTeam(teamMapper.fromDTO(teamDTO));
        return new ResponseEntity<>(teamMapper.toDTO(createdTeam),HttpStatus.CREATED);
    }

}
