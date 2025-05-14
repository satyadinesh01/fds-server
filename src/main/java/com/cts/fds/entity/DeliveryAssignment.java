package com.cts.fds.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "delivery_assignments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryAssignment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long assignmentId;
	@ManyToOne
	@JoinColumn(name = "delivery_id")
	private Delivery delivery;
	@ManyToOne
	@JoinColumn(name = "agent_id")
	private DeliveryAgent agent;
	private Timestamp assignedAt;

}