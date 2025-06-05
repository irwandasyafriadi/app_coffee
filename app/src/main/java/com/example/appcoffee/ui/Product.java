package com.example.appcoffee.util;

public class Product {
    private String name;
    private int price;
    private int image;

    public Product(String name, int price, int image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public int getImage() { return image; }
}
