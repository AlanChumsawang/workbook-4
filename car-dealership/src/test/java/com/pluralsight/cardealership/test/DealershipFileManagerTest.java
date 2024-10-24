package com.pluralsight.cardealership.test;

import com.pluralsight.cardealership.Dealership;
import com.pluralsight.cardealership.Vehicle;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

public class DealershipFileManagerTest {
    private Dealership dealership;
    private Vehicle vehicle;

    @Test
    void getDealership() {

        try {
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);
            String currentLine = bufReader.readLine();
            String[] dealershipInfo = currentLine.split("[|]");
            String dealershipName = dealershipInfo[0];
            String dealershipAddress = dealershipInfo[1];
            String dealershipPhone = dealershipInfo[2];
            dealership = new Dealership(dealershipName, dealershipPhone, dealershipAddress);
            while ((currentLine = bufReader.readLine()) != null) {
                String[] vehicleInfo = currentLine.split("[|]");
                int vin = Integer.parseInt(vehicleInfo[0]);
                int year = Integer.parseInt(vehicleInfo[1]);
                String make = vehicleInfo[2];
                String model = vehicleInfo[3];
                String type = vehicleInfo[4];
                String color = vehicleInfo[5];
                int odometer = Integer.parseInt(vehicleInfo[6]);
                double price = Double.parseDouble(vehicleInfo[7]);
                vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                dealership.addVehicle(vehicle);
            }
        } catch (Exception e) {
            System.out.println("File not found");
            throw new RuntimeException();
        }
        assertEquals(3, dealership.getAllVehicles().size());
    }

    @Test
    void saveDealership() {
        // Implement the test for saving the dealership to a file
    }
}