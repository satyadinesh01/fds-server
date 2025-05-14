package com.cts.fds.repository;

import com.cts.fds.entity.DeliveryAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DeliveryAssignmentRepository extends JpaRepository<DeliveryAssignment, Integer> {
    // Optional: Find assignments by delivery or agent
    // List<DeliveryAssignment> findByDeliveryDeliveryId(Integer deliveryId);
    // List<DeliveryAssignment> findByDeliveryAgentAgentId(Integer agentId);
}