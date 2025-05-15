package com.cts.fds.services.menu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.fds.repository.MenuItemRepository;
import com.cts.fds.repository.RestaurantRepository;
import org.springframework.transaction.annotation.Transactional;
import com.cts.fds.dto.menu.*;
import com.cts.fds.entity.*;
import java.util.stream.Collectors;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    private final MenuItemRepository menuItemRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public MenuItemServiceImpl(MenuItemRepository menuItemRepository, RestaurantRepository restaurantRepository) {
        this.menuItemRepository = menuItemRepository;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MenuItemResponseDTO> getMenuItemsByRestaurantId(Long restaurantId) {
        List<MenuItem> menuItems = menuItemRepository.findByRestaurantRestaurantId(restaurantId);
        return menuItems.stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MenuItemResponseDTO addMenuItem(Long restaurantId, MenuItemRequestDTO requestDTO) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Restaurant not found with ID: " + restaurantId)); // <--- CHANGE HERE

        MenuItem menuItem = convertToEntity(requestDTO);
        menuItem.setRestaurant(restaurant);

        MenuItem savedMenuItem = menuItemRepository.save(menuItem);
        return convertToResponseDTO(savedMenuItem);
    }

    @Override
    @Transactional
    public MenuItemResponseDTO updateMenuItem(Long itemId, MenuItemRequestDTO requestDTO) {
        MenuItem existingMenuItem = menuItemRepository.findById(itemId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Menu Item not found with ID: " + itemId)); // <--- CHANGE HERE

        if (requestDTO.getRestaurantId() != null &&
            !existingMenuItem.getRestaurant().getRestaurantId().equals(requestDTO.getRestaurantId())) {
            // Consider using another ResponseStatusException here, e.g., HttpStatus.BAD_REQUEST or HttpStatus.FORBIDDEN
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot change restaurant association for an existing menu item.");
        }

        if (requestDTO.getName() != null) {
            existingMenuItem.setName(requestDTO.getName());
        }
        if (requestDTO.getDescription() != null) {
            existingMenuItem.setDescription(requestDTO.getDescription());
        }
        if (requestDTO.getPrice() != null) {
            existingMenuItem.setPrice(requestDTO.getPrice());
        }
        if (requestDTO.getImageUrl() != null) {
            existingMenuItem.setImageUrl(requestDTO.getImageUrl());
        }

        MenuItem updatedMenuItem = menuItemRepository.save(existingMenuItem);
        return convertToResponseDTO(updatedMenuItem);
    }

    @Override
    @Transactional
    public void deleteMenuItem(Long itemId) {
        if (!menuItemRepository.existsById(itemId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Menu Item not found with ID: " + itemId); // <--- CHANGE HERE
        }
        menuItemRepository.deleteById(itemId);
    }

    @Override
    @Transactional(readOnly = true)
    public MenuItemResponseDTO getMenuItemById(Long itemId) {
        MenuItem menuItem = menuItemRepository.findById(itemId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Menu Item not found with ID: " + itemId)); // <--- CHANGE HERE
        return convertToResponseDTO(menuItem);
    }

    // ... Manual Mapping Helper Methods ...
    private MenuItem convertToEntity(MenuItemRequestDTO dto) {
        MenuItem entity = new MenuItem();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setImageUrl(dto.getImageUrl());
        return entity;
    }

    private MenuItemResponseDTO convertToResponseDTO(MenuItem entity) {
        MenuItemResponseDTO dto = new MenuItemResponseDTO();
        dto.setItemId(entity.getItemId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setImageUrl(entity.getImageUrl());

        if (entity.getRestaurant() != null) {
            dto.setRestaurantId(entity.getRestaurant().getRestaurantId());
            dto.setRestaurantName(entity.getRestaurant().getName());
        }
        return dto;
    }
}
