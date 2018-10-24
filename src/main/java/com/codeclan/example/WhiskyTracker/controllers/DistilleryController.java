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
@RequestMapping(value = "/distilleries")
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    //TODO: route for all distilleries from a particular region
    @GetMapping(value = "from/{region}")
    public List<Distillery> getAllDistilleryFromRegion(@PathVariable String region){
        return distilleryRepository.getAllDistilleryFromRegion(region);
    }

    //TODO: route for all distilleries that have 12 years old whiskies
    @GetMapping(value = "age/{age}")
    public List<Distillery> getAllDistilleriesWithWhiskies12YearsOld(@PathVariable int age) {
        return distilleryRepository.getAllDistilleriesWithWhiskies12YearsOld(age);
    }

}

