package com.novi.eindproject.idrunk.version.july.model;


import javax.persistence.*;

@Entity
@Table
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String bookingName;

    @Column
    private String bookingDate;

    @Column
    private String timeOfBooking;

    @Column
    private boolean hasArrived;

    public Booking(int id, String bookingName, String bookingDate, String timeOfBooking, boolean hasArrived) {
        this.id = id;
        this.bookingName = bookingName;
        this.bookingDate = bookingDate;
        this.timeOfBooking = timeOfBooking;
        this.hasArrived = hasArrived;
    }

    public Booking() {

    }
}
