package com.poc.photographer.repository;

import com.poc.photographer.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long>
{

}
