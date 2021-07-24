package com.novi.eindproject.idrunk.version.july.service;
import com.novi.eindproject.idrunk.version.july.model.Booking;
import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {

    List<Booking> getBookings();

    List<Booking> getBookingsForTafel(Long tafelId);

    List<Booking> getBookingsByUserName(String username);

    void deleteBooking(Long id);

    void updateBooking(Long id, Booking booking);

    void planBooking(LocalDateTime startTime, LocalDateTime endTime, Long tafelId, String username);

    Booking getById(Long id);

    List<Booking> getBookingsBetweenDates(LocalDateTime startTime, LocalDateTime endTime);
}