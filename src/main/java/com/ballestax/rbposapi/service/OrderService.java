package com.ballestax.rbposapi.service;

import com.ballestax.rbposapi.model.Order;

public interface OrderService {

    Order saveOrder(Order order);

    Order getOrderByConsecutive(String consecutive);

    Order getOrderById(Long id);
}
