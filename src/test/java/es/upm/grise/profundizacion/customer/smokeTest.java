package es.upm.grise.profundizacion.customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class smokeTest {

	private CustomerDataAccessSingleton customerData;
	
	@Test
	public void test() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
		int CUSTOMERID = 1;
		Customer customer = new Customer(CUSTOMERID);
		assertTrue(customer.checkAddresses());
	}
	
	@Test
	public void test_distinto_address() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
		int CUSTOMERID = 1;
		Customer customer = new Customer(CUSTOMERID);
		assertFalse(customer.checkAddresses());
		
	}
	@Test
	public void test_same_address_mock() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
		int CUSTOMERID = 1;
		customerData = mock(CustomerDataAccessSingleton.class);
		when(customerData.getShippingAddress(CUSTOMERID)).thenReturn("Prueba1");
		when(customerData.getInvoicingAddress(CUSTOMERID)).thenReturn("Prueba1");
		Customer customer = new Customer(CUSTOMERID);
		assertTrue(customer.checkAddresses());
		
		
	}
	@Test
	public void test_distinto_address_mock() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
		int CUSTOMERID = 1;
		customerData = mock(CustomerDataAccessSingleton.class);
		when(customerData.getShippingAddress(CUSTOMERID)).thenReturn("Prueba1");
		when(customerData.getInvoicingAddress(CUSTOMERID)).thenReturn("1Prueba");
		Customer customer = new Customer(CUSTOMERID);
		assertFalse(customer.checkAddresses());
	}
	

}
