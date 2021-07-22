package com.novi.eindproject.idrunk.version.july.model;
import javax.persistence.*;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private int count;

    private boolean hasBeenServed;

    private String name;

    @ManyToOne
    private Order order;

    @ManyToOne
    private User user;

    @ManyToOne
    private Drink drink;

    @ManyToOne
    private Tafel tafel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
    }
    public void setDrink(Drink drink) {
    }
    public boolean isHasBeenServed() {
        return hasBeenServed;
    }

    public void setHasBeenServed(boolean hasBeenServed) {
        this.hasBeenServed = hasBeenServed;
    }

    public Object hasBeenServed() {
        return hasBeenServed;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Drink getDrink() {
        return drink;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Tafel getTafel() {
        return tafel;
    }

    public void setTafel(Tafel tafel) {
        this.tafel = tafel;
    }

    public String getName() {
        return name;
    }
}
