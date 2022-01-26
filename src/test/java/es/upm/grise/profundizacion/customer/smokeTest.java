package es.upm.grise.profundizacion.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class smokeTest {

	CustomerDataAccess customerDataAccess = new DummyDataAccess();
	
	@Test
	public void test() throws CustomerException, DatabaseException {
		int CUSTOMERID = 1;		
		Customer customer = new Customer(CUSTOMERID, customerDataAccess);
	}

	/* 
	 * TEST CASE 1
	 * shippingAddress = "Pepe"
	 * invoiceAddress = "Pepe"
	 * expect = 0
	 */
	@Test
	public void testCheckAddress1() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
		Customer customer = new Customer(0, customerDataAccess);
		assertEquals(true, customer.checkAddresses());
	}
	
	
	/*
	 * TEST CASE 2
	 * shippingAddress = "Pepe"
	 * invoiceAddress = "Jose"
	 * expect = 0
	 */
	@Test
	public void testCheckAddress2() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
		Customer customer = new Customer(1, customerDataAccess);
		assertEquals(false, customer.checkAddresses());
	}
	
}
