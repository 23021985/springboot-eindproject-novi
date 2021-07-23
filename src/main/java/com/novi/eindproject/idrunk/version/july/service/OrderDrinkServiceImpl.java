package com.novi.eindproject.idrunk.version.july.service;

import com.novi.eindproject.idrunk.version.july.exceptions.RecordNotFoundException;
import com.novi.eindproject.idrunk.version.july.model.OrderDrink;
import com.novi.eindproject.idrunk.version.july.repository.OrderDrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderDrinkServiceImpl implements OrderDrinkService {

    private OrderDrinkRepository orderDrinkRepository;

    @Autowired
    public OrderDrinkServiceImpl(OrderDrinkRepository orderDrinkRepository) {
        this.orderDrinkRepository = orderDrinkRepository;
    }

    @Override
    public OrderDrink getOrderDrink(Long id) {
        Optional<OrderDrink> orderDrink = orderDrinkRepository.findById(id);
        if (orderDrink.isPresent()) {
            return orderDrink.get();
        } else {
            throw new RecordNotFoundException("Het drankje is niet gevonden");
        }
    }

    @Override
    public void deleteOrderDrink(Long id) {
        orderDrinkRepository.deleteById(id);
    }

    @Override
    public void updateOrderDrink(Long id, OrderDrink orderDrink) {
        Optional<OrderDrink> optionalOrderDrink = orderDrinkRepository.findById(id);
        if (optionalOrderDrink.isPresent()) {
            orderDrinkRepository.deleteById(id);
            orderDrinkRepository.save(orderDrink);
        } else {
            throw new RecordNotFoundException("Het drankje is niet gevonden");
        }
    }

    @Override
    public OrderDrink saveOrderDrink(OrderDrink orderDrink) {
        return orderDrinkRepository.save(orderDrink);
    }
}
