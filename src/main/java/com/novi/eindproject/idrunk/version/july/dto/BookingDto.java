package com.novi.eindproject.idrunk.version.july.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.novi.eindproject.idrunk.version.july.model.Booking;
import com.novi.eindproject.idrunk.version.july.model.BookingStatus;
import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

public class BookingDto {

    @JsonSerialize
    Long id;

    @JsonSerialize
    TafelDto tafel;

    @JsonSerialize
    UserDto user;

    @JsonSerialize
    String startTime;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime date;


    public static BookingDto fromBooking(Booking booking) {
        var dto = new BookingDto();
        dto.id = booking.getId();
        dto.tafel = TafelDto.fromTafel(booking.getTafel());
        dto.user = UserDto.fromUser(booking.getUser());
        dto.startTime = booking.getStartTime();
        dto.date = booking.getDate();
        return dto;
    }
}
