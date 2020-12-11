package com.poc.photographer.service;

import com.poc.photographer.model.Offering;
import com.poc.photographer.model.UserEntity;
import com.poc.photographer.repository.OfferingRepository;
import com.poc.photographer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferingService implements IOfferingrService
{
    private OfferingRepository offeringRepository;

    @Autowired
    public OfferingService(OfferingRepository offeringRepository)
    {
        this.offeringRepository = offeringRepository;
    }

    @Override
    public List<Offering> getOfferings()
    {
        List<Offering> offerings = new ArrayList<>();
        offeringRepository.findAll().forEach(offerings::add);
        return offerings;
    }

    @Override
    public Offering save(Offering offering) {
        return offeringRepository.save(offering);
    }
}
