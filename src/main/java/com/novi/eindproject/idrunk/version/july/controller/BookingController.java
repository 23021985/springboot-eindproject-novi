package com.novi.eindproject.idrunk.version.july.controller;
import com.novi.eindproject.idrunk.version.july.dto.BookingDto;
import com.novi.eindproject.idrunk.version.july.dto.BookingInputDto;
import com.novi.eindproject.idrunk.version.july.exceptions.BadRequestException;
import com.novi.eindproject.idrunk.version.july.model.Booking;
import com.novi.eindproject.idrunk.version.july.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
                                        @RequestParam(value = "startTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startTime,
                                        @RequestParam(value = "endTime", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endTime,
                                        @RequestParam(value = "tafelId", required = false) Long tafelId) {

        var dtos = new ArrayList<BookingDto>();

        List<Booking> bookings;
        if (username == null && startTime == null && endTime == null && tafelId == null) {
            bookings = bookingService.getBookings();

        } else if(username != null && startTime == null && endTime == null && tafelId == null) {
            bookings = bookingService.getBookingsByUserName(username);

        } else if (startTime != null && endTime != null && username == null && tafelId == null) {
            bookings = bookingService.getBookingsBetweenDates(startTime, endTime);

        } else if (tafelId != null && startTime == null && endTime == null && username == null) {
            bookings = bookingService.getBookingsForTafel(tafelId);
        } else {
            throw new BadRequestException();
        }

        for (Booking booking : bookings) {
            dtos.add(BookingDto.fromBooking(booking));
        }

        return dtos;
    }

    @GetMapping("/{id}")
    public BookingDto getBooking(@PathVariable("id") Long id) {
        var booking = bookingService.getById(id);
        return BookingDto.fromBooking(booking);
    }

    @PostMapping
    public void planBooking(@RequestBody BookingInputDto dto) {
        bookingService.planBooking(dto.startTime, dto.endTime, dto.tafelId, dto.username);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable("id") Long id) {
        bookingService.deleteBooking(id);
    }

    @PutMapping("/{id}")
    public void updateBooking(@PathVariable("id") Long id, Booking booking) {
        bookingService.updateBooking(id, booking);
    }
}
