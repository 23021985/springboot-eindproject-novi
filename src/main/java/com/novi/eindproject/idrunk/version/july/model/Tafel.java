package com.novi.eindproject.idrunk.version.july.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Entity
@Table
public class Tafel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "tafel")
    List<Booking> bookings;

    @Column
    private Long tafelNr;

    @Column
    private String time;

    @Column
    private String date;

    @Column
    private String bookingName;

    @Column
    private int maxGuest;

    @Column
    private boolean isFree;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public boolean isHasArived() {
        return hasArived;
    }

    @Column
    private Long amount;

    @Column
    private String bookedBy;

    @Column boolean hasArived;

    public Tafel(Long id, Long tafelNr, String time, String date, String bookingName, int maxGuest, boolean isFree, String bookedBy, boolean hasArived, Long amount){
        this.id = id;
        this.tafelNr = tafelNr;
        this.time = time;
        this.date = date;
        this.bookingName = bookingName;
        this.maxGuest = maxGuest;
        this.isFree = isFree;
        this.bookedBy = bookedBy;
        this.hasArived = hasArived;
        this.amount = amount;
    }

    public Tafel() {

    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public Long getTafelNr() {
        return tafelNr;
    }

    public void setTafelNr(Long tafelNr) {
        this.tafelNr = tafelNr;
    }


    public Tafel(Long tafelNr) {
        this.tafelNr = tafelNr;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }

    public int getMaxGuest() {
        return maxGuest;
    }

    public void setMaxGuest(int maxGuest) {
        this.maxGuest = maxGuest;
    }

    public boolean hasArived() {
        return hasArived;
    }


    public void setHasArived(boolean hasArived) {
        this.hasArived = hasArived;
    }

}
