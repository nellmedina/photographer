package com.poc.photographer.service;

import com.poc.photographer.model.Booking;

import java.util.List;

public interface IBookingService
{
    List<Booking> getBookings();

    Booking save(Booking booking);
}
