package com.novi.eindproject.idrunk.version.july.controller;
import com.novi.eindproject.idrunk.version.july.dto.OrderDto;
import com.novi.eindproject.idrunk.version.july.dto.OrderInputDto;
import com.novi.eindproject.idrunk.version.july.exceptions.BadRequestException;
import com.novi.eindproject.idrunk.version.july.model.Order;
import com.novi.eindproject.idrunk.version.july.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDto>  getOrders(@RequestParam(value = "username") String username,
                                     @RequestParam(value = "tafelId") Long tafelId) {
        var dtos = new ArrayList<OrderDto>();
        List <Order> orders;

        if (username == null && tafelId == null) {
            orders = orderService.getOrders();
        } else if (username != null && tafelId == null) {
            orders = orderService.getOrdersByUser(username);
        } else if(username == null) {
            orders = orderService.getOrdersByTafelId(tafelId);
        } else {
            throw new BadRequestException("Helaas..");
        }

        for (Order order : orders) {
            dtos.add(OrderDto.fromOrder(order));
        }

        return dtos;
    }

    @GetMapping("/{id}")
    public OrderDto getOrder(@PathVariable("id") Long id) {
        var order = orderService.getOrder(id);
        return OrderDto.fromOrder(order);
    }

    @PostMapping
    public void planOrder(@RequestBody OrderInputDto dto) {
        orderService.planOrder(dto.id, dto.count, dto.user, dto.drink);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
    }

    @PutMapping("/{id}")
    public void updateOrder(@PathVariable("id") Long id, Order order) {
        orderService.updateOrder(id, order);
    }
}

