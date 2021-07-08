package com.novi.eindproject.idrunk.version.july.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Tafel tafel;

    @ManyToOne
    User user;

    LocalDateTime plannedStartTime;

    LocalDateTime plannedEndTime;

    LocalDateTime actualStartTime;

    LocalDateTime actualEndTime;


    @Column
    private String bookingName;

    @Column
    private String bookingDate;

    @Column
    private String timeOfBooking;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getTimeOfBooking() {
        return timeOfBooking;
    }

    public void setTimeOfBooking(String timeOfBooking) {
        this.timeOfBooking = timeOfBooking;
    }

    public boolean isHasArrived() {
        return hasArrived;
    }

    public void setHasArrived(boolean hasArrived) {
        this.hasArrived = hasArrived;
    }

    @Column
    private boolean hasArrived;

    public Booking(long id, String bookingName, String bookingDate, String timeOfBooking, boolean hasArrived) {
        this.id = id;
        this.bookingName = bookingName;
        this.bookingDate = bookingDate;
        this.timeOfBooking = timeOfBooking;
        this.hasArrived = hasArrived;
    }

    public Booking() {

    }


    public void setPlannedStartTime(LocalDateTime startTime) {
    }

    public void setPlannedEndTime(LocalDateTime endTime) {
    }

    public LocalDateTime getPlannedStartTime() {
        return null;
    }

    public LocalDateTime getPlannedEndTime() {
        return null;
    }

    public Tafel getTafel() {
        return null;
    }

    public User getUser() {
        return null;
    }
}
