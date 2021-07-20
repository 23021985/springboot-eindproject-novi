package com.novi.eindproject.idrunk.version.july.service;
import com.novi.eindproject.idrunk.version.july.model.Booking;
import com.novi.eindproject.idrunk.version.july.model.Drink;
import com.novi.eindproject.idrunk.version.july.model.Order;
import java.util.List;

public interface OrderService {

    List <Order> getOrders();

    List <Order> getOrders(long id);

    List <Order> getOrdersById(long id);

    Order addDrinkToOrder(Order orderId, Long drinkId, String username);

    Order deleteOrder(Long id);

    Order getOrder(Long id);

    List <Order> saveOrder(Order order, Long drinkId, String username);
}