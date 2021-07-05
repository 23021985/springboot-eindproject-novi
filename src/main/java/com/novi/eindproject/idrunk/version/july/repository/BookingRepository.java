package com.novi.eindproject.idrunk.version.july.repository;


import com.novi.eindproject.idrunk.version.july.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking getById(long id);
}