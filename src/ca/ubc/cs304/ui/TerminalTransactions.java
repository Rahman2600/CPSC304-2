package ca.ubc.cs304.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ca.ubc.cs304.delegates.TerminalTransactionsDelegate;
import ca.ubc.cs304.model.BranchModel;
import ca.ubc.cs304.model.Customer;
import ca.ubc.cs304.model.Reservation;

/**
 * The class is only responsible for handling terminal text inputs. 
 */
public class TerminalTransactions {
	private static final String EXCEPTION_TAG = "[EXCEPTION]";
	private static final String WARNING_TAG = "[WARNING]";
	private static final int INVALID_INPUT = Integer.MIN_VALUE;
	private static final int EMPTY_INPUT = 0;
	
	private BufferedReader bufferedReader = null;
	private TerminalTransactionsDelegate delegate = null;

	public TerminalTransactions() {
	}

	/**
	 * Displays simple text interface
	 */ 
	public void showMainMenu(TerminalTransactionsDelegate delegate) {
		this.delegate = delegate;
		
	    bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int choice = INVALID_INPUT;

		while(choice != 5) {
			System.out.println();
			System.out.println("1. See available Vehicles");
			System.out.println("2. New? Register");
			System.out.println("3. See available vehicle of your choice");
			System.out.println("4. Make a Reservation");
			System.out.println("5. Rent a vehicle");
			System.out.println("6. Quit");
			System.out.print("Please choose one of the above options: ");

			choice = this.readInteger(false);
			System.out.println(" ");
			if (choice != INVALID_INPUT) {
				switch(choice) {
					case 1:
						delegate.showAvailableCars();
						break;
					case 2:
						this.handleInsertCustomer();
						break;
					case 3:
						this.handleSelectedOption();
						break;
					case 4:
						this.handleMakeReservation();
					case 5:
						this.handleRentVehicle();
					case 6:
						this.handleQuitOption();
						break;
					default:
						System.out.println("[WARNING] The number that you entered was not a valid option.");
				}
			}
		}

	}

	private void handleSelectedOption() {
		String carType = "";
		String location = "";
		String fromDay = "";
		int fromTime = -2147483648;
		String toDay = "";

		int toTime;
		for(toTime = -2147483648; carType.equals(""); carType = this.readLine().trim()) {
			System.out.print("Please enter car Type: ");
		}

		while(location.equals("")) {
			System.out.print("Please enter preferred location: ");
			System.out.print(location);
			location = this.readLine().trim();
		}

		while(fromDay.equals("")) {
			System.out.print("Please enter what day works for you: ");
			fromDay = this.readLine().trim();
		}

		while(fromTime == -2147483648) {
			System.out.print("Please enter time for pick up in 24 hour clock system eg 1200: ");
			fromTime = this.readInteger(false);
		}

		while(toDay.equals("")) {
			System.out.print("Please enter return day: ");
			toDay = this.readLine().trim();
		}

		while(toTime == -2147483648) {
			System.out.print("Please enter return time: ");
			toTime = this.readInteger(false);
		}

		this.delegate.showSelected(carType, location, fromDay, fromTime, toDay, toTime);
	}

	private void handleInsertCustomer() {
		String name;
		for(name = null; name == null || name.length() <= 0; name = this.readLine().trim()) {
			System.out.print("Please enter your name: ");
		}

		System.out.print("Please enter your address: ");
		String address = this.readLine().trim();
		if (address.length() == 0) {
			address = null;
		}

		String license;
		for(license = null; license == null || license.length() <= 0; license = this.readLine().trim()) {
			System.out.print("Please enter your licence: ");
		}

		Customer model = new Customer(name, address, license);
		this.delegate.insertCustomer(model);
	}

	private void handleMakeReservation() {
		int confNo = 900908;

		String vTname;
		for(vTname = null; vTname == null || vTname.length() <= 0; vTname = this.readLine().trim()) {
			System.out.print("Please enter the vehicle name you wish to reserve: ");
		}

		String license;
		for(license = null; license == null || license.length() <= 0; license = this.readLine().trim()) {
			System.out.print("Please enter Your driver's license: ");
		}

		String fromDay;
		for(fromDay = null; fromDay == null || fromDay.length() <= 0; fromDay = this.readLine().trim()) {
			System.out.print("Please enter: Date for reservation ");
		}

		String location;
		for(location = null; location == null || location.length() <= 0; location = this.readLine()) {
			System.out.print("Please enter your preferred Location: ");
		}

		String city;
		for(city = null; city == null || city.length() <= 0; city = this.readLine().trim()) {
			System.out.print("Please enter the city: ");
		}

		int fromTime;
		for(fromTime = -2147483648; fromTime == -2147483648; fromTime = this.readInteger(false)) {
			System.out.print("Please enter pick up time: ");
		}

		String toDay;
		for(toDay = null; toDay == null || toDay.length() <= 0; toDay = this.readLine().trim()) {
			System.out.print("Please enter return day: ");
		}

		int toTime;
		for(toTime = -2147483648; toTime == -2147483648; toTime = this.readInteger(false)) {
			System.out.print("Please enter return time: ");
		}

		Reservation model = new Reservation(confNo, license, location, vTname, fromTime, fromDay, toTime, toDay, city);
		this.delegate.reserveVehicle(model);
	}

	private void handleRentVehicle() {

	}

	private void handleQuitOption() {
		System.out.println("Good Bye!");
		
		if (bufferedReader != null) {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				System.out.println("IOException!");
			}
		}
		
		delegate.terminalTransactionsFinished();
	}

	
	private int readInteger(boolean allowEmpty) {
		String line = null;
		int input = INVALID_INPUT;
		try {
			line = bufferedReader.readLine();
			input = Integer.parseInt(line);
		} catch (IOException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		} catch (NumberFormatException e) {
			if (allowEmpty && line.length() == 0) {
				input = EMPTY_INPUT;
			} else {
				System.out.println(WARNING_TAG + " Your input was not an integer");
			}
		}
		return input;
	}
	
	private String readLine() {
		String result = null;
		try {
			result = bufferedReader.readLine();
		} catch (IOException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
		return result;
	}
}
