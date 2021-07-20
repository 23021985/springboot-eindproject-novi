package com.novi.eindproject.idrunk.version.july.dto;

import com.novi.eindproject.idrunk.version.july.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderInputDto {

    private Long id;
    public int count;
    public double price;
    public String name;
    public int amount;
    private List<DrinkDto> drinksDto = new ArrayList<>();

    public Order toOrder(){
       var order = new Order();
       order.setId(id);
       order.setCount(count);
       order.setPrice(price);
       order.setName(name);
       order.setAmount(amount);
       return order;
    }
}
