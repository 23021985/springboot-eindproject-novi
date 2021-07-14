package com.novi.eindproject.idrunk.version.july.service;

import com.novi.eindproject.idrunk.version.july.model.Booking;


import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {

    List<Booking> getBookings();
    Booking getBookings(long id);
//    Booking addBooking(Booking booking);
//    void removeBooking(long id);
//    void updateBooking(long id);

//    List<Booking> getBookingsForTafel(Long tafelId);

    List<Booking> getBookingsOnDate(LocalDateTime date);

    List<Booking> getBookingsByUsername(String username);

    Booking saveBooking(Booking booking, Long tafelId, String username);

    List<Booking> getBookingsForTafel(Long tafelId);

    List<Booking> getBookingsForUser(String username);
}