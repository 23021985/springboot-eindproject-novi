package com.novi.eindproject.idrunk.version.july.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.novi.eindproject.idrunk.version.july.model.Booking;

import java.time.LocalDateTime;

public class BookingDto {

    @JsonSerialize
    Long id;

    @JsonSerialize
    TafelDto tafel;

    @JsonSerialize
    UserDto user;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime startTime;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime endTime;

    public static BookingDto fromBooking(Booking booking) {
        var dto = new BookingDto();
        dto.id = booking.getId();
        dto.tafel = TafelDto.fromTafel(booking.getTafel());
        dto.user = UserDto.fromUser(booking.getUser());
        dto.startTime = booking.getPlannedStartTime();
        dto.endTime = booking.getPlannedEndTime();
        return dto;

    }

}
