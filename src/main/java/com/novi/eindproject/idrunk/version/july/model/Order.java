package com.novi.eindproject.idrunk.version.july.model;
import javax.persistence.*;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private int count;

    private boolean hasBeenServed;

    private String name;


    @OneToMany(mappedBy = "order")
    List<Drink> drinkList;

    @ManyToOne
    User user;

    @ManyToOne
    Tafel tafel;

    @ManyToOne
    OrderDrink orderDrink;


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

    public boolean isHasBeenServed() {
        return hasBeenServed;
    }

    public void setHasBeenServed(boolean hasBeenServed) {
        this.hasBeenServed = hasBeenServed;
    }

    public Object hasBeenServed() {
        return hasBeenServed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(String username) {
        this.user = user;
    }

    public Tafel getTafel() {
        return tafel;
    }

    public void setTafel(Tafel tafel) {
        this.tafel = tafel;
    }
}
