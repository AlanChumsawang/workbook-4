package com.pluralsight.cardealership;

import java.util.ArrayList;

public class Dealership {
    private static final ArrayList<Vehicle> inventory = new ArrayList<Vehicle>();

    public static void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }


}
