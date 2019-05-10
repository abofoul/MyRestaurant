package com.omar.restaurantapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.Objects;

public class MealDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_details);

        String mealName = getIntent().getStringExtra("mealName");
        int mealImage = Integer.parseInt(getIntent().getStringExtra("mealImage"));
        String mealDescription = getIntent().getStringExtra("mealDescription");

        ImageView imageView = findViewById(R.id.meal_detail_image);
        TextView textView = findViewById(R.id.meal_detail_description);
        TextView mealNameTextView = findViewById(R.id.meal_detail_name);

        mealNameTextView.setText(mealName);
        imageView.setImageResource(mealImage);
        textView.setText(mealDescription);

    }

}
