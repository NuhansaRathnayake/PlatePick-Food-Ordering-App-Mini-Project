package com.example.platepick;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    // List to hold items added to the cart
    private List<Meal> cartList;

    // Constructor
    public CartAdapter(List<Meal> cartList) {
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the cart_item.xml layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        // Get the current meal
        Meal meal = cartList.get(position);

        // Set data to views
        holder.tvCartMealName.setText(meal.getName());
        holder.tvCartMealPrice.setText(meal.getPrice());
        holder.imgCartMeal.setImageResource(meal.getImageResId());
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    // ViewHolder class
    public static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView tvCartMealName, tvCartMealPrice;
        ImageView imgCartMeal;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            // Link UI elements
            tvCartMealName = itemView.findViewById(R.id.tvCartMealName);
            tvCartMealPrice = itemView.findViewById(R.id.tvCartMealPrice);
            imgCartMeal = itemView.findViewById(R.id.imgCartMeal);
        }
    }
}