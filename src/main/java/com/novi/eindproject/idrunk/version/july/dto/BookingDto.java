package com.novi.eindproject.idrunk.version.july.dto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.novi.eindproject.idrunk.version.july.model.Booking;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BookingDto {

    Long id;

    String startTime;

    String endTime;

    @JsonSerialize
    TafelDto tafel;

    @JsonSerialize
    UserDto user;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime date;


    public static BookingDto fromBooking(Booking booking) {
        var dto = new BookingDto();
        dto.id = booking.getId();
        dto.tafel = TafelDto.fromTafel(booking.getTafel());
        dto.user = UserDto.fromUser(booking.getUser());
        dto.startTime = booking.getStartTime();
        dto.date = booking.getDate();
        dto.endTime = booking.getEndTime();

        return dto;
    }
}
