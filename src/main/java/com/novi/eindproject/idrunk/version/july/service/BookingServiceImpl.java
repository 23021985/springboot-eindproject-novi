package com.novi.eindproject.idrunk.version.july.service;


import com.novi.eindproject.idrunk.version.july.exceptions.RecordNotFoundException;
import com.novi.eindproject.idrunk.version.july.model.Booking;
import com.novi.eindproject.idrunk.version.july.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingRepository bookingRepository;
    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBooking(long id) throws RecordNotFoundException {
        return bookingRepository.getById(id);
    }

    @Override
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void removeBooking(long id) throws RecordNotFoundException {
        bookingRepository.deleteById(id);
    }

    @Override
    public void updateBooking(long id, Booking booking) throws RecordNotFoundException {

    }

    @Override
    public List<Booking> getBookingsBetweenDates(LocalDateTime start, LocalDateTime end) {
        return null;
    }

    @Override
    public List<Booking> getBookingsForTafel(Long boatId) {
        return null;
    }

    @Override
    public List<Booking> getBookingsForUser(Long userId) {
        return null;
    }

    @Override
    public Booking planBooking(Long tafelId, Long userId, LocalDateTime plannedStartTime, LocalDateTime plannedEndTime) {
        return null;
    }

    @Override
    public Booking completeBooking(Long bookingId, LocalDateTime actualStartTime, LocalDateTime actualEndTime) {
        return null;
    }
}
