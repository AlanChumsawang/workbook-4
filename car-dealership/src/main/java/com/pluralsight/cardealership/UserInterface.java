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
                searchMenu();
                break;
            case "3":
                // Add a vehicle
                addVehicleMenu(inputScanner);
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

    private static void searchMenu(){
        System.out.print("""
                1. Search by Price
                2. Search by Make and Model
                3. Search by Year
                4. Search by Color
                5. Search by Mileage
                6. Search by Type
                7. Return to Main Menu
                """);
    }

    private void addVehicleMenu(Scanner inputScanner){
        System.out.print("Enter VIN: ");
        int vin = inputScanner.nextInt();
        inputScanner.nextLine(); // Consume newline
        System.out.print("Enter Year: ");
        int year = inputScanner.nextInt();
        inputScanner.nextLine();
        System.out.print("Enter Make: ");
        String make = inputScanner.nextLine();
        System.out.print("Enter Model: ");
        String model = inputScanner.nextLine();
        System.out.print("Enter Type: ");
        String type = inputScanner.nextLine();
        System.out.print("Enter Color: ");
        String color = inputScanner.nextLine();
        System.out.print("Enter Odometer: ");
        int odometer = inputScanner.nextInt();
        inputScanner.nextLine();
        System.out.print("Enter Price: ");
        double price = inputScanner.nextDouble();
        inputScanner.nextLine();
        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicle);


    }


}
