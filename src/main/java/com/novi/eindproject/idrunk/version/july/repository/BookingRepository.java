package com.novi.eindproject.idrunk.version.july.repository;
import com.novi.eindproject.idrunk.version.july.model.Booking;
import com.novi.eindproject.idrunk.version.july.model.Tafel;
import com.novi.eindproject.idrunk.version.july.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBookingByDate(LocalDateTime date);

    List<Booking> findBookingByUser(User user);

    List<Booking> findByTafel(Tafel tafel);

    List <Booking> findByStartTimeBetweenAndTafel(String startTime, String endTime, Tafel tafel);

    List <Booking>  findByEndTimeBetweenAndTafel(String startTime, String endTime, Tafel tafel);
}

