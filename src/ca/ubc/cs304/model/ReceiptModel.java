package ca.ubc.cs304.model;

import java.util.Date;

public class ReceiptModel {
    private final int confirmationNumber;
    private final Date date;
    private final String carType;
    private final String location;
    private final int lengthOfRental;

    public ReceiptModel(int confirmationNumber, Date date, String carType, String location, int lengthOfRental) {
        this.confirmationNumber = confirmationNumber;
        this.date = date;
        this.carType = carType;
        this.location = location;
        this.lengthOfRental = lengthOfRental;
    }

    public int getConfirmationNumber() {
        return confirmationNumber;
    }

    public Date getDate() {
        return date;
    }

    public String getCarType() {
        return carType;
    }

    public String getLocation() {
        return location;
    }

    public int getLengthOfRental() {
        return lengthOfRental;
    }
}