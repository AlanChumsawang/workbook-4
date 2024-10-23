package com.pluralsight.cardealership;

import java.util.ArrayList;

public class Dealership {
    private final String name;
    private final String address;
    private final String phone;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<Vehicle>();
    }

    public void addVehicle(Vehicle vehicle){
        inventory.add(vehicle);
    }

    public static void getAllVehicals(ArrayList<Vehicle> inventory){
        for (Vehicle vehicle : inventory) {
            System.out.println(vehicle.getYear() + " " + vehicle.getMake() + " " + vehicle.getModel() + "\n    "
                    + vehicle.getPrice() + "\n    " + vehicle.getOdometer() + "\n    " + vehicle.getVin());
        }
    }


}
