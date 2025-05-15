package com.cts.fds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cts.fds.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    // Optional: Add custom query methods
    // Optional<Restaurant> findByName(String name);
    // List<Restaurant> findByAddressContaining(String addressPart);
}
