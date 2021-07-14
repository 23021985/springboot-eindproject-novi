package com.novi.eindproject.idrunk.version.july.service;
import com.novi.eindproject.idrunk.version.july.exceptions.NotFoundException;
import com.novi.eindproject.idrunk.version.july.model.Booking;
import com.novi.eindproject.idrunk.version.july.repository.BookingRepository;
import com.novi.eindproject.idrunk.version.july.repository.TafelRepository;
import com.novi.eindproject.idrunk.version.july.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    private BookingRepository bookingRepository;
    private TafelRepository tafelRepository;
    private UserRepository userRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, TafelRepository tafelRepository, UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.tafelRepository = tafelRepository;
    }


    public List<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookings(long id) {
        return bookingRepository.getById(id);
    }

    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void removeBooking(long id) {
        bookingRepository.deleteById(id);
    }

    public void updateBooking(long id) {

    }


    @Override
    public List<Booking> getBookingsOnDate(LocalDateTime date) {
        return bookingRepository.findBookingByDate(date);
    }

    @Override
    public List<Booking> getBookingsByUsername(String username) {
        return bookingRepository.findBookingByUser(username);
    }

    @Override
    public Booking saveBooking(Booking booking, Long tafelId, String username) {
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingsForTafel(Long tafelId) {
        return null;
    }

    @Override
    public List<Booking> getBookingsForUser(String username) {
        var optionalUser = userRepository.findById(username);

        if (optionalUser.isPresent()) {
            var user = optionalUser.get();
            return bookingRepository.findByUser(user);
        } else {
            throw new NotFoundException();
        }
    }
}


//@Service
//    public class BookingServiceImpl implements BookingService{
//
//    private BookingRepository bookingRepository;
//    private TafelRepository tafelRepository;
//    private UserRepository userRepository;
//
//   @Autowired
//   public BookingServiceImpl(BookingRepository bookingRepository, TafelRepository tafelRepository, UserRepository userRepository){
//       this.bookingRepository = bookingRepository;
//       this.tafelRepository = tafelRepository;
//       this.userRepository = userRepository;
//   }
//
//    @Override
//    public List<Booking> getBookingsBetweenDates(LocalDateTime start, LocalDateTime end) {
//        return bookingRepository.findByPlannedStartTimeBetween(start, end);
//    }
//
//    @Override
//    public List<Booking> getBookingsForTafel(Long tafelId) {
////        var optionalTafel = tafelRepository.findById(tafelId);
////
////        if (optionalTafel.isPresent()) {
////            var tafel = optionalTafel.get();
////            return bookingRepository.findByTafel(tafel);
////        } else {
////            throw new NotFoundException();
////        }
//        return null;
//    }
//
//    @Override
//    public List<Booking> getBookingsForUser(String username) {
////        var optionalUser = UserRepository.findByUsername(username);
//
////        if (optionalUser.isPresent()) {
////            var user = optionalUser.get();
////            return bookingRepository.findByUser(user);
////        } else {
////            throw new NotFoundException();
////        }
//        return bookingRepository.findBookingByUsername(username);
//    }
//
//    public Booking planBooking(Long id, String tafelId, String username, LocalDateTime plannedStartTime, LocalDateTime plannedEndTime) {
////        var optionalUser = UserRepository.findByUsername(username);
////        var optionalTafel = tafelRepository.findById(tafelId);
////
////        // If either the user or tafel does not exist, we throw an exception
////        if (optionalUser.isEmpty() || optionalTafel.isEmpty()) {
////            throw new NotFoundException();
////        }
////
////        var user = optionalUser.get();
////        var tafel = optionalTafel.get();
//
//        // Checks whether there is an overlap in the schedule, if there is an overlap it throws an exception
////        validateBookingSlotIsFree(plannedStartTime, plannedEndTime, tafel);
//
//        // The booking details are valid, we create it and store it in the database
//
//        var booking = new Booking();
//        booking.setId(id);
////        booking.setUser(username);
////        booking.setTafel(tafelId);
//        booking.setPlannedStartTime(plannedStartTime);
//        booking.setPlannedEndTime(plannedEndTime);
//        booking.setStatus(BookingStatus.PLANNED);
//
//        return bookingRepository.save(booking);
//    }
//
//    @Override
//    public Booking completeBooking(Long bookingId, LocalDateTime actualStartTime, LocalDateTime actualEndTime) {
//        return null;
//    }
//
////    private void validateBookingSlotIsFree(LocalDateTime startTime, LocalDateTime endTime, Tafel tafel) {
////        var overlappingStartBookings = bookingRepository.findByPlannedStartTimeBetweenAndTafel(startTime,
////                endTime, tafel);
////        var overlappingEndBookings = bookingRepository.findByPlannedEndTimeBetweenAndTafel(startTime,
////                endTime, tafel);
////        if (overlappingStartBookings.size() > 0 || overlappingEndBookings.size() > 0) {
////            throw new BadRequestException();
////        }
////    }
//
////    @Override
////    public Booking completeBooking(Long bookingId, LocalDateTime actualStartTime, LocalDateTime actualEndTime) {
////        var optionalBooking = bookingRepository.findById(bookingId);
////
////        if (optionalBooking.isEmpty()) {
////            throw new NotFoundException();
////        }
////        var booking = optionalBooking.get();
//
////        Calculate the booking charge
////        var baseCharge = calculationService.calculateCharge(actualStartTime, actualEndTime);
////        var discount = calculationService.calculateDiscount(baseCharge, booking.getDiscountCode());
////        var charge = baseCharge - discount;
//
//        // Update and save the booking
////        booking.setId(id);
////        booking.setActualStartTime(actualStartTime);
////        booking.setActualEndTime(actualEndTime);
////        booking.setStatus(BookingStatus.INVOICED);
////        booking.setCharge(charge);
//
////        return bookingRepository.save(booking);
//    }

