package com.poc.photographer.controller;

import com.poc.photographer.model.Booking;
import com.poc.photographer.service.BookingService;
import com.poc.photographer.service.IBookingService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/bookings")
@Api( tags = "Bookings")
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

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking)
    {
        return bookingService.save(booking);
    }
}
