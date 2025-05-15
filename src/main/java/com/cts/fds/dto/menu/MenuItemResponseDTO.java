package com.cts.fds.dto.menu;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemResponseDTO {
    private Long itemId;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private Long restaurantId;
    private String restaurantName; // To display restaurant name directly in menu item response
}
