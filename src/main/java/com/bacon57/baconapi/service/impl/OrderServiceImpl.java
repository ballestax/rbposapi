package com.bacon57.baconapi.service.impl;

import com.bacon57.baconapi.model.Order;
import com.bacon57.baconapi.repository.OrderRepository;
import com.bacon57.baconapi.service.OrderService;
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
