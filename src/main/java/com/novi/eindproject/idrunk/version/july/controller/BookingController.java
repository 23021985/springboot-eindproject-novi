package com.novi.eindproject.idrunk.version.july.controller;

import com.novi.eindproject.idrunk.version.july.dto.BookingDto;
import com.novi.eindproject.idrunk.version.july.dto.BookingInputDto;
import com.novi.eindproject.idrunk.version.july.exceptions.BadRequestException;
import com.novi.eindproject.idrunk.version.july.exceptions.RecordNotFoundException;
import com.novi.eindproject.idrunk.version.july.model.Booking;
import com.novi.eindproject.idrunk.version.july.model.User;
import com.novi.eindproject.idrunk.version.july.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/booking")
public class BookingController {
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<BookingDto> getBookings(@RequestParam(value = "tafelId", required = false) Long tafelId,
                                        @RequestParam(value = "username", required = false) String username,
                                        @RequestParam(value = "start", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                        @RequestParam(value = "end", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        var dtos = new ArrayList<BookingDto>();

        List<Booking> bookings;
        if (username != null && username == null && start == null && end == null) {
            bookings = bookingService.getBookingsForTafel(tafelId);

        } else if (username != null && tafelId == null && start == null && end == null) {
            bookings = bookingService.getBookingsForUser(username);

        } else if (start != null && end != null && username == null && tafelId == null) {
            bookings = bookingService.getBookingsBetweenDates(start, end);

        } else {
            throw new BadRequestException();
        }

        for (Booking booking : bookings) {
            dtos.add(BookingDto.fromBooking(booking));
        }

        return dtos;
    }

    @PostMapping
    public BookingDto saveBooking(@RequestBody BookingInputDto dto) {
        var booking = bookingService.planBooking(dto.tafelId, dto.username, dto.startTime, dto.endTime);
        return BookingDto.fromBooking(booking);

    }
}