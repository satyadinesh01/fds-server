package com.cts.fds.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data; // Import Lombok's @Data annotation
import lombok.NoArgsConstructor; // Optional: For a no-argument constructor
import lombok.AllArgsConstructor; // Optional: For an all-argument constructor

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
	private String name;
	private String email;
	private String password;
	private String phone;
	private String address;
	
	// --- Relationship with Orders ---
    // One customer can have many orders.
    // 'mappedBy' indicates the field in the 'Order' entity that owns the relationship.
    // CascadeType.ALL means if a customer is deleted, all their orders are also deleted.
    // orphanRemoval = true means if an order is removed from the list, it's deleted from DB.
    // FetchType.LAZY is generally preferred for collections to avoid loading all orders unnecessarily.
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>(); // Initialize to prevent NullPointerException


}