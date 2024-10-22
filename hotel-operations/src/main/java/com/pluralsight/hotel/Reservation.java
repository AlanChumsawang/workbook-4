package com.pluralsight.hotel;

public class Reservation {
    private final String roomType;
    private double price;
    private int numberOfNights;
    private boolean isWeekend;
    private final double total;

    public Reservation(String roomType, int numberOfNights, boolean isWeekend) {
        if (roomType.equalsIgnoreCase("king")){
            this.price = 139.00;
        }
        else {
            this.price = 124.00;
        }
        this.roomType = roomType;
        this.isWeekend = isWeekend;
        if(!isWeekend) {
            this.total = price * numberOfNights;
        }
        else {
            this.total = ((price * .10) + price) * numberOfNights;
        }
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public double getTotal() {
        return total;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }
}
