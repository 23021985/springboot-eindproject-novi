package com.novi.eindproject.idrunk.version.july.dto;
import com.novi.eindproject.idrunk.version.july.model.Order;
import lombok.Data;

@Data
public class OrderDto {

    Long id;

    private String name;

    DrinkDto drink;

    UserDto user;

    int amount;

    double count;

    public static OrderDto fromOrder(Order order) {
        var dto = new OrderDto();
        dto.id = order.getId();
        dto.name = order.getName();
        dto.drink = DrinkDto.fromDrink(order.getDrink());
        dto.user = UserDto.fromUser(order.getUser());
        dto.amount = order.getAmount();
        dto.count = order.getCount();

        return dto;
    }
}
