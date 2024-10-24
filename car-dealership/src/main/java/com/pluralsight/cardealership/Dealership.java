package com.pluralsight.cardealership;

import java.util.ArrayList;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<Vehicle>();
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return inventory;
    }

    public ArrayList<Vehicle> getVehicleByPrice(double min, double max) {
        ArrayList<Vehicle> vehiclesWithinPriceRange = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                vehiclesWithinPriceRange.add(vehicle);
            }
            return vehiclesWithinPriceRange; // Return the list of vehicles within the price range
        }
        return null; // Return null if no vehicle is found in the price range
    }

    public ArrayList<Vehicle> getVehicleByMakeModel(String make, String model){
        ArrayList<Vehicle> vehicleOfMakeModel = new ArrayList<Vehicle>();
        return vehicleOfMakeModel;
    }

    public ArrayList<Vehicle> getVehicleByYear(int year){
        ArrayList<Vehicle> vehicleOfYear = new ArrayList<Vehicle>();
        return vehicleOfYear;
    }

    public ArrayList<Vehicle> getVehicleByColor(String color){
        ArrayList<Vehicle> vehicleOfColor = new ArrayList<Vehicle>();
        return vehicleOfColor;
    }

    public ArrayList<Vehicle> getVehicleByMileage(int odometer){
        ArrayList<Vehicle> vehiclesWithinMileage = new ArrayList<Vehicle>();
        return vehiclesWithinMileage;
    }

    public ArrayList<Vehicle> getVehicleByType(String type){
        ArrayList<Vehicle> vehicleOfType = new ArrayList<Vehicle>();
        return vehicleOfType;
    }




    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
