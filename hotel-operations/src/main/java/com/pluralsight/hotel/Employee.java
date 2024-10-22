package com.pluralsight.hotel;

public class Employee {
    private final int employeeID;
    private final String name;
    private final String department;
    private final double payRate;
    private final float hoursWorked;
    private final double totalPay;
    private final float overtimeHours;

    public float getOvertimeHours() {
        return overtimeHours;
    }

    public Employee(int employeeID, String name, String department, double payRate, float hoursWorked) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.totalPay = payRate * hoursWorked;
        if (hoursWorked > 40) {
            this.overtimeHours = (hoursWorked - 40);
        }
        else {
            this.overtimeHours = 0;
        }

    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public float getHoursWorked() {
        return hoursWorked;
    }

    public double getTotalPay() {
        return totalPay;
    }
}
