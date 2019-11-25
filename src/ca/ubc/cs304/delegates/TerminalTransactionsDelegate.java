package ca.ubc.cs304.delegates;

import ca.ubc.cs304.model.BranchModel;
import ca.ubc.cs304.model.Customer;
import ca.ubc.cs304.model.Reservation;

/**
 * This interface uses the delegation design pattern where instead of having
 * the TerminalTransactions class try to do everything, it will only
 * focus on handling the UI. The actual logic/operation will be delegated to the 
 * controller class (in this case Bank).
 * 
 * TerminalTransactions calls the methods that we have listed below but 
 * Bank is the actual class that will implement the methods.
 */
public interface TerminalTransactionsDelegate {
	void showAvailableCars();

	void insertCustomer(Customer var1);

	void showSelected(String var1, String var2, String var3, int var4, String var5, int var6);

	void reserveVehicle(Reservation var1);

	void terminalTransactionsFinished();
}
