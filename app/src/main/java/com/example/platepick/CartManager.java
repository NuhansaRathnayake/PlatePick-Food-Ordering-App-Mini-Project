package com.example.platepick;

import java.util.ArrayList;
import java.util.List;

public class CartManager {

    // Singleton instance for the entire app
    private static CartManager instance;

    // List to store cart items
    private List<Meal> cartItems;

    // Private constructor
    private CartManager() {
        cartItems = new ArrayList<>();
    }

    // Method to get the single instance of CartManager
    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    // Method to add a new meal to the cart
    public void addToCart(Meal meal) {
        cartItems.add(meal);
    }

    // Method to retrieve all items currently in the cart
    public List<Meal> getCartItems() {
        return cartItems;
    }
}