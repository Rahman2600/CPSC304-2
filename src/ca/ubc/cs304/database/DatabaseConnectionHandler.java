package ca.ubc.cs304.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ca.ubc.cs304.model.*;

/**
 * This class handles all database related transactions
 */
public class DatabaseConnectionHandler {
//	private static final String ORACLE_URL = "jdbc:oracle:thin:@dbhost.students.cs.ubc.ca:1522:stu";
	private static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1522:stu";
	private static final String EXCEPTION_TAG = "[EXCEPTION]";
	private static final String WARNING_TAG = "[WARNING]";
	
	private Connection connection = null;
	
	public DatabaseConnectionHandler() {
		try {
			// Load the Oracle JDBC driver
			// Note that the path could change for new drivers
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}
	
	public void close() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}

	public void insertCustomer(Customer model) {
		try {
			PreparedStatement ps = this.connection.prepareStatement("INSERT INTO customer VALUES (?,?,?)");
			ps.setString(1, model.getName());
			ps.setString(2, model.getAddress());
			ps.setString(3, model.getLicense());
			ps.executeUpdate();
			this.connection.commit();
			ps.close();
		} catch (SQLException var3) {
			System.out.println("[EXCEPTION] " + var3.getMessage());
			this.rollbackConnection();
		}

	}

	public void updateVehicle(String vlicense) {
		try {
			PreparedStatement ps = this.connection.prepareStatement("UPDATE forRent set status = 'Taken' where vlicense = ?");
			ps.setString(1, vlicense);
			ps.executeUpdate();
			this.connection.commit();
			ps.close();
		} catch (SQLException var3) {
			System.out.println("[EXCEPTION] " + var3.getMessage());
			this.rollbackConnection();
		}

	}

	public void insertReservation(Reservation model) {
		try {
			PreparedStatement ps = this.connection.prepareStatement("INSERT INTO reservation VALUES (?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, model.getConfirmation());
			ps.setString(2, model.getvType());
			ps.setString(3, model.getLicense());
			ps.setString(4, model.getPickUpDay());
			ps.setInt(5, model.getPickUpTime());
			ps.setString(6, model.getReturnDay());
			ps.setInt(7, model.getReturnTime());
			ps.setString(8, model.getLocation());
			ps.setString(9, model.getCity());
			ps.executeUpdate();
			this.connection.commit();
			ps.close();
		} catch (SQLException var3) {
			System.out.println("[EXCEPTION] " + var3.getMessage());
			this.rollbackConnection();
		}

	}

	public Vehicle[] showAvailableCars() {
		ArrayList result = new ArrayList();

		try {
			Statement stmt = this.connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM forRent WHERE status = 'Available'");
			boolean isEmpty = true;

			while(rs.next()) {
				isEmpty = false;
				Vehicle model = new Vehicle(rs.getString("VLICENSE"), rs.getString("MAKE"), rs.getString("MODEL"), rs.getInt("YEAR"), rs.getString("COLOR"), rs.getInt("ODOMETER"), rs.getString("STATUS"), rs.getString("VTNAME"), rs.getString("FROMDATE"), rs.getInt("FROMTIME"), rs.getString("TODATE"), rs.getInt("TOTIME"), rs.getString("LOCATION"), rs.getString("CITY"));
				result.add(model);
			}

			rs.close();
			stmt.close();
		} catch (SQLException var6) {
			System.out.println("[EXCEPTION] " + var6.getMessage());
		}

		return (Vehicle[])result.toArray(new Vehicle[result.size()]);
	}

	public Vehicle[] showSelected(String ct, String loc, String fd, int ft, String td, int tt) {
		ArrayList<Vehicle> result = new ArrayList();
		String s = "SELECT * FROM forRent WHERE status = 'Available' and location = ? and vtname = ?  and fromDate = ? and fromTime = ? and toDate = ? and toTime = ?";

		try {
			PreparedStatement ps = this.connection.prepareStatement(s);
			ps.setString(1, loc);
			ps.setString(2, ct);
			ps.setString(3, fd);
			ps.setInt(4, ft);
			ps.setString(5, td);
			ps.setInt(6, tt);
			ResultSet rs = ps.executeQuery();
			boolean isEmpty = true;

			while(rs.next()) {
				isEmpty = false;
				Vehicle model = new Vehicle(rs.getString("VLICENSE"), rs.getString("MAKE"), rs.getString("MODEL"), rs.getInt("YEAR"), rs.getString("COLOR"), rs.getInt("ODOMETER"), rs.getString("STATUS"), rs.getString("VTNAME"), rs.getString("FROMDATE"), rs.getInt("FROMTIME"), rs.getString("TODATE"), rs.getInt("TOTIME"), rs.getString("LOCATION"), rs.getString("CITY"));
				result.add(model);
			}

			if (isEmpty) {
				System.out.print("no available vehicles for given date and time");
			}

			rs.close();
			ps.close();
		} catch (SQLException var13) {
			System.out.println("[EXCEPTION] " + var13.getMessage());
		}

		return (Vehicle[])result.toArray(new Vehicle[result.size()]);
	}
	
	public boolean login(String username, String password) {
		try {
			if (connection != null) {
				connection.close();
			}
	
			connection = DriverManager.getConnection(ORACLE_URL, username, password);
			connection.setAutoCommit(false);
	
			System.out.println("\nConnected to Oracle!");
			return true;
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
			return false;
		}
	}

	private void rollbackConnection() {
		try  {
			connection.rollback();	
		} catch (SQLException e) {
			System.out.println(EXCEPTION_TAG + " " + e.getMessage());
		}
	}
}
