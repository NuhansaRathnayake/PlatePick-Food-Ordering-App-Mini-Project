package com.example.platepick;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvWelcomeUser;
    private RecyclerView rvBurgers, rvPizzas, rvDrinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Find views
        tvWelcomeUser = findViewById(R.id.tvWelcomeUser);
        rvBurgers = findViewById(R.id.rvBurgers);
        rvPizzas = findViewById(R.id.rvPizzas);
        rvDrinks = findViewById(R.id.rvDrinks);

        // 2. Set Username
        String userName = getIntent().getStringExtra("USER_NAME");
        if(userName != null) {
            tvWelcomeUser.setText("Hello, " + userName + "!");
        }

        // 3. Set LayoutManagers to HORIZONTAL for all RecyclerViews
        rvBurgers.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvPizzas.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvDrinks.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        // 4. Create separate lists for each category

        // --- BURGERS ---
        List<Meal> burgerList = new ArrayList<>();
        burgerList.add(new Meal("Chicken Burger", "Rs. 850", R.drawable.chicken_burger)); // Change to your image
        burgerList.add(new Meal("Beef Burger", "Rs. 1050", R.drawable.beef_burger));
        burgerList.add(new Meal("Veggie Burger", "Rs. 750", R.drawable.veggie_burger));
        rvBurgers.setAdapter(new MenuAdapter(burgerList));

        // --- PIZZAS ---
        List<Meal> pizzaList = new ArrayList<>();
        pizzaList.add(new Meal("Cheese Pizza", "Rs. 1500", R.drawable.cheese_pizza));
        pizzaList.add(new Meal("Sausage Pizza", "Rs. 1800",R.drawable.sausage_pizza));
        pizzaList.add(new Meal("BBQ Chicken", "Rs. 2200", R.drawable.bbq_chicken_pizza));
        rvPizzas.setAdapter(new MenuAdapter(pizzaList));

        // --- DRINKS ---
        List<Meal> drinkList = new ArrayList<>();
        drinkList.add(new Meal("Coca Cola", "Rs. 300",R.drawable.coca_cola));
        drinkList.add(new Meal("Milkshake", "Rs. 600",R.drawable.milkshake));
        drinkList.add(new Meal("Orange Juice", "Rs. 450", R.drawable.orange_juice));
        rvDrinks.setAdapter(new MenuAdapter(drinkList));
    }
}