package com.novi.eindproject.idrunk.version.july.controller;

import com.novi.eindproject.idrunk.version.july.dto.OrderDrinkDto;
import com.novi.eindproject.idrunk.version.july.dto.OrderDrinkInputDto;
import com.novi.eindproject.idrunk.version.july.model.OrderDrink;
import com.novi.eindproject.idrunk.version.july.service.OrderDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderDrinks")
public class OrderDrinkController {

    private final OrderDrinkService orderDrinkService;

    @Autowired
    public OrderDrinkController(OrderDrinkService orderDrinkService) {
        this.orderDrinkService = orderDrinkService;
    }

    @GetMapping("/{id}")
    public OrderDrinkDto getOrderDrink(@PathVariable("id") Long id) {
        var orderDrink = orderDrinkService.getOrderDrink(id);
        return OrderDrinkDto.fromOrderDrink(orderDrink);
    }

    @PostMapping
    public OrderDrinkDto saveOrderDrink(@RequestBody OrderDrinkInputDto dto) {
        var orderDrink = orderDrinkService.saveOrderDrink(dto.toOrderDrink);
      return OrderDrinkDto.fromOrderDrink(orderDrink);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderDrink(@PathVariable("id") Long id) {
        orderDrinkService.deleteOrderDrink(id);
    }

    @PutMapping("/{id}")
    public void updateOrderDrink(@PathVariable("id") Long id, OrderDrink orderDrink) {
        orderDrinkService.updateOrderDrink(id, orderDrink);
    }

}
