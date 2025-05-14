package com.cts.fds.repository;

import org.springframework.stereotype.Repository;

import com.cts.fds.entity.Customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	/*
	 * @Query("SELECT c FROM customers c") List<Customer> findAllCustomers();
	 */

}
