//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ca.ubc.cs304.model;

public class Reservation {
    private final int confirmation;
    private final String location;
    private final String license;
    private final String city;
    private final String vType;
    private final int pickUpTime;
    private final String pickUpDay;
    private final int returnTime;
    private final String returnDay;

    public Reservation(int confirmation, String license, String location, String vType, int pickUpTime, String pickUpDay, int returnTime, String returnDay, String city) {
        this.location = location;
        this.confirmation = confirmation;
        this.license = license;
        this.vType = vType;
        this.city = city;
        this.pickUpTime = pickUpTime;
        this.returnDay = returnDay;
        this.pickUpDay = pickUpDay;
        this.returnTime = returnTime;
    }

    public String getLocation() {
        return this.location;
    }

    public String getCity() {
        return this.city;
    }

    public String getLicense() {
        return this.license;
    }

    public String getvType() {
        return this.vType;
    }

    public String getPickUpDay() {
        return this.pickUpDay;
    }

    public int getPickUpTime() {
        return this.pickUpTime;
    }

    public int getConfirmation() {
        return this.confirmation;
    }

    public int getReturnTime() {
        return this.returnTime;
    }

    public String getReturnDay() {
        return this.returnDay;
    }
}
