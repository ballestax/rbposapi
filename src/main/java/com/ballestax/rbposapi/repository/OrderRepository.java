package com.ballestax.rbposapi.repository;

import com.ballestax.rbposapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findOrderByConsecutive(String consecutive);

    Order findOrderById(Long id);
}
