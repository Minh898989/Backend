package com.example.demo.service;

import com.example.demo.model.Food;
import com.example.demo.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    // Get all Food products
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    // Get a Food product by ID
    public Optional<Food> getFoodById(Long id) {
        return foodRepository.findById(id);
    }

    // Add a new Food product
    public Food addFood(Food food) {
        return foodRepository.save(food);
    }

    // Update an existing Food product by ID
    public Food updateFood(Long id, Food foodDetails) {
        // Check if the food exists by ID
        return foodRepository.findById(id)
                .map(existingFood -> {
                    existingFood.setName(foodDetails.getName());
                    existingFood.setPrice(foodDetails.getPrice());
                    existingFood.setQuantity(foodDetails.getQuantity());
                    existingFood.setExpiryDate(foodDetails.getExpiryDate());
                    return foodRepository.save(existingFood);
                })
                .orElseThrow(() -> new RuntimeException("Food not found with ID " + id));
    }

    // Delete a Food product by ID
    public void deleteFood(Long id) {
        foodRepository.deleteById(id);
    }
}

