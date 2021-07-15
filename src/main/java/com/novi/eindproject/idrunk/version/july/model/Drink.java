package com.novi.eindproject.idrunk.version.july.model;

import com.novi.eindproject.idrunk.version.july.dto.DrinkDto;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Drink {

    public long getId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private double price;

    @Column
    private int amount;

    @Column
    private int count;


    @ManyToOne
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Order order;
    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public long getGetId() {
        return getId;
    }

    public void setGetId(long getId) {
        this.getId = getId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

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

    public static Drink from(DrinkDto drinkDto){
        Drink drink = new Drink();
        drink.setId(drinkDto.getId());
        drink.setAmount(drinkDto.getAmount());
        return drink;
    }
}
