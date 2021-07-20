//package com.novi.eindproject.idrunk.version.july.model;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//public class Order {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    private int count;
//
//    @ManyToOne
//    private User user;
//
//    @ManyToMany
//    @JoinTable(
//            name = "drinksOrdered",
//            joinColumns = @JoinColumn(name = "orderId"),
//            inverseJoinColumns = @JoinColumn(name = "drinkId"))
//            Set<Drink> orderedDrinks;
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Set<Drink> getOrderedDrinks() {
//        return orderedDrinks;
//    }
//
//    public void setOrderedDrinks(Set<Drink> orderedDrinks) {
//        this.orderedDrinks = orderedDrinks;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public int getCount() {
//        return count;
//    }
//
//    public void setCount(int count) {
//    }
//
//    public void setDrink(Drink drink) {
//    }
//
//}
