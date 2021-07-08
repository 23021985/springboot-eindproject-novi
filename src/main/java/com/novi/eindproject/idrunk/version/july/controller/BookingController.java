package com.novi.eindproject.idrunk.version.july.controller;


import com.novi.eindproject.idrunk.version.july.dto.BookingDto;
import com.novi.eindproject.idrunk.version.july.dto.BookingInputDto;
import com.novi.eindproject.idrunk.version.july.exceptions.BadRequestException;
import com.novi.eindproject.idrunk.version.july.exceptions.RecordNotFoundException;
import com.novi.eindproject.idrunk.version.july.model.Booking;
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
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<BookingDto> getBookings(@RequestParam(value = "tafelId", required = false) Long tafelId,
                                        @RequestParam(value = "userId", required = false) Long userId,
                                        @RequestParam(value = "start", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                        @RequestParam(value = "end", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        var dtos = new ArrayList<BookingDto>();

        List<Booking> bookings;
        if (tafelId != null && userId == null && start == null && end == null) {
            bookings = bookingService.getBookingsForTafel(tafelId);

        } else if (userId != null && tafelId == null && start == null && end == null) {
            bookings = bookingService.getBookingsForUser(userId);

        } else if (start != null && end != null && userId == null && tafelId == null) {
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
        var booking = bookingService.planBooking(dto.tafelId, dto.customerId, dto.startTime, dto.endTime);
        return BookingDto.fromBooking(booking);


//    @GetMapping("")
//    public ResponseEntity<Object> getBookings(){
//        return ResponseEntity.ok(bookingService.getBookings());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getBookings(@PathVariable("id") long id) throws RecordNotFoundException {
//        Booking booking = (Booking) bookingService.getBooking(id);
//        return ResponseEntity.ok(booking);
//    }

//    @PostMapping("")
//    public ResponseEntity<Object> addBooking(@RequestBody Booking booking){
//        bookingService.addBooking(booking);
//        return ResponseEntity.ok("Added");
//    }
//
//        @PutMapping("/{id}")
//        public ResponseEntity<Object> updateBooking ( @PathVariable("id") long id, @RequestBody Booking newBooking) throws
//        RecordNotFoundException {
//            bookingService.updateBooking(id, newBooking);
//            return ResponseEntity.noContent().build();
//        }
//
//        @DeleteMapping("/{id}")
//        public ResponseEntity<Object> removeBooking ( @PathVariable("id") long id) throws RecordNotFoundException {
//            bookingService.removeBooking(id);
//            return ResponseEntity.noContent().build();

    }
}