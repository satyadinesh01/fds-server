package com.cts.fds.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "menu_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy fetching is usually preferred for ManyToOne
	@JoinColumn(name = "restaurant_id", nullable = false) // Make sure a menu item always has a restaurant
	private Restaurant restaurant;

	private String name;
	private String description;
	private BigDecimal price;
	private String imageUrl;

}