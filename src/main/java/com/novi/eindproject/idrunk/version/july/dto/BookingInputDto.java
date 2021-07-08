package com.novi.eindproject.idrunk.version.july.dto;

import com.novi.eindproject.idrunk.version.july.model.Booking;

import java.time.LocalDateTime;

public class BookingInputDto {

    public Long tafelId;
    public Long customerId;

    public LocalDateTime startTime;
    public LocalDateTime endTime;

    public Booking toBooking() {
        var booking = new Booking();
        booking.setPlannedStartTime(startTime);
        booking.setPlannedEndTime(endTime);
        return booking;
    }
}
