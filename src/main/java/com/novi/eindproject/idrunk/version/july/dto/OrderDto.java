package com.novi.eindproject.idrunk.version.july.dto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.novi.eindproject.idrunk.version.july.model.Drink;
import com.novi.eindproject.idrunk.version.july.model.Order;
import lombok.Data;

@Data
public class OrderDto {

    Long id;

    @JsonSerialize
    DrinkDto drink;

    @JsonSerialize
    UserDto user;

    double count;

    public static OrderDto fromOrder(Order order) {
        var dto = new OrderDto();
        dto.id = order.getId();
        dto.drink = DrinkDto.fromDrink((Drink) order.hasBeenServed());
        dto.user = UserDto.fromUser(order.getUser());
        dto.count = order.getCount();

        return dto;
    }


}
