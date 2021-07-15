package com.novi.eindproject.idrunk.version.july.service;

import com.novi.eindproject.idrunk.version.july.exceptions.DrinkIsAlreadyAssignedException;
import com.novi.eindproject.idrunk.version.july.exceptions.OrderNotFoundException;
import com.novi.eindproject.idrunk.version.july.model.Drink;
import com.novi.eindproject.idrunk.version.july.model.Order;
import com.novi.eindproject.idrunk.version.july.repository.DrinkRepository;
import com.novi.eindproject.idrunk.version.july.repository.OrderRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Data
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final DrinkRepository drinkRepository;

//    private Long id;
    
    @Autowired
    public OrderService(OrderRepository orderRepository, DrinkRepository drinkRepository) {
        this.orderRepository = orderRepository;
        this.drinkRepository = drinkRepository;
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrders() {
        return StreamSupport
                .stream(orderRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(() ->
                new OrderNotFoundException(id));
    }

    public Order deleteOrder(Long id) {
//        this.id = id;
        Order order = getOrder(id);
        orderRepository.delete(order);
        return order;
    }

    @Transactional
    public Order editOrder(Long id, Order order) {
        Order orderToEdit = getOrder(id);
        orderToEdit.setName(order.getName());
        return orderToEdit;
    }

    @Autowired
    public DrinkService drinkService;

    @Transactional
    public Order addDrinkToOrder(Long orderId, Long drinkId) {
        Order order = getOrder(orderId);
        Drink drink = drinkService.getDrink(drinkId);
        if(Objects.nonNull(drink.getOrder())){
throw new DrinkIsAlreadyAssignedException(drinkId,
        drink.getOrder().getId());
        }
        order.addDrink(drink);
        return order;
    }

    @Transactional
    public Order removeDrinkFromOrder(Long orderId, Long drinkId) {
        Order order = getOrder(orderId);
        Drink drink = drinkService.getDrink(drinkId);
        order.removeDrink(drink);
        return order;
    }
}


//volgende stappen, foutmeldingen wegwerken. Ik denk in de drinkservice