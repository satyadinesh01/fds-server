package com.cts.fds.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {
	
	@GetMapping("/{deliveryId}")
    public String getDeliveryDetails() {
        return "Get Delivery id";
    }

    @PostMapping("/{deliveryId}/status")
    public String updateDeliveryStatus() {
        return "Post delivery status";
    }

    @PutMapping("/{deliveryId}/eta")
    public String updateEstimatedTimeOfArrival() {
        return "Put delivery time";
    }

}
