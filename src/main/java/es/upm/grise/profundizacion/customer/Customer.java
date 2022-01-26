package es.upm.grise.profundizacion.customer;

public class Customer {
	
	// Customer id
	protected int id;
	
	// Shipping address
	protected String shippingAddress;
	
	// Invoicing address
	protected String invoicingAddress;

	// When the customer is created, the id and addresses are loaded from the database
	Customer(int id, String shippingAddress, String invoicingAddress) throws CustomerException, DatabaseException {
		this.id = id;
		this.shippingAddress = shippingAddress;
		this.invoicingAddress = invoicingAddress;
	}

	// Checks if the shipping address is the same than the invoicing address
	public boolean checkAddresses() throws NoAddressException, EmptyAddressException { //1
		if(shippingAddress == null || invoicingAddress == null) //2
			throw new NoAddressException(); //3
		
		if(shippingAddress.length() == 0 || invoicingAddress.length() == 0) //4
			throw new EmptyAddressException(); //5
		
		if(shippingAddress.length() != invoicingAddress.length()) //6
			return false;  //7
		
		int stringLength = shippingAddress.length();
		int index = 0;
		
		while(index < stringLength &&
			  shippingAddress.charAt(index) == invoicingAddress.charAt(index)) //8
			index++; //9
		
		if(index == stringLength)  //10
			return true; //11
		else
			return false; //12
	}	
}
