package es.upm.grise.profundizacion.customer;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith(MockitoExtension.class)
public class smokeTest {
	
	Customer customer;
	
	@Mock
	CustomerDataAccessSingleton customerDataAccessSingleton;
	

	@Test
	public void test() throws CustomerException, DatabaseException {
		int CUSTOMERID = 1;
				
		Customer customer = new Customer(CUSTOMERID, customerDataAccessSingleton);
	}
	
	@Test
	public void checkAddresses_caso1_test() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
		int CUSTOMERID = 1;
		
		when(customerDataAccessSingleton.getShippingAddress(CUSTOMERID)).thenReturn("valor");
		when(customerDataAccessSingleton.getInvoicingAddress(CUSTOMERID)).thenReturn("valor");
		customer = new Customer(CUSTOMERID, customerDataAccessSingleton);
		
		assertTrue(customer.checkAddresses());
	}
	
	@Test
	public void checkAddresses_caso2_test() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
		int CUSTOMERID = 1;
		
		when(customerDataAccessSingleton.getShippingAddress(CUSTOMERID)).thenReturn("valor");
		when(customerDataAccessSingleton.getInvoicingAddress(CUSTOMERID)).thenReturn("calor");
		customer = new Customer(CUSTOMERID, customerDataAccessSingleton);
		
		assertFalse(customer.checkAddresses());
	}
}
