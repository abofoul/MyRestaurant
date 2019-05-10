package com.omar.restaurantapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private ArrayList<String> foodName;
    private ArrayList<Integer> foodImage;
    private Context mContext;

    public FoodAdapter(Context context, ArrayList<String> foodName, ArrayList<Integer> foodImage) {
        this.foodName = foodName;
        this.foodImage = foodImage;
        this.mContext = context;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.food_menu_item, viewGroup, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder foodViewHolder, int i) {
        foodViewHolder.textView.setText(foodName.get(i));
        foodViewHolder.imageView.setImageResource(foodImage.get(i));
    }

    @Override
    public int getItemCount() {
        return foodImage.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.food_category_name);
            imageView = itemView.findViewById(R.id.food_category_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent( mContext, DetailsActivity.class);
                    intent.putExtra("Type", textView.getText());
                    mContext.startActivity(intent);
                }
            });


        }


    }

}
