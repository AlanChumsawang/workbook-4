package com.pluralsight.cardealership;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DealershipFileManager.readCSV(scanner);
    }
}
