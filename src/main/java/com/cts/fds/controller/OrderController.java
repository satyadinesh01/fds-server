package com.cts.fds.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@PostMapping
    public String placeOrder() {
        return "Post Order API";
    }

    @GetMapping("/{orderId}")
    public String getOrderDetails() {
        return "Get order API";
    }

    @GetMapping("/{orderId}/status")
    public String getOrderStatus() {
        return "Get Order status";
    }

    @PutMapping("/{orderId}/cancel")
    public String cancelOrder() {
        return "Put Order cancel";
    }

}
