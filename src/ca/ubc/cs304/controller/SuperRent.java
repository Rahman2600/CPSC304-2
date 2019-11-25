//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package ca.ubc.cs304.controller;

import ca.ubc.cs304.database.DatabaseConnectionHandler;
import ca.ubc.cs304.delegates.LoginWindowDelegate;
import ca.ubc.cs304.delegates.RegisterWindowDelegate;
import ca.ubc.cs304.delegates.TerminalTransactionsDelegate;
import ca.ubc.cs304.model.Customer;
import ca.ubc.cs304.model.Reservation;
import ca.ubc.cs304.model.Vehicle;
import ca.ubc.cs304.ui.LoginWindow;
import ca.ubc.cs304.ui.RegisterWindow;
import ca.ubc.cs304.ui.TerminalTransactions;
import java.io.PrintStream;

public class
SuperRent implements LoginWindowDelegate, TerminalTransactionsDelegate, RegisterWindowDelegate {
    private DatabaseConnectionHandler dbHandler = null;
    private LoginWindow loginWindow = null;
    private RegisterWindow registerWindow = null;

    public SuperRent() {
        this.dbHandler = new DatabaseConnectionHandler();
    }

    private void start() {
        this.loginWindow = new LoginWindow();
        this.loginWindow.showFrame(this);
    }

    public void login(String username, String password) {
        boolean didConnect = this.dbHandler.login(username, password);
        if (didConnect) {
            this.loginWindow.dispose();
            TerminalTransactions transaction = new TerminalTransactions();
            transaction.showMainMenu(this);
        } else {
            this.loginWindow.handleLoginFailed();
            if (this.loginWindow.hasReachedMaxLoginAttempts()) {
                this.loginWindow.dispose();
                System.out.println("You have exceeded your number of allowed attempts");
                System.exit(-1);
            }
        }

    }

    private void updateVehicle(String vlicence) {
        this.dbHandler.updateVehicle(vlicence);
    }

    public void insertCustomer(Customer customer) {
        this.dbHandler.insertCustomer(customer);
    }

    public void reserveVehicle(Reservation reservation) {
        Vehicle[] vehicles = this.dbHandler.showAvailableCars();
        String vlicense = null;
        Vehicle[] var4 = vehicles;
        int var5 = vehicles.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Vehicle vehicle = var4[var6];
            if (vehicle.getVtName().equals(reservation.getvType()) && vehicle.getFromDate().equals(reservation.getPickUpDay()) && vehicle.getFromTime() == reservation.getPickUpTime() && vehicle.getToDate().equals(reservation.getReturnDay()) && vehicle.getToTime() == reservation.getReturnTime()) {
                System.out.println("confirmation:" + reservation.getConfirmation());
                System.out.println("Vehicle Name:" + reservation.getvType());
                PrintStream var10000 = System.out;
                String var10001 = reservation.getPickUpDay();
                var10000.println("From: " + var10001 + "Time" + reservation.getPickUpTime());
                var10000 = System.out;
                var10001 = reservation.getReturnDay();
                var10000.println("To:" + var10001 + "Time:" + reservation.getReturnTime());
                vlicense = vehicle.getLicense();
                break;
            }
        }

        if (vlicense != null) {
            this.updateVehicle(vlicense);
            this.dbHandler.insertReservation(reservation);
        } else {
            System.out.println("No available vehicles for that Time and Type");
        }

    }

    public void showAvailableCars() {
        Vehicle[] vehicles = this.dbHandler.showAvailableCars();
        this.printVehicles(vehicles);
        System.out.print(vehicles.length);
    }

    public void showSelected(String ct, String loc, String fd, int ft, String td, int tt) {
        Vehicle[] vehicles = this.dbHandler.showSelected(ct, loc, fd, ft, td, tt);
        this.printVehicles(vehicles);
    }

    private void printVehicles(Vehicle[] vehicles) {
        Vehicle[] var2 = vehicles;
        int var3 = vehicles.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Vehicle model = var2[var4];
            System.out.printf("%-20.20s", model.getLicense());
            System.out.printf("%-20.20s", model.getMake());
            System.out.printf("%-20.20s", model.getModel());
            System.out.printf("%-20.20s", model.getYear());
            System.out.printf("%-20.20s", model.getColor());
            System.out.printf("%-20.20s", model.getOdometer());
            System.out.printf("%-20.20s", model.getStatus());
            System.out.println();
        }

    }

    public void terminalTransactionsFinished() {
        this.dbHandler.close();
        this.dbHandler = null;
        System.exit(0);
    }

    public static void main(String[] args) {
        SuperRent bank = new SuperRent();
        bank.start();
    }
}
