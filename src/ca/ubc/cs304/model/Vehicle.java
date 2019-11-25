//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ca.ubc.cs304.model;

public class Vehicle {
    private final String licence;
    private final String status;
    private final String city;
    private final int year;
    private final String vtName;
    private final String fromDate;
    private final int fromTime;
    private final String toDate;
    private final int toTime;
    private final int odometer;
    private final String make;
    private final String model;
    private final String color;
    private final String location;

    public Vehicle(String license, String make, String model, int year, String color, int odometer, String status, String vtName, String fromDate, int fromTime, String toDate, int toTime, String location, String city) {
        this.licence = license;
        this.city = city;
        this.year = year;
        this.vtName = vtName;
        this.status = status;
        this.fromDate = fromDate;
        this.fromTime = fromTime;
        this.toDate = toDate;
        this.toTime = toTime;
        this.odometer = odometer;
        this.make = make;
        this.model = model;
        this.color = color;
        this.location = location;
    }

    public String getLicense() {
        return this.licence;
    }

    public String getStatus() {
        return this.status;
    }

    public String getCity() {
        return this.city;
    }

    public String getLocation() {
        return this.location;
    }

    public String getVtName() {
        return this.vtName;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public String getFromDate() {
        return this.fromDate;
    }

    public String getToDate() {
        return this.toDate;
    }

    public int getFromTime() {
        return this.fromTime;
    }

    public int getToTime() {
        return this.toTime;
    }

    public String getColor() {
        return this.color;
    }

    public int getYear() {
        return this.year;
    }

    public int getOdometer() {
        return this.odometer;
    }
}
