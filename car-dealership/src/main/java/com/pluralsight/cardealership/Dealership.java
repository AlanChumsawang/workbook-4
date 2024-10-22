package com.pluralsight.cardealership;

import java.util.ArrayList;

public class Dealership {
    private final String name;
    private final String address;
    private final String phone;

    private static final ArrayList<Vehicle> inventory = new ArrayList<Vehicle>();

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public static void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public static void get


}
