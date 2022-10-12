package com.bacon57.baconapi.service;

import com.bacon57.baconapi.model.Order;

public interface OrderService {

    Order saveOrder(Order order);

    Order getOrderByConsecutive(String consecutive);

    Order getOrderById(Long id);
}
