package com.novi.eindproject.idrunk.version.july.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class OrderDrink {

    @Id
    @GeneratedValue
    Long id;

    @OneToMany(mappedBy = "orderDrink")
    List<Drink> drinks;

    @OneToMany(mappedBy = "orderDrink")
    List<Order> orders;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
