package com.poc.photographer.controller;

import com.poc.photographer.model.Booking;
import com.poc.photographer.service.BookingService;
import com.poc.photographer.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/bookings")
public class BookingController
{
    private IBookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService)
    {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<Booking> getBookings()
    {
        return bookingService.getBookings();
    }
}
