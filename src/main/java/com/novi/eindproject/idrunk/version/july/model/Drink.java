package com.novi.eindproject.idrunk.version.july.model;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Drink {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private double price;

    private int amount;

//    @ManyToMany(mappedBy = "orderedDrinks")
//    Set<Order> OrderId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}


