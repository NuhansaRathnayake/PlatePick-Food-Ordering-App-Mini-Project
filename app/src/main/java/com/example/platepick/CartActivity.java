package com.example.platepick;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    private RecyclerView rvCartItems;
    private TextView tvTotalPrice;
    private Button btnCheckout;
    private CartAdapter cartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Link views
        rvCartItems = findViewById(R.id.rvCartItems);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        btnCheckout = findViewById(R.id.btnCheckout);

        // Get cart items from CartManager
        List<Meal> cartItems = CartManager.getInstance().getCartItems();

        // Setup RecyclerView
        rvCartItems.setLayoutManager(new LinearLayoutManager(this));
        cartAdapter = new CartAdapter(cartItems);
        rvCartItems.setAdapter(cartAdapter);

        // Calculate and display total price
        calculateTotal(cartItems);

        // Checkout Button Click Listener
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cartItems.isEmpty()) {
                    Toast.makeText(CartActivity.this, "Your cart is empty!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CartActivity.this, "Order Placed Successfully!", Toast.LENGTH_LONG).show();
                    // Clear the cart after checkout
                    cartItems.clear();
                    cartAdapter.notifyDataSetChanged();
                    tvTotalPrice.setText("Total: Rs. 0");
                }
            }
        });
    }

    // Method to calculate total amount
    private void calculateTotal(List<Meal> cartItems) {
        int total = 0;
        for (Meal meal : cartItems) {
            // Remove text "Rs." and any spaces, keep only numbers
            String priceString = meal.getPrice().replaceAll("[^0-9]", "");
            try {
                total += Integer.parseInt(priceString);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        // Set total price to TextView
        tvTotalPrice.setText("Total: Rs. " + total);
    }
}