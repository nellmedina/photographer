package com.poc.photographer.controller;

import com.poc.photographer.model.Offering;
import com.poc.photographer.service.IOfferingrService;
import com.poc.photographer.service.OfferingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
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
    @RolesAllowed({ "PHOTOGRAPHER", "CUSTOMER" })
    public List<Offering> getOfferings()
    {
        return offeringrService.getOfferings();
    }

    @PostMapping
    public Offering createOfferings(@RequestBody Offering offering)
    {
        return offeringrService.save(offering);
    }
}
