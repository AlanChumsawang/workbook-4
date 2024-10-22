package com.pluralsight.cardealership;

public class Vehicle {
    private final int id;
    private final int year;
    private final String make;
    private final String model;
    private final String type;
    private final String color;
    private final float mileage;
    private final double price;

    public Vehicle(int id, int year, String make, String model, String type, String color, float mileage, double price) {
        this.id = id;
        this.year = year;
        this.make = make;
        this.model = model;
        this.type = type;
        this.color = color;
        this.mileage = mileage;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public float getMileage() {
        return mileage;
    }

    public double getPrice() {
        return price;
    }
}

