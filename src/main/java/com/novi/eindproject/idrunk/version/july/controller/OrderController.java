//package com.novi.eindproject.idrunk.version.july.controller;
//import com.novi.eindproject.idrunk.version.july.dto.DrinkDto;
//import com.novi.eindproject.idrunk.version.july.dto.OrderDto;
//import com.novi.eindproject.idrunk.version.july.dto.OrderInputDto;
//import com.novi.eindproject.idrunk.version.july.model.Order;
//import com.novi.eindproject.idrunk.version.july.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/orders")
//public class OrderController {
//
//    private final OrderService orderService;
//
//    @Autowired
//    public OrderController(OrderService orderService) {
//        this.orderService = orderService;
//    }
//
//    @GetMapping
//    public ResponseEntity<List<OrderDto>> getOrders(){
//        List<Order> orders = orderService.getOrders();
//        List<OrderDto> ordersDto = orders.stream().map(OrderDto::fromOrder).collect(Collectors.toList());
//        return new ResponseEntity<>(ordersDto, HttpStatus.OK);
//    }
//
//    @GetMapping(value = "{id}")
//    public ResponseEntity<OrderDto> getOrder(@PathVariable final Long id){
//        Order order = orderService.getOrder(id);
//        return new ResponseEntity<>(OrderDto.fromOrder(order), HttpStatus.OK);
//    }
//
//    @DeleteMapping(value = "{id}")
//    public ResponseEntity<OrderDto> deleteOrder(@PathVariable final Long id){
//        Order order = orderService.deleteOrder(id);
//        return new ResponseEntity<>(OrderDto.fromOrder(order), HttpStatus.OK);
//    }
//
//    @PostMapping
//    public OrderDto saveOrder (@RequestBody OrderInputDto dto){
//       var order = orderService.saveOrder(dto.toOrder());
//       return OrderDto.fromOrder(order);
//    }
//
//    @DeleteMapping(value = "{orderId}/drinks/{drinkId}/remove")
//    public ResponseEntity<OrderDto> removeDrinkFromOrder(@PathVariable final Long orderId,
//                                                    @PathVariable final Long drinkId,
//                                                         @PathVariable final String username){
//        Order order = (Order) orderService.deleteOrder(orderId);
//        return new ResponseEntity<>(OrderDto.fromOrder(order), HttpStatus.OK);
//    }
//}
