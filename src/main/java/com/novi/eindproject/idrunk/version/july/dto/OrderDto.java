package com.novi.eindproject.idrunk.version.july.dto;


import com.novi.eindproject.idrunk.version.july.model.Drink;
import com.novi.eindproject.idrunk.version.july.model.Order;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class OrderDto {
    private Long id;
    public int count;
    public double price;
    public String name;
    public int amount;
    private List<DrinkDto> drinksDto = new ArrayList<>();

    public static OrderDto from(Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setAmount(order.getAmount());
        orderDto.setCount(order.getCount());
        orderDto.setDrinksDto(order.getDrinks().stream().map(DrinkDto::from).collect(Collectors.toList()));
        return orderDto;
    }

}
