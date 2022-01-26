package es.upm.grise.profundizacion.customer;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import es.upm.grise.profundizacion.customer.CustomerDataAccessSingleton;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

public class smokeTest {

	@Test
	public void test() throws CustomerException, DatabaseException {
		int CUSTOMERID = 1;
		
		Customer customer = new Customer(CUSTOMERID);
	}

	@Test
	public void checkaddressestest1() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException  {
		
        int CUSTOMERID = 1;
		
		//Customer customer = new Customer(CUSTOMERID);
		
		CustomerDataAccessSingleton c = mock(CustomerDataAccessSingleton.class);
		when(c.getInvoicingAddress(CUSTOMERID)).thenReturn("C/Neptuno");
		when(c.getShippingAddress(CUSTOMERID)).thenReturn("C/Neptuno");
		Customer customer = new Customer(CUSTOMERID);
		assertTrue(customer.checkAddresses());
	
	
	}
	
	@Test
	public void checkaddressestest2() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException  {
		
		int CUSTOMERID = 1;
		CustomerDataAccessSingleton c = mock(CustomerDataAccessSingleton.class);
		when(c.getInvoicingAddress(CUSTOMERID)).thenReturn("C/Venus");
		when(c.getShippingAddress(CUSTOMERID)).thenReturn("C/Neptuno");
		Customer customer = new Customer(CUSTOMERID);
		assertFalse(customer.checkAddresses());
	
	
	}
	
	
	
}
