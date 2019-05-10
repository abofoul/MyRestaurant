package com.omar.restaurantapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MealAdapter extends ArrayAdapter<Meal> {

    private Context mContext;
    public static int totalPrice =0;
     TextView price;
     public static ArrayList<Meal> cartMeals = new ArrayList<>();

    MealAdapter(@NonNull Context context, ArrayList<Meal> meals , TextView price) {
        super(context, 0, meals);
        mContext = context;
        this.price = price;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        final Meal meal = getItem(position);

        ImageView mealImage = listItemView.findViewById(R.id.meal_image);
        mealImage.setImageResource(meal.getImageId());

        TextView mealName = listItemView.findViewById(R.id.meal_name);
        mealName.setText(meal.getName());

        TextView mealPrice = listItemView.findViewById(R.id.meal_price);
        String mealPriceText = String.valueOf(meal.getPrice());
        mealPriceText += "$";
        mealPrice.setText(mealPriceText);

        TextView mealDescription = listItemView.findViewById(R.id.meal_description);
        mealDescription.setText(meal.getDescription());

        Button details = listItemView.findViewById(R.id.details_btn);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MealDetailsActivity.class);
                intent.putExtra("mealName", meal.getName());
                intent.putExtra("mealImage", String.valueOf(meal.getImageId()));
                intent.putExtra("mealDescription", meal.getDescription());
                mContext.startActivity(intent);
            }
        });



        Button addToCart = listItemView.findViewById(R.id.add_to_cart);
        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalPrice += meal.getPrice();
                String priceText = String.valueOf(totalPrice);
                priceText += "$";
                price.setText(priceText);
                cartMeals.add(meal);
            }
        });

        return listItemView;
    }
}
