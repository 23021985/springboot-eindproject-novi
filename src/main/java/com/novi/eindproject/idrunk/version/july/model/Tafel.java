package com.novi.eindproject.idrunk.version.july.model;
import javax.persistence.*;
import java.util.List;


@Entity
public class Tafel {

    @Id
    @GeneratedValue
    private Long id;

    private Long tafelNr;

    private int maxGuest;

    @OneToMany(mappedBy = "tafel")
    List<Booking> bookings;

    public Long getTafelNr() {
        return tafelNr;
    }

    public void setTafelNr(Long tafelNr) {
        this.tafelNr = tafelNr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMaxGuest() {
        return maxGuest;
    }

    public void setMaxGuest(int maxGuest) {
        this.maxGuest = maxGuest;
    }

}