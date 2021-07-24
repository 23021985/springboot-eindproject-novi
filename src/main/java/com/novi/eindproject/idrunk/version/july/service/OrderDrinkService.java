package com.novi.eindproject.idrunk.version.july.service;

import com.novi.eindproject.idrunk.version.july.model.OrderDrink;

public interface OrderDrinkService {

    OrderDrink getOrderDrink(Long id);

    void deleteOrderDrink(Long id);

    void updateOrderDrink(Long id, OrderDrink orderDrink);

    OrderDrink saveOrderDrink(OrderDrink orderDrink);


}
