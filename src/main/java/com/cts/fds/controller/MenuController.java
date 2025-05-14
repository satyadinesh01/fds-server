package com.cts.fds.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurants")
public class MenuController {
	
	@GetMapping("/{restaurantId}/menu")
    public String getRestaurantMenu() {
        return "Get Restarunt menu";
    }

    @PostMapping("/{restaurantId}/menu")
    public String addMenuItem() {
    	return "Post Restarunt menu";
    }

    @PutMapping("/menu-items/{itemId}")
    public String updateMenuItem() {
    	return "Put item in menu";
    }

    @DeleteMapping("/menu-items/{itemId}")
    public String deleteMenuItem() {
    	return "Delete item in the menu";
    }
}
