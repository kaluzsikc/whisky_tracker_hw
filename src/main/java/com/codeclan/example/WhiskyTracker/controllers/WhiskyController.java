package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/whiskies")
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @Autowired
    DistilleryRepository distilleryRepository;

    //TODO: route for all whiskies from a particular year
    @GetMapping(value = "from/{year}")
    public List<Whisky> getWhiskyOverAge(@PathVariable int year) {
        return whiskyRepository.getAllWhiskyFromYear(year);
    }

    //TODO: route for all whiskies from a particular region
    @GetMapping(value = "region/{region}")
    public List<Whisky> getAllWhiskiesFromRegion(@PathVariable String region){
        return whiskyRepository.getAllWhiskiesFromRegion(region);
    }

    //TODO: route for all whiskies from a particular distillery and a specific age
    @GetMapping(value = "distilleryAndAge/{distillery}/{age}")
    public List<Whisky> getAllWhiskiesFromSpecificDistilleryAndSpecificAge(@PathVariable Distillery distillery, @PathVariable int age) {
        return whiskyRepository.getAllWhiskiesFromSpecificDistilleryAndSpecificAge(distillery,age);
    }


}

