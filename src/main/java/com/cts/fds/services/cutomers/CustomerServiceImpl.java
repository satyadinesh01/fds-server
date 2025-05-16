package com.cts.fds.services.cutomers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.fds.entity.Customer;
import com.cts.fds.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository; 
	
	
	
	  @Override
	  public List<Customer> viewAllCustomers() { return
	  customerRepository.findAll() ; }
	 


}
