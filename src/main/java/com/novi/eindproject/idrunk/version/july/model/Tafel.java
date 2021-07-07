package com.novi.eindproject.idrunk.version.july.model;

import javax.persistence.*;

@Entity
@Table
public class Tafel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int tafelNr;

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

    @Column
    private String bookedBy;

    @Column boolean hasArived;

    public Tafel(int id, int tafelNr, String time, String date, String bookingName, int maxGuest, boolean isFree, String bookedBy, boolean hasArived){
        this.id = id;
        this.tafelNr = tafelNr;
        this.time = time;
        this.date = date;
        this.bookingName = bookingName;
        this.maxGuest = maxGuest;
        this.isFree = isFree;
        this.bookedBy = bookedBy;
        this.hasArived = hasArived;
    }

    public Tafel() {

    }

    public String getBookingName() {
        return bookingName;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    public int getTafelNr() {
        return tafelNr;
    }

    public void setTafelNr(int tafelNr) {
        this.tafelNr = tafelNr;
    }


    public Tafel(int tafelNr) {
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
