package com.omar.restaurantapp;

public class Meal {

    private String name;
    private int imageId;
    private String description;
    private int price;

    public Meal(String name, int imageId, String description, int price) {
        this.name = name;
        this.imageId = imageId;
        this.description = description;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

}
