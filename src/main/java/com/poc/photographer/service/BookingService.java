package com.poc.photographer.service;

import com.poc.photographer.model.Booking;
import com.poc.photographer.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService implements IBookingService
{
    private BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository)
    {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getBookings()
    {
        List<Booking> bookings = new ArrayList<>();
        bookingRepository.findAll().forEach(bookings::add);
        return bookings;
    }

    @Override
    public Booking save(Booking booking)
    {
        return bookingRepository.save(booking);
    }
}
