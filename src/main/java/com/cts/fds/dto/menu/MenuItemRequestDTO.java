package com.cts.fds.dto.menu;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuItemRequestDTO {
    private Long restaurantId; // Used when associating a new item, or for validation on update
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;
}
