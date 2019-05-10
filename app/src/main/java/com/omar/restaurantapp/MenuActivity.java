package com.omar.restaurantapp;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    private ArrayList<String> foodName = new ArrayList<>();
    private ArrayList<Integer> foodImage = new ArrayList<>();
    private RecyclerView recyclerView;
    private FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        FirebaseApp.initializeApp(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_exit);
        getSupportActionBar().setTitle("");

        /*Button logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });*/

        foodName.add("Hot drinks");
        foodName.add("Cold drinks");
        foodName.add("Fresh juices");
        foodName.add("Cakes");
        foodName.add("Sandwiches");
        foodName.add("Chicken");
        foodName.add("Fish");
        foodName.add("Meat");

        foodImage.add(R.drawable.hot_drinks);
        foodImage.add(R.drawable.cold_drinks);
        foodImage.add(R.drawable.fresh_juice);
        foodImage.add(R.drawable.cake);
        foodImage.add(R.drawable.sandwiches);
        foodImage.add(R.drawable.chicken);
        foodImage.add(R.drawable.fish);
        foodImage.add(R.drawable.meat);

        recyclerView = findViewById(R.id.food_recycler_view);
        foodAdapter = new FoodAdapter(this, foodName, foodImage);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(foodAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
