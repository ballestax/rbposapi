package com.bacon57.baconapi.repository;

import com.bacon57.baconapi.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findOrderByConsecutive(String consecutive);

    Order findOrderById(Long id);
}
