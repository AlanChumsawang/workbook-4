package com.pluralsight.cardealership;

import java.util.Scanner;

public class UserInterface {
    Dealership dealership; // Declare the dealership variable

    // Constructor
    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership("src/main/resources/inventory.csv");
    }

    // Display the user interface
    public void display() {
        Scanner inputScanner = new Scanner(System.in); // Create a scanner for user input
        init(); // Initialize the dealership
        displayMainMenu(); // Display the main menu
        String userInput = inputScanner.nextLine(); // Wait for user input
        switch (userInput) {
            case "1":
                System.out.println( dealership.getAllVehicles());
                break;
            case "2":
                // Search for a vehicle
                break;
            case "3":
                // Add a vehicle
                break;
            case "4":
                // Remove a vehicle
                break;
            case "5":
                // Exit
                System.exit(0);
                break;
            default:// Handle invalid input
                System.out.println("Invalid input. Please try again.");
                display(); // Redisplay the menu
        }

    }


    // Display the main menu
    private static void displayMainMenu() {
        System.out.println("""
                        ==============================
                        Welcome to the Car Dealership
                        ==============================
                1. View all vehicles
                2. Search for a vehicle
                3. Add a vehicle
                4. Remove a vehicle
                5. Exit
                """);
    }


}
