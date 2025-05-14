package com.cts.fds.entity;

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

}