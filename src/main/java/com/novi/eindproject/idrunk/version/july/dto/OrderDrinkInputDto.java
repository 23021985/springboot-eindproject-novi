package com.novi.eindproject.idrunk.version.july.dto;

import com.novi.eindproject.idrunk.version.july.model.OrderDrink;

public class OrderDrinkInputDto {

    public Long id;
    public OrderDrink toOrderDrink;

    public OrderDrink toOrderDrink() {
        var orderDrink = new OrderDrink();
        orderDrink.setId(id);

        return orderDrink;
    }
}
