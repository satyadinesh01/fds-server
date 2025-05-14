package com.cts.fds.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "deliveries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long deliveryId;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	private String deliveryAddress;
	private String deliveryStatus;
	private Timestamp deliveredAt;

}