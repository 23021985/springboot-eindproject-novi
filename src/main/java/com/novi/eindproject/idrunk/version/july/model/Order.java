package com.novi.eindproject.idrunk.version.july.model;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.novi.eindproject.idrunk.version.july.dto.OrderDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table
public class Order {

    @Id
    @JsonSerialize
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToMany
            @JoinTable(
                    name = "drinks_ordered",
                    joinColumns = @JoinColumn(name = "order_id"),
                    inverseJoinColumns = @JoinColumn(name = "drink_id"))
    Set<Drink> orderedDrinks;

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Drink> getOrderedDrinks() {
        return orderedDrinks;
    }

    public void setOrderedDrinks(Set<Drink> orderedDrinks) {
        this.orderedDrinks = orderedDrinks;
    }

    private String name;

    private int amount;

    private int count;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
    }

    public void setPrice(double price) {
    }

    public void setAmount(int amount) {
    }

    public User getUser() {
        return user;
    }


    public void setDrink(Drink drink) {
    }

    public void setUserByUsername(User username) {
    }

    public Drink getDrink() {
        Drink drink = new Drink();
        return drink;
    }
}
