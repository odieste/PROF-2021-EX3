package es.upm.grise.profundizacion.customer;

import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class Customer {
	
	// Customer id
	private int id;
	
	// Shipping address
	private String shippingAddress;
	
	// Invoicing address
	private String invoicingAddress;
	
	// When the customer is created, the id and addresses are loaded from the database
	Customer(int id){
		this.id = id;
	}

	public void customerInit() throws CustomerException, DatabaseException {
		this.shippingAddress = CustomerDataAccessSingleton.getInstance().getShippingAddress(id);
		this.invoicingAddress = CustomerDataAccessSingleton.getInstance().getInvoicingAddress(id);
	}

	public void customerInit_Test(String ship, String inv) throws CustomerException, DatabaseException {

		// Aquí lo que hago es crearme mi propia instancia a mi manera y se la paso
		CustomerDataAccessSingleton c = Mockito.mock(CustomerDataAccessSingleton.class);
		CustomerDataAccessSingleton ca = CustomerDataAccessSingleton.getInstance();
		when(c.getShippingAddress(id)).thenReturn(ship);
		when(c.getInvoicingAddress(id)).thenReturn(inv);
		ca.changeToMock(c);


		this.shippingAddress = CustomerDataAccessSingleton.getInstance().getShippingAddress(id);
		this.invoicingAddress = CustomerDataAccessSingleton.getInstance().getInvoicingAddress(id);

		System.out.println("ship: " +this.shippingAddress+ ", inv: "+this.invoicingAddress);
	}




	// Checks if the shipping address is the same than the invoicing address
	public boolean checkAddresses() throws NoAddressException, EmptyAddressException {
		if(shippingAddress == null || invoicingAddress == null)
			throw new NoAddressException();
		
		if(shippingAddress.length() == 0 || invoicingAddress.length() == 0)
			throw new EmptyAddressException();
		
		if(shippingAddress.length() != invoicingAddress.length())
			return false;
		
		int stringLength = shippingAddress.length();
		int index = 0;
		
		while(index < stringLength &&
			  shippingAddress.charAt(index) == invoicingAddress.charAt(index))
			index++;
		
		if(index == stringLength)
			return true;
		else
			return false;
	}	
}
