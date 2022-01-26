package es.upm.grise.profundizacion.customer;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import es.upm.grise.profundizacion.customer.CustomerDataAccessSingleton;

public class smokeTest {

	@Test
	public void test() throws CustomerException, DatabaseException {
		int CUSTOMERID = 1;
		
		Customer customer = new Customer(CUSTOMERID);
		
	}
	
	@Test
	public void direcciones_iguales() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
		int CUSTOMERID = 1;
		CustomerDataAccessSingleton cda = mock(CustomerDataAccessSingleton.class);
	    when(cda.getInvoicingAddress(CUSTOMERID)).thenReturn("C/Ora");
	    when(cda.getShippingAddress(CUSTOMERID)).thenReturn("C/Ora");
	    Customer customer = new Customer(CUSTOMERID);
	    assertTrue(customer.checkAddresses());
	}
	
	@Test
	public void direcciones_distintas() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
		int CUSTOMERID = 1;
		CustomerDataAccessSingleton cda = mock(CustomerDataAccessSingleton.class);
	    when(cda.getInvoicingAddress(CUSTOMERID)).thenReturn("C/Ora");
	    when(cda.getShippingAddress(CUSTOMERID)).thenReturn("C/Santander");
	    Customer customer = new Customer(CUSTOMERID);
	    assertTrue(!customer.checkAddresses());
	}
}
