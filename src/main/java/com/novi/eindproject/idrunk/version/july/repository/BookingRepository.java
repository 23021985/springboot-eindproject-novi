package com.novi.eindproject.idrunk.version.july.repository;

import com.novi.eindproject.idrunk.version.july.model.Booking;
import com.novi.eindproject.idrunk.version.july.model.Tafel;
import com.novi.eindproject.idrunk.version.july.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByPlannedStartTimeBetween(LocalDateTime start, LocalDateTime end);

    List<Booking> findByUser(User user);

    List<Booking> findByTafel(Tafel tafel);

    List<Booking> findByPlannedStartTimeBetweenAndTafel(LocalDateTime start, LocalDateTime end, Tafel tafel);

    List<Booking> findByPlannedEndTimeBetweenAndTafel(LocalDateTime start, LocalDateTime end, Tafel tafel);
}
