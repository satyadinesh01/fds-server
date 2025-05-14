package com.cts.fds.repository;

import com.cts.fds.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    // Optional: Find order items by order
    // List<OrderItem> findByOrderId(Integer orderId);
    // List<OrderItem> findByMenuItemItemId(Integer itemId);
}
