package com.cts.fds.repository;

import com.cts.fds.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
    // Optional: Find menu items by restaurant
    // List<MenuItem> findByRestaurantRestaurantId(Integer restaurantId);
    // List<MenuItem> findByRestaurantName(String restaurantName);
}