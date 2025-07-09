package com.Michael.projects.IPLAuction.Controllers;

import com.Michael.projects.IPLAuction.Entities.Batsman;
import com.Michael.projects.IPLAuction.Repositories.BatsmanRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.StreamSupport;
@RestController
public class BatsmanJSONController {
    private final BatsmanRepository batsmanRepository;


    public BatsmanJSONController(BatsmanRepository batsmanRepository) {
        this.batsmanRepository = batsmanRepository;
    }

    @GetMapping("/batsmenJSON")
    public List<Batsman> showAll(Model model){
        List<Batsman> batsmen = StreamSupport.stream(batsmanRepository.findAll().spliterator(),false).toList();
        return batsmen;
    }
    @GetMapping("/batsmenJSON/{pos}")
    public Batsman showOne(@PathVariable Integer pos, Model model){
        Batsman batsman = batsmanRepository.findById(pos).get();

        return batsman;
    }

}
