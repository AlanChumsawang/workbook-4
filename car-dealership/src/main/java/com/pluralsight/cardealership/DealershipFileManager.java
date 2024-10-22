package com.pluralsight.cardealership;

import java.io.*;
import java.util.Scanner;

public class DealershipFileManager {

    public static void readCSV(Scanner scanner) {
        try {
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufferedreader = new BufferedReader(fileReader);
            String currentLine = bufferedreader.readLine();
            Dealership dealership = getDealership(currentLine);
            while ( (currentLine = bufferedreader.readLine()) != null) {
                Vehicle vehicle = getVehicle(currentLine);
                Dealership.addVehicle(vehicle);
            }
        }
        catch (Exception e) {
            System.out.println("File not found");
        }
    }

    private static Vehicle getVehicle(String currentLine) {
        String[] carInfo = currentLine.split("[|]");
        int carID = Integer.parseInt(carInfo[0]);
        int year = Integer.parseInt(carInfo[1]);
        String make = carInfo[2];
        String model = carInfo[3];
        String type = carInfo[4];
        String color = carInfo[5];
        float mileage = Float.parseFloat(carInfo[6]);
        double price = Double.parseDouble(carInfo[7]);
        Vehicle vehicle = new Vehicle(carID, year, make, model, type, color, mileage, price);
        return vehicle;
    }

    private static Dealership getDealership(String currentLine) {
        String[] carInfo = currentLine.split("[|]");
        String name = carInfo[0];
        String address = carInfo[1];
        String phone = carInfo[2];

        Dealership dealership = new Dealership(name, address, phone);
        return dealership;
    }

    public static String saveDealership(){
        return "\n\nSaved to Inventory";
    }

}
