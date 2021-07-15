package com.novi.eindproject.idrunk.version.july.model;

import javax.persistence.*;
import java.util.List;


@Entity
public class Tafel {


    @Column
    private Long tafelNr;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int maxGuest;

    @OneToMany(mappedBy = "tafel")
    List<Booking> bookings;


    public Tafel(Long tafelNr, int maxGuest) {
        this.tafelNr = tafelNr;
        this.maxGuest = maxGuest;
    }

    public Tafel() {

    }

    public Long getTafelNr() {
        return tafelNr;
    }

    public void setTafelNr(Long tafelNr) {
        this.tafelNr = tafelNr;
    }

    public Long getId() {
        return id;
    }

    public int getMaxGuest() {
        return maxGuest;
    }

    public void setMaxGuest(int maxGuest) {
        this.maxGuest = maxGuest;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

}