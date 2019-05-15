package com.omar.restaurantapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    ArrayList<Meal> meals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView price = findViewById(R.id.total_price);

        String mealType = getIntent().getStringExtra("Type");

        addFoodToList(mealType);

        Toolbar toolbar = findViewById(R.id.meals_toolbar);
        ImageView cart = toolbar.findViewById(R.id.cart_btn);
        TextView category = toolbar.findViewById(R.id.category);
        TextView totalPrice = toolbar.findViewById(R.id.total_price);
        String s = String.valueOf(MealAdapter.totalPrice);
        s+="$";
        totalPrice.setText(s);
        category.setText(mealType);

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this , CartActivity.class);
                startActivity(intent);
            }
        });

        MealAdapter adapter = new MealAdapter(this , meals, price);
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);



    }

    private void addFoodToList(String mealType) {

        if (mealType.equals("Hot drinks")){
            meals = new ArrayList<>();
            meals.add(new Meal("Easy Chai tea" , R.drawable.hot1 , getString(R.string.neapolitanPizza),18 ));
            meals.add(new Meal("Warm Mulled Cider" , R.drawable.hot2 , getString(R.string.chicagoPizza),28 ));
            meals.add(new Meal("Spiced Hot Cocoa" , R.drawable.hot3 , getString(R.string.newYorkPizza),32 ));
            meals.add(new Meal("Easy Blender Eggnog" , R.drawable.hot4 , getString(R.string.sicilianPizza),221 ));
            meals.add(new Meal("Warm Hazelnut Toddy" , R.drawable.hot5 , getString(R.string.greekPizza),20 ));
        }
        else if (mealType.equals("Cold drinks")){
            meals = new ArrayList<>();
            meals.add(new Meal("Beverages" , R.drawable.cold1 , getString(R.string.caffèAmericano),18 ));
            meals.add(new Meal("Iced Tea" , R.drawable.cold2 , getString(R.string.caféLatte),33 ));
            meals.add(new Meal("Strawberry" , R.drawable.cold3 , getString(R.string.cappuccino),23 ));
            meals.add(new Meal("Ginger-Ale" , R.drawable.cold4 , getString(R.string.espresso),21 ));
            meals.add(new Meal("Lemon" , R.drawable.cold5 , getString(R.string.flatWhite),12 ));

        }
        else if (mealType.equals("Fresh juices")){
            meals = new ArrayList<>();
            meals.add(new Meal("Watermelon Lychee Granita" , R.drawable.fresh1 , getString(R.string.saltPepper),33 ));
            meals.add(new Meal("Cool Kiwi Juice" , R.drawable.fresh2 , getString(R.string.porkShoulder),27 ));
            meals.add(new Meal("Aam Ras" , R.drawable.fresh3 , getString(R.string.grilledSteak),19 ));
            meals.add(new Meal("Ananas da Panna" , R.drawable.fresh4 , getString(R.string.chickenSchnitzel),36 ));
            meals.add(new Meal("Grape Nectar" , R.drawable.fresh5 , getString(R.string.drumsticks),12 ));
        }
        else if (mealType.equals("Sandwiches")){
            meals = new ArrayList<>();
            meals.add(new Meal("Indian Pulled-Chicken" , R.drawable.sandwich1 , getString(R.string.custards),20));
            meals.add(new Meal("Strip-Steak" , R.drawable.sandwich2 , getString(R.string.frozen),25 ));
            meals.add(new Meal("Tuna-and-Gruyère Panino" , R.drawable.sandwich3 , getString(R.string.cakes),33 ));
            meals.add(new Meal("Grilled Chicken" , R.drawable.sandwich4 , getString(R.string.cookies),27 ));
            meals.add(new Meal("Shrimp Salad Sliders" , R.drawable.sandwich5 , getString(R.string.pies),40 ));
        }
        else if (mealType.equals("Cakes")){
            meals = new ArrayList<>();
            meals.add(new Meal("Pink Lemonade Stand" , R.drawable.cake1 , getString(R.string.cake1),40));
            meals.add(new Meal("Pumpkin Torte" , R.drawable.cake2 , getString(R.string.cake2),45 ));
            meals.add(new Meal("Minted Chocolate" , R.drawable.cake3 , getString(R.string.cake3),37 ));
            meals.add(new Meal("Sour Cream " , R.drawable.cake4 , getString(R.string.cake4),55 ));
            meals.add(new Meal("Chocolate Hazelnut " , R.drawable.cake5 , getString(R.string.cake5),60 ));
        }
    }
}
