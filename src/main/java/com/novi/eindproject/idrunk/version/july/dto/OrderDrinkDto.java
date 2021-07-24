package com.novi.eindproject.idrunk.version.july.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.novi.eindproject.idrunk.version.july.model.OrderDrink;
import lombok.Data;

@Data
public class OrderDrinkDto {

   public Long id;

    @JsonSerialize
    OrderDto order;

    @JsonSerialize
    DrinkDto drink;


    public static OrderDrinkDto fromOrderDrink(OrderDrink orderDrink) {
        var dto = new OrderDrinkDto();
        dto.id = orderDrink.getId();

        return dto;
    }
}
