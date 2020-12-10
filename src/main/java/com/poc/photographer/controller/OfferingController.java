package com.poc.photographer.controller;

import com.poc.photographer.model.Offering;
import com.poc.photographer.model.UserEntity;
import com.poc.photographer.service.IOfferingrService;
import com.poc.photographer.service.IUserService;
import com.poc.photographer.service.OfferingService;
import com.poc.photographer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/offerings")
public class OfferingController
{
    private IOfferingrService offeringrService;

    @Autowired
    public OfferingController(OfferingService offeringrService)
    {
        this.offeringrService = offeringrService;
    }

    @GetMapping
    public List<Offering> getOfferings()
    {
        return offeringrService.getOfferings();
    }
}
