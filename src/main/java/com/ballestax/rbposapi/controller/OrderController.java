package com.ballestax.rbposapi.controller;

import com.ballestax.rbposapi.model.Order;
import com.ballestax.rbposapi.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping()
    public ResponseEntity<Order> saveInvoice(@RequestBody Order order) {
        return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.CREATED);
    }

    @GetMapping("find/{consecutive}")
    public ResponseEntity<Order> getOrderByCode(@PathVariable("consecutive") String consecutive) {
        return new ResponseEntity<Order>(orderService.getOrderByConsecutive(consecutive), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id) {
        return new ResponseEntity<Order>(orderService.getOrderById(id), HttpStatus.OK);
    }

}
