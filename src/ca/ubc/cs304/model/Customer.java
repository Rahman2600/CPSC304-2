//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ca.ubc.cs304.model;

public class Customer {
    private final String name;
    private final String address;
    private final String license;

    public Customer(String license, String name, String address) {
        this.name = name;
        this.address = address;
        this.license = license;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getLicense() {
        return this.license;
    }
}
