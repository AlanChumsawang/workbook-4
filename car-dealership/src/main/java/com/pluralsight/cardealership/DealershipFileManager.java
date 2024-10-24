package com.pluralsight.cardealership;

import java.io.BufferedReader;
import java.io.FileReader;

public class DealershipFileManager {


    public Dealership getDealership(String file){
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufReader = new BufferedReader(fileReader);
            String currentLine = bufReader.readLine();
            String[] dealershipInfo = currentLine.split("[|]");
            String dealershipName = dealershipInfo[0];
            String dealershipAddress = dealershipInfo[1];
            String dealershipPhone = dealershipInfo[2];
            Dealership dealership = new Dealership(dealershipName, dealershipPhone, dealershipAddress);
            while ( (currentLine = bufReader.readLine()) != null){
                String[] vehicleInfo = currentLine.split("[|]");
                int vin = Integer.parseInt(vehicleInfo[0]);
                int year = Integer.parseInt(vehicleInfo[1]);
                String make = vehicleInfo[2];
                String model = vehicleInfo[3];
                String type =  vehicleInfo[4];
                String color = vehicleInfo[5];
                int odometer = Integer.parseInt(vehicleInfo[6]);
                double price = Double.parseDouble(vehicleInfo[7]);
                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                dealership.addVehicle(vehicle);
            }
            return dealership;
        }
        catch(Exception e){
            System.out.println("File not found");
            throw new RuntimeException();
        }
    }
    public void saveDealership(Dealership dealership){
        // Implement the method to save the dealership to a file
    }
}
