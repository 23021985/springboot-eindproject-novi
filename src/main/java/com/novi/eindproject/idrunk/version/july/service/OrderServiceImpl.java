package com.novi.eindproject.idrunk.version.july.service;
        import com.novi.eindproject.idrunk.version.july.exceptions.BadRequestException;
        import com.novi.eindproject.idrunk.version.july.exceptions.NotFoundException;
        import com.novi.eindproject.idrunk.version.july.exceptions.OrderNotFoundException;
        import com.novi.eindproject.idrunk.version.july.model.Order;
        import com.novi.eindproject.idrunk.version.july.repository.DrinkRepository;
        import com.novi.eindproject.idrunk.version.july.repository.OrderRepository;
        import com.novi.eindproject.idrunk.version.july.repository.UserRepository;
        import lombok.Data;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import javax.transaction.Transactional;
        import java.util.List;
        import java.util.stream.Collectors;
        import java.util.stream.StreamSupport;

@Data
@Service
class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final DrinkRepository drinkRepository;
    private final UserRepository userRepository;

    @Autowired
    OrderServiceImpl(OrderRepository orderRepository, DrinkRepository drinkRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.drinkRepository = drinkRepository;
        this.userRepository = userRepository;
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getOrders() {
        return StreamSupport
                .stream(orderRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> getOrders(long id) {
        return orderRepository.getById(id);
    }

    @Override
    public List<Order> getOrdersById(long id) {
        return orderRepository.getById(id);
    }

//    @Override
//    public List<Order> FindOrdersByUserName(Long id) {
//        return orderRepository.getById(id);
//    }

    @Override
    public Order addDrinkToOrder(Order order, Long drinkId, String username) {
        return orderRepository.addDrinkToOrder(order, drinkId, username);
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(() ->
                new OrderNotFoundException(id));
    }

//    @Override
//    public List<Order> removeDrinkFromOrder(Long orderId, Long drinkId, String username) {
//        return (List<Order>) orderRepository.removeDrinkFromOrder(orderId, drinkId, username);
//    }

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
    @Override
    public List<Order> saveOrder(Order order, Long drinkId, String username) {
        var optionalUser = userRepository.findById(username);
        var optionalDrinks = drinkRepository.findById(drinkId);

        if (optionalDrinks.isPresent() && optionalUser.isPresent()) {
            var user = optionalUser.get();
            var drink = optionalDrinks.get();

            if (order.getAmount() >= drink.getAmount()) {
                throw new BadRequestException();
            }

            order.setDrink(drink);
            order.setUserByUsername(user);
            return (List<Order>) orderRepository.addDrinksToOrder(order, drinkId, username);
        } else {
            throw new NotFoundException();

            }
        }
    }



