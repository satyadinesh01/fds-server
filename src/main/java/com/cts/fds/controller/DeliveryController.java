package com.cts.fds.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @PostMapping("/assign")
    public ResponseEntity<Delivery> assignDelivery(@RequestBody Delivery delivery) {
        return new ResponseEntity<>(deliveryService.assignDeliveryAgent(delivery), HttpStatus.CREATED);
    }

    @PutMapping("/status/{id}")
    public ResponseEntity<Delivery> updateStatus(@PathVariable Long id, @RequestParam DeliveryStatus status) {
        return ResponseEntity.ok(deliveryService.updateDeliveryStatus(id, status));
    }

    @GetMapping("/agent/{agentId}")
    public ResponseEntity<List<Delivery>> getByAgent(@PathVariable Long agentId) {
        return ResponseEntity.ok(deliveryService.getDeliveriesByAgent(agentId));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<Delivery> getByOrderId(@PathVariable Long orderId) {
        return ResponseEntity.ok(deliveryService.getDeliveryByOrderId(orderId));
    }
}
