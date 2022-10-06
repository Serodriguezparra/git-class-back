package com.grupo13.app.rents.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Costume")
public class CostumeController {
    
    @GetMapping("/all")
    public String getCostumes(){
        return "costume 1, costume 2";
    }

    @PostMapping("/save")
    public String createCostume(){
        return "Created ...";
    }
}
