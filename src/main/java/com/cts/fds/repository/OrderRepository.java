package com.cts.fds.repository;

import com.cts.fds.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    // Optional: Find orders by customer or restaurant
    // List<Order> findByCustomerId(Integer customerId);
    // List<Order> findByCustomerEmail(String email);
    // List<Order> findByRestaurantRestaurantId(Integer restaurantId);
    // List<Order> findByStatus(String status);
}
