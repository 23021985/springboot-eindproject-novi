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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<BookingDto> getBookings(@RequestParam(value = "username", required = false) String username,
                                        @RequestParam(value = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {

        var dtos = new ArrayList<BookingDto>();

        List<Booking> bookings;
        if (username != null && date == null) {
            bookings = bookingService.getBookingsByUsername(username);

        } else if (date != null && username == null) {
            bookings = bookingService.getBookingsOnDate(date);

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
        var booking = bookingService.saveBooking(dto.toBooking(), dto.tafelId, dto.username);
        return BookingDto.fromBooking(booking);
    }
}
