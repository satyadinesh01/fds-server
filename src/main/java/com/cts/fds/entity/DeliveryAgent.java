package com.cts.fds.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "delivery_agents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryAgent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long agentId;
	private String name;
	private String phone;
	private String status;

}