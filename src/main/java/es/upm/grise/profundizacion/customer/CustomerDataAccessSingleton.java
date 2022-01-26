package es.upm.grise.profundizacion.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

final public class CustomerDataAccessSingleton {
	
	private static final String url = "jdbc:mysql://profundizacion.grise.upm.es:3306/customers";
	private static final String username = "root";
	private static final String password = "1234";
	
	private static CustomerDataAccessSingleton instance;

	//
	// Singleton access method
	public static CustomerDataAccessSingleton getInstance() {
		
		if (instance != null)
			return instance;
		else {
			instance = new CustomerDataAccessSingleton();
			return instance;
		}
		
	}

	//
	// Constructor
	private CustomerDataAccessSingleton() {
		
	}
	
	//
	// Get the shipping address from DB
	public String getShippingAddress(int id) throws CustomerException, DatabaseException {
		
		return getAddress(id, "shippingAddress");
		
	}
	
	//
	// Get the invoicing address from DB
	public String getInvoicingAddress(int id) throws CustomerException, DatabaseException {
		
		return getAddress(id, "invoicingAddress");
		
	}
	
	//
	// Returns a String from a Customer record. Used to extract the addresses.
	// In case of error, returns a generic "CustomerException" for customer-related problems
	// For database problems, it returns a generic "DatabaseException"
	private String getAddress(int id, String type) throws CustomerException, DatabaseException {
		
		String address = null;
		int numHits = 0;
		
		ResultSet resultSetCustomer;
		try {

			resultSetCustomer = getCustomerData(id);

			while(resultSetCustomer.next()) {
				numHits++;
				address = resultSetCustomer.getString(type);
			}
		
		} catch (SQLException e) {
			throw new DatabaseException();
		}
		
		if(numHits == 1)
			return address;
		else
			throw new CustomerException();
		
	}

	//
	// Get the Customer record from DB
	private ResultSet getCustomerData(int id) throws SQLException {
			
		Connection connection = DriverManager.getConnection(url, username, password);
		
		String queryCustomer = "SELECT * FROM CUSTOMERS WHERE id = " + String.valueOf(id);
		Statement statementCustomer = connection.createStatement();
		ResultSet resultSetCustomer = statementCustomer.executeQuery(queryCustomer);
		return resultSetCustomer;	
		
	}
	
}
