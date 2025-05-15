package com.cts.fds.controller;

import com.cts.fds.services.menu.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.cts.fds.dto.menu.*;

@RestController // Marks this class as a RESTful controller
@RequestMapping("/api") // Base path for all end points in this controller
public class MenuController {

    private final MenuItemService menuItemService;

    @Autowired
    public MenuController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    /**
     * Retrieves all menu items for a specific restaurant.
     * GET /api/restaurants/{restaurantId}/menu
     * Returns 200 OK by default.
     *
     * @param restaurantId The ID of the restaurant.
     * @return A list of MenuItemResponseDTOs.
     */
    @GetMapping("/restaurants/{restaurantId}/menu")
    public List<MenuItemResponseDTO> getRestaurantMenu(@PathVariable Long restaurantId) {
        return menuItemService.getMenuItemsByRestaurantId(restaurantId);
    }

    /**
     * Adds a new menu item to a specific restaurant.
     * POST /api/restaurants/{restaurantId}/menu
     * Returns 201 Created on success.
     *
     * @param restaurantId The ID of the restaurant to add the menu item to.
     * @param menuItemRequestDTO The request body containing the new menu item details.
     * @return The created MenuItemResponseDTO.
     */
    @PostMapping("/restaurants/{restaurantId}/menu")
    @ResponseStatus(HttpStatus.CREATED) // Explicitly sets HTTP status to 201 Created
    public MenuItemResponseDTO addMenuItem(
            @PathVariable Long restaurantId,
            @RequestBody MenuItemRequestDTO menuItemRequestDTO) {
        return menuItemService.addMenuItem(restaurantId, menuItemRequestDTO);
    }

    /**
     * Updates an existing menu item.
     * PUT /api/menu-items/{itemId}
     * Returns 200 OK by default.
     *
     * @param itemId The ID of the menu item to update.
     * @param menuItemRequestDTO The request body containing the updated menu item details.
     * @return The updated MenuItemResponseDTO.
     */
    @PutMapping("/menu-items/{itemId}")
    public MenuItemResponseDTO updateMenuItem(
            @PathVariable Long itemId,
            @RequestBody MenuItemRequestDTO menuItemRequestDTO) {
        return menuItemService.updateMenuItem(itemId, menuItemRequestDTO);
    }

    /**
     * Deletes a menu item by its ID.
     * DELETE /api/menu-items/{itemId}
     * Returns 204 No Content on success.
     *
     * @param itemId The ID of the menu item to delete.
     */
    @DeleteMapping("/menu-items/{itemId}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Explicitly sets HTTP status to 204 No Content
    public void deleteMenuItem(@PathVariable Long itemId) {
        menuItemService.deleteMenuItem(itemId);
    }

    /**
     * Retrieves a single menu item by its ID.
     * GET /api/menu-items/{itemId}
     * Returns 200 OK by default.
     *
     * @param itemId The ID of the menu item to retrieve.
     * @return The MenuItemResponseDTO.
     */
    @GetMapping("/menu-items/{itemId}")
    public MenuItemResponseDTO getMenuItemById(@PathVariable Long itemId) {
        return menuItemService.getMenuItemById(itemId);
    }
}
