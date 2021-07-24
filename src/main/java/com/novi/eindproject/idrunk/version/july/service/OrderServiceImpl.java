package com.novi.eindproject.idrunk.version.july.service;
import com.novi.eindproject.idrunk.version.july.exceptions.BadRequestException;
import com.novi.eindproject.idrunk.version.july.exceptions.RecordNotFoundException;
import com.novi.eindproject.idrunk.version.july.model.Drink;
import com.novi.eindproject.idrunk.version.july.model.Order;
import com.novi.eindproject.idrunk.version.july.repository.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Data
@Service
class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final TafelRepository tafelRepository;
    private final OrderDrinkRepository orderDrinkRepository;

    @Autowired
    OrderServiceImpl(OrderDrinkRepository orderDrinkRepository, OrderRepository orderRepository, UserRepository userRepository, TafelRepository tafelRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.tafelRepository = tafelRepository;
        this.orderDrinkRepository = orderDrinkRepository;
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByUser(String username) {
        var optionalUser = userRepository.findById(username);

        if (optionalUser.isPresent()) {
            var user = optionalUser.get();

            return orderRepository.findByUser(user);

        } else {
            throw new RecordNotFoundException("De order is helaas niet gevonden");
        }
    }

    @Override
    public List<Order> getOrdersByTafelId(Long tafelId) {
        var optionalTafel = tafelRepository.findById(tafelId);

        if (optionalTafel.isPresent()) {
            var tafel = optionalTafel.get();


            return orderRepository.findByTafel(tafel);
        } else {
            throw new RecordNotFoundException("De order is helaas niet gevonden");
        }
    }

    @Override
    public void updateOrder(Long id, Order order) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            orderRepository.deleteById(id);
            orderRepository.save(order);
        } else {
            throw new RecordNotFoundException("De bestelling is helaas niet gevonden");
        }
    }

    @Override
    public Order getOrder(Long id) {
        var optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isEmpty()) {
            throw new RecordNotFoundException("De bestelling is helaas niet gevonden");
        } else {
            return optionalOrder.get();
        }
    }

    @Override
    public void deleteOrder(Long id) {
        orderDrinkRepository.deleteById(id);
    }

    @Override
    public void planOrder(Long id, int count, String username, Drink drinkList) {
        var optionalUser = userRepository.findById(username);
        var optionalOrderDrink = orderDrinkRepository.findById(id);

        if (optionalUser.isEmpty() ) {
            throw new BadRequestException("Er zijn geen resulataten om weer te geven");
        }
        if (optionalOrderDrink == null) {
            throw new RecordNotFoundException("Helaas er is geen drankje ingevuld");
        }

        var User = optionalUser.get();
        var orderDrink = optionalOrderDrink.get();

        var order = new Order();
        order.setUser(username);
        order.setCount(count);
        order.setId(id);
        orderRepository.save(order);
    }
}