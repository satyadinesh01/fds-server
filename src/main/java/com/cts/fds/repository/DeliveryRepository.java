package com.cts.fds.repository;

import com.cts.fds.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {
    // Optional: Find delivery by order or status
    // Optional<Delivery> findByOrderId(Integer orderId); // If order_id is unique in deliveries
    // List<Delivery> findByDeliveryStatus(String status);
}