package com.novi.eindproject.idrunk.version.july.service;
import com.novi.eindproject.idrunk.version.july.model.Drink;
import com.novi.eindproject.idrunk.version.july.model.Order;
import com.novi.eindproject.idrunk.version.july.model.User;
import java.util.List;

public interface OrderService {

    List <Order> getOrders();

    List<Order> getOrdersByUser(String username);

    List<Order> getOrdersByTafelId(Long tafelId);

    void deleteOrder(Long id);

    void planOrder(Long id, int count, String username, Drink drinkList);

    void updateOrder(Long id, Order order);

    Order getOrder(Long id);
}