package com.novi.eindproject.idrunk.version.july.dto;

import com.novi.eindproject.idrunk.version.july.model.Booking;

import java.time.LocalDateTime;

public class BookingInputDto {
    public Long tafelId;

    public String startTime;

    public LocalDateTime date;

    public String username;

    public Booking toBooking() {
        var booking = new Booking();
        booking.setStartTime(startTime);
        booking.setDate(date);
        return booking;
    }
}
