package com.Michael.projects.IPLAuction.Controllers;
import com.Michael.projects.IPLAuction.Entities.TeamPurchase;
import com.Michael.projects.IPLAuction.Repositories.TeamPurchaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.StreamSupport;

@RestController
public class TeamPurchaseController {
    private final TeamPurchaseRepository teamPurchaseRepository;

    public TeamPurchaseController(TeamPurchaseRepository teamPurchaseRepository) {
        this.teamPurchaseRepository = teamPurchaseRepository;
    }

    @PostMapping("/purchase")
    public ResponseEntity<TeamPurchase> addNewPurchase(@RequestBody TeamPurchase teamPurchase){
        TeamPurchase record = teamPurchaseRepository.save(teamPurchase);
        return new ResponseEntity<TeamPurchase>(record, HttpStatus.CREATED);
    }
    @GetMapping("/purchase")
    public ResponseEntity<List<TeamPurchase>> showAllPurchases(){
        List<TeamPurchase> allRecords = StreamSupport.stream(teamPurchaseRepository.findAll().spliterator(),false).toList();
        return new ResponseEntity<List<TeamPurchase>>(allRecords,HttpStatus.OK);
    }
}
