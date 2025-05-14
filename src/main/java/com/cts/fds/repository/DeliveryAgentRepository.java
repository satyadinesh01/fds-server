package com.cts.fds.repository;

import com.cts.fds.entity.DeliveryAgent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface DeliveryAgentRepository extends JpaRepository<DeliveryAgent, Integer> {
    // Optional: Find agents by status or name
    // List<DeliveryAgent> findByStatus(String status);
    // Optional<DeliveryAgent> findByName(String name);
}
