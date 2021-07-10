package com.novi.eindproject.idrunk.version.july.service;

import com.novi.eindproject.idrunk.version.july.exceptions.RecordNotFoundException;
import com.novi.eindproject.idrunk.version.july.model.Booking;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {

//    List<Booking>getBookings();
//    Booking getBooking(long id) throws RecordNotFoundException;
//    Booking addBooking(Booking booking);
//    void removeBooking(long id) throws RecordNotFoundException;
//    void updateBooking(long id, Booking booking) throws RecordNotFoundException;

    List<Booking> getBookingsBetweenDates(LocalDateTime start, LocalDateTime end);

    List<Booking> getBookingsForTafel(Long tafelId);

    List<Booking> getBookingsForUser(String username);

    Booking planBooking(Long tafelId, String username, LocalDateTime plannedStartTime, LocalDateTime plannedEndTime);

    Booking completeBooking(Long bookingId, LocalDateTime actualStartTime, LocalDateTime actualEndTime);

}
