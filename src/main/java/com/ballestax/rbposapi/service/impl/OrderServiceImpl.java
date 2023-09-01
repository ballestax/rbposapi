package com.ballestax.rbposapi.service.impl;

import com.ballestax.rbposapi.model.Order;
import com.ballestax.rbposapi.repository.OrderRepository;
import com.ballestax.rbposapi.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        super();
        this.orderRepository = orderRepository;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderByConsecutive(String consecutive) {
        return orderRepository.findOrderByConsecutive(consecutive);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findOrderById(id);
    }
}
