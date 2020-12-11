package com.poc.photographer.service;

import com.poc.photographer.model.Offering;

import java.util.List;

public interface IOfferingrService
{
    List<Offering> getOfferings();
    Offering save(Offering offering);
}
