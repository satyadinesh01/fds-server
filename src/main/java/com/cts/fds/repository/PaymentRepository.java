package com.cts.fds.repository;

import com.cts.fds.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    // Optional: Find payment by order
    // Optional<Payment> findByOrderId(Integer orderId); // If order_id is unique in payments
    // List<Payment> findByPaymentStatus(String status);
}
