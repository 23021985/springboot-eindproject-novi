package com.novi.eindproject.idrunk.version.july.model;


import com.novi.eindproject.idrunk.version.july.dto.OrderDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "order_id")
    private List<Drink> drinks = new ArrayList<>();


    public void addDrink(Drink drink){
        drinks.add(drink);
    }

    public void removeDrink(Drink drink){
        drinks.remove(drink);
    }

    public int getAmount() {
        return 0;
    }

    public int getCount() {
        return 0;
    }

    public static Order from(OrderDto orderDto){
        Order order = new Order();
        order.setName(orderDto.getName());
        return order;
    }
}
