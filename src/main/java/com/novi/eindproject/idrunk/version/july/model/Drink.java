package com.novi.eindproject.idrunk.version.july.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.novi.eindproject.idrunk.version.july.dto.DrinkDto;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@JsonSerialize
@Data
@Entity
@Table
public class Drink {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private double price;

    @Column
    private int amount;

    @ManyToMany
    Set<Order> OrderId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

//    public long getGetId() {
//        return getId;
//    }

//    public void setGetId(long getId) {
//        this.getId = getId;
//    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public void setCount(int count) {
//        this.count = count;
//    }

//    public Order getOrder() {
//        return order;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCount() {
        return 0;
    }

    public void addToOrder(Order order) {
    }

    public void removeDrinkFromOrder(Order order) {
    }

    public Order getOrder() {
        Order order = new Order();
        return order;
    }

//    public static Drink from(DrinkDto drinkDto){
//        Drink drink = new Drink();
//        drink.setId(drinkDto.getId());
//        drink.setAmount(drinkDto.getAmount());
//        drink.setName(drinkDto.getName());
////        drink.setCount(drinkDto.getCount());
//        drink.setPrice(drinkDto.getPrice());
//        return drink;
//    }
}
