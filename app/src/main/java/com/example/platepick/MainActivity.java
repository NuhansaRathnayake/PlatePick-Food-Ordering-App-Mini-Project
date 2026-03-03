package com.example.platepick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Declare views
    private TextView tvWelcomeUser;
    private RecyclerView rvBurgers, rvPizzas, rvDrinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views using IDs from XML
        tvWelcomeUser = findViewById(R.id.tvWelcomeUser);
        rvBurgers = findViewById(R.id.rvBurgers);
        rvPizzas = findViewById(R.id.rvPizzas);
        rvDrinks = findViewById(R.id.rvDrinks);

        // Get the username passed from LoginActivity
        String userName = getIntent().getStringExtra("USER_NAME");
        if(userName != null) {
            tvWelcomeUser.setText("Hello, " + userName + "!");
        }

        // Set LayoutManagers to HORIZONTAL for all RecyclerViews
        rvBurgers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvPizzas.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvDrinks.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // ---------------------------------------------------------
        // Create separate lists for each category
        // ---------------------------------------------------------

        // --- BURGERS ---
        List<Meal> burgerList = new ArrayList<>();
        burgerList.add(new Meal("Chicken Burger", "Rs. 850", R.drawable.chicken_burger));
        burgerList.add(new Meal("Beef Burger", "Rs. 1050", R.drawable.beef_burger));
        burgerList.add(new Meal("Veggie Burger", "Rs. 750", R.drawable.veggie_burger));
        // Set adapter for burgers
        rvBurgers.setAdapter(new MenuAdapter(burgerList));

        // --- PIZZAS ---
        List<Meal> pizzaList = new ArrayList<>();
        pizzaList.add(new Meal("Cheese Pizza", "Rs. 1500", R.drawable.cheese_pizza));
        pizzaList.add(new Meal("Sausage Pizza", "Rs. 1800",R.drawable.sausage_pizza));
        pizzaList.add(new Meal("BBQ Chicken", "Rs. 2200", R.drawable.bbq_chicken_pizza));
        // Set adapter for pizzas
        rvPizzas.setAdapter(new MenuAdapter(pizzaList));

        // --- DRINKS ---
        List<Meal> drinkList = new ArrayList<>();
        drinkList.add(new Meal("Coca Cola", "Rs. 300",R.drawable.coca_cola));
        drinkList.add(new Meal("Milkshake", "Rs. 600",R.drawable.milkshake));
        drinkList.add(new Meal("Orange Juice", "Rs. 450", R.drawable.orange_juice));
        // Set adapter for drinks
        rvDrinks.setAdapter(new MenuAdapter(drinkList));

        // ---------------------------------------------------------
        // View Cart button logic
        // ---------------------------------------------------------
        Button btnViewCart = findViewById(R.id.btnViewCart);
        btnViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to CartActivity when the button is clicked
                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });

    } // <-- Only ONE closing brace for onCreate method
}