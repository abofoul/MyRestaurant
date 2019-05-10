package com.omar.restaurantapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class CartAdapter extends ArrayAdapter<Meal> {
    public CartAdapter(@NonNull Context context, ArrayList<Meal> meals) {
        super(context, 0, meals);
    }

    @Override
    public View getView(int position,View convertView, ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.cart_list_item, parent, false);
        }

        final Meal meal = getItem(position);

        TextView mealName = listItemView.findViewById(R.id.cart_meal_name);
        mealName.setText(meal.getName());

        TextView mealPrice = listItemView.findViewById(R.id.cart_meal_price);
        String mealPriceText = String.valueOf(meal.getPrice());
        mealPriceText += "$";
        mealPrice.setText(mealPriceText);

        return listItemView;
    }
}
