package com.cts.fds.services.menu;

import java.util.List;
import com.cts.fds.dto.menu.*;

public interface MenuItemService {

    List<MenuItemResponseDTO> getMenuItemsByRestaurantId(Long restaurantId);

    MenuItemResponseDTO addMenuItem(Long restaurantId, MenuItemRequestDTO requestDTO);

    MenuItemResponseDTO updateMenuItem(Long itemId, MenuItemRequestDTO requestDTO);

    void deleteMenuItem(Long itemId);

    MenuItemResponseDTO getMenuItemById(Long itemId);
}
