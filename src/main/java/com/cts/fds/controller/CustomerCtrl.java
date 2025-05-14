package com.cts.fds.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/customers")
public class CustomerCtrl {
	
	
	
	@PostMapping("/register")
    public String registerCustomer() {
        return "Register API";
    }

    @PostMapping("/login")
    public String loginCustomer() {
    	return "Login API";
    }

    @GetMapping("/profile")
    public String getCustomerProfile() {
        return " Get Profile API";
    }

    @PutMapping("/profile")
    public String updateCustomerProfile() {
        return "Put Profile API";
    }

}
