package com.pluralsight.cardealership;

import java.util.ArrayList;
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
        boolean isDone = false;
        while (!isDone) {
            displayMainMenu(); // Display the main menu
            String userInput = inputScanner.nextLine(); // Wait for user input
            switch (userInput) {
                case "1":
                    displayVehicles(dealership.getAllVehicles());
                    break;
                case "2":
                    // Search for a vehicle
                    searchMenu(inputScanner);
                    break;
                case "3":
                    // Add a vehicle
                    addVehicleMenu(inputScanner);
                    break;
                case "4":
                    // Remove a vehicle
                    removeVehicleMenu(inputScanner);
                    break;
                case "5":
                    // Exit
                    isDone = true;
                    break;
                default:// Handle invalid input
                    System.out.println("Invalid input. Please try again.");
                    display(); // Redisplay the menu
            }
        }
    }


    // Display the main menu
    private static void displayMainMenu() {
        System.out.print("""
                        ==============================
                        Welcome to the Car Dealership
                        ==============================
                1. View all vehicles
                2. Search for a vehicle
                3. Add a vehicle
                4. Remove a vehicle
                5. Exit
                Choose an option: """);
    }

    private static void displaySearchMenu(){
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

    private void searchMenu(Scanner scanner){
            displaySearchMenu();
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "1":
                    // Search by price
                    System.out.print("Enter minimum price: ");
                    double minPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter maximum price: ");
                    double maxPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.println(dealership.getVehicleByPrice(minPrice, maxPrice));
                    break;
                case "2":
                    // Search by make and model
                    System.out.print("Enter make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter model: ");
                    String model = scanner.nextLine();
                    System.out.println(dealership.getVehicleByMakeModel(make, model));
                    break;
                case "3":
                    // Search by year
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println(dealership.getVehicleByYear(year));
                    break;
                case "4":
                    // Search by color
                    System.out.print("Enter color: ");
                    String color = scanner.nextLine();
                    System.out.println(dealership.getVehicleByColor(color));
                    break;
                case "5":
                    // Search by mileage
                    System.out.print("Enter maximum mileage: ");
                    int mileage = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println(dealership.getVehicleByMileage(mileage));
                    break;
                case "6":
                    // Search by type
                    System.out.print("Enter type: ");
                    String type = scanner.nextLine();
                    System.out.println(dealership.getVehicleByType(type).toString());
                    break;
                case "7":
                    // Return to main menu
                    display();
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    searchMenu(scanner);

            }
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

    private void removeVehicleMenu(Scanner inputScanner){
        System.out.print("Enter VIN of the vehicle to remove: ");
        int vin = inputScanner.nextInt();
        inputScanner.nextLine(); // Consume newline
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                dealership.removeVehicle(vehicle);
                System.out.println("Vehicle removed.");
                return;
            }
        }
    }

    private void displayVehicles(ArrayList<Vehicle> vehicleList){
        for (Vehicle vehicle : vehicleList) {
            System.out.print("\n" + vehicle.getYear() + " " + vehicle.getMake() + " " + vehicle.getModel() + " \n" + "    "
                    + "Type: " + vehicle.getVehicleType() + " | Milage: " + vehicle.getOdometer() + " | Price: $" +
                    vehicle.getPrice() + " | Vin:" + vehicle.getVin() + "\n");
        }
        System.out.println("\n");
    }




}
