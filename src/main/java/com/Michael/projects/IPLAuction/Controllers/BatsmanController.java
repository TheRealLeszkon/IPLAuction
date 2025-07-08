package com.Michael.projects.IPLAuction.Controllers;

import com.Michael.projects.IPLAuction.Entities.Batsman;
import com.Michael.projects.IPLAuction.Repositories.BatsmanRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class BatsmanController {

    private final BatsmanRepository batsmanRepository;

    public BatsmanController(BatsmanRepository batsmanRepository) {
        this.batsmanRepository = batsmanRepository;
    }

    @GetMapping("/batsmen")
    public String showAll(Model model){
        List<Batsman> batsmen = StreamSupport.stream(batsmanRepository.findAll().spliterator(),false).toList();
        model.addAttribute("batsmen",batsmen);
        return "test";
    }
    @GetMapping("/batsmen/{pos}")
    public String showOne(@PathVariable Integer pos, Model model){
        Batsman batsman = batsmanRepository.findById(pos).get();
        model.addAttribute("batsman",batsman);
        return "profile";
    }
}
