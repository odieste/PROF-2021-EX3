package es.upm.grise.profundizacion.customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class smokeTest {

	@Test
	public void test() throws CustomerException, DatabaseException {
		int CUSTOMERID = 1;
		Customer customer = new Customer(CUSTOMERID, "pepe", "pepe");
	}

	@Test
	public void testBucle1() throws CustomerException, DatabaseException, EmptyAddressException, NoAddressException {
		int CUSTOMERID = 1;
		// Mockito.when(CustomerDataAccessSingleton.getInstance().getShippingAddress(CUSTOMERID)).thenReturn("pepe");
		// Mockito.when(CustomerDataAccessSingleton.getInstance().getInvoicingAddress(CUSTOMERID)).thenReturn("pepe");

		Customer customer = new Customer(CUSTOMERID, "pepe", "pepe");
		assertEquals(customer.checkAddresses(), true);
	}


	@Test
	public void testBucle2() throws CustomerException, DatabaseException, EmptyAddressException, NoAddressException {
		int CUSTOMERID = 1;
		Customer customer = new Customer(CUSTOMERID, "1pepe", "2pepe");
		assertEquals(customer.checkAddresses(), false);
	}

}
