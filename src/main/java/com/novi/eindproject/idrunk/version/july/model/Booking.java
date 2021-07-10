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

        @ManyToOne
        Drink drink;

        LocalDateTime plannedStartTime;

        LocalDateTime plannedEndTime;

        private BookingStatus status;

        LocalDateTime actualStartTime;

        LocalDateTime actualEndTime;

//        Double charge;
//
//        BookingStatus status;
//
//        @Column
//        private String plannedStartTime;

        // Getters
        public Long getId() {
            return id;
        }

        public Tafel getTafel() {
            return tafel;
        }

        public User getUser() {
            return user;
        }

        public LocalDateTime getPlannedStartTime() {
            return plannedStartTime;
        }

        public LocalDateTime getPlannedEndTime() {
            return plannedEndTime;
        }

        public LocalDateTime getActualStartTime() {
            return actualStartTime;
        }

        public LocalDateTime getActualEndTime() {
            return actualEndTime;
        }

        public BookingStatus getStatus() {
            return status;
        }

//        public Double getCharge() {
//            return charge;
//        }

        // Setters
        public void setId(Long id) {
            this.id = id;
        }

        public void setTafel(Tafel tafel) {
            this.tafel = tafel;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public void setPlannedStartTime(LocalDateTime plannedStartTime) {
            this.plannedStartTime = plannedStartTime;
        }

        public void setPlannedEndTime(LocalDateTime plannedEndTime) {
            this.plannedEndTime = plannedEndTime;
        }

        public void setActualStartTime(LocalDateTime actualStartTime) {
            this.actualStartTime = actualStartTime;
        }

        public void setActualEndTime(LocalDateTime actualEndTime) {
            this.actualEndTime = actualEndTime;
        }

        public void setStatus(BookingStatus status) {
            this.status = status;
        }

}
