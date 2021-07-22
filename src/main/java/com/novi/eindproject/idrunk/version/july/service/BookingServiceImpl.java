package com.novi.eindproject.idrunk.version.july.service;
import com.novi.eindproject.idrunk.version.july.exceptions.BadRequestException;
import com.novi.eindproject.idrunk.version.july.exceptions.RecordNotFoundException;
import com.novi.eindproject.idrunk.version.july.model.Booking;
import com.novi.eindproject.idrunk.version.july.model.Tafel;
import com.novi.eindproject.idrunk.version.july.repository.BookingRepository;
import com.novi.eindproject.idrunk.version.july.repository.TafelRepository;
import com.novi.eindproject.idrunk.version.july.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final TafelRepository tafelRepository;
    private final UserRepository userRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, TafelRepository tafelRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.tafelRepository = tafelRepository;
    }

    @Override
    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<Booking> getBookingsForTafel(Long tafelId) {
        var optionalTafel = tafelRepository.findById(tafelId);

        if (optionalTafel.isPresent()) {
            var tafel = optionalTafel.get();

            return bookingRepository.findByTafel(tafel);
        } else {
            throw new RecordNotFoundException("Er is helaas geen tafel gevonden..");
        }
    }

        @Override
        public List<Booking> getBookingsOnDate (LocalDateTime date) {
            return bookingRepository.findBookingByDate(date);
        }


            @Override
            public List<Booking> getBookingsByUserName (String username){
                var optionalUser = userRepository.findById(username);

                if (optionalUser.isPresent()) {
                    var user = optionalUser.get();

                    return bookingRepository.findBookingByUser(user);
                } else {
                    throw new RecordNotFoundException("Er zijn geen boekingen gevonden..");
                }
            }

            @Override
            public void deleteBooking (Long id){
                bookingRepository.deleteById(id);
            }

            @Override
            public void updateBooking (Long id, Booking booking){
                Optional<Booking> optionalBooking = bookingRepository.findById(id);
                if (optionalBooking.isPresent()) {
                    bookingRepository.deleteById(id);
                    bookingRepository.save(booking);
                } else {
                    throw new RecordNotFoundException("De boeking is helaas niet gevonden");
                }
            }

            @Override
            public void planBooking (String startTime, String endTime, Long tafelId, String username, LocalDateTime date)
            {
                var optionalTafel = tafelRepository.findById(tafelId);
                var optionalUser = userRepository.findById(username);

                if (optionalTafel.isEmpty() || optionalUser.isEmpty()) {
                    throw new BadRequestException("Helaas, kapot");
                }

                var tafel = optionalTafel.get();
                var user = optionalUser.get();

                if (tafel != null) {
                    validateBookingSlotIsFreeTafel(startTime, endTime, tafel);
                }
                var booking = new Booking();
                booking.setTafel(tafel);
                booking.setUser(user);
                booking.setDate(date);
                booking.setStartTime(startTime);
                booking.setEndTime(endTime);

                bookingRepository.save(booking);

            }

            private void validateBookingSlotIsFreeTafel (String startTime, String endTime, Tafel tafel){
                var overlappingStartBooking = bookingRepository.findByStartTimeBetweenAndTafel(startTime, endTime, tafel);
                var overlappingEndBooking = bookingRepository.findByEndTimeBetweenAndTafel(startTime, endTime, tafel);

                if (overlappingStartBooking.size() > 0 || overlappingEndBooking.size() > 0) {
                    throw new BadRequestException("Overlapping gevonden in de begin en eindtijd");
                }
            }

            @Override
            public Booking getById (Long id){
                var optionalBooking = bookingRepository.findById(id);
                if (optionalBooking.isPresent()) {
                    return optionalBooking.get();
                } else {
                    throw new RecordNotFoundException("De boeking is helaas niet gevonden");
                }
            }
        }


