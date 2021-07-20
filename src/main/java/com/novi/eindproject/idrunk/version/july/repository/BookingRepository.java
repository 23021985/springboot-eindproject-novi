package com.novi.eindproject.idrunk.version.july.repository;
import com.novi.eindproject.idrunk.version.july.model.Booking;
import com.novi.eindproject.idrunk.version.july.model.Tafel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findBookingByDate(LocalDateTime date);

    List<Booking> findBookingByUsername(String username);

    List<Booking> findByTafel(Long tafelId);

    List <Booking> findByBookingStartTimeBetweenAndTafel(String bookingStartTime, String endTime, Tafel tafel);

    List <Booking>  findByBookingEndTimeBetweenAndTafel(String bookingStartTime, String bookingEndTime, Tafel tafel);
}

