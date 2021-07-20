package com.novi.eindproject.idrunk.version.july.service;
import com.novi.eindproject.idrunk.version.july.model.Booking;
import com.novi.eindproject.idrunk.version.july.model.Tafel;
import com.novi.eindproject.idrunk.version.july.model.User;
import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {

    List<Booking> getBookings();

    List<Booking> getBookingsForTafel(Tafel tafel);

    List<Booking> getBookingsOnDate(LocalDateTime date);

    List<Booking> getBookingsByUser(User user);

    void deleteBooking(Long id);

    void updateBooking(Long id, Booking booking);

    void planBooking(String startTime, String endTime, Long tafelId, String username, LocalDateTime date);

    Booking getById(Long id);

}