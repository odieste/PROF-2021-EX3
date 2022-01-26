package es.upm.grise.profundizacion.customer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class smokeTest {

	@Test
	public void test() throws CustomerException, DatabaseException {
		int CUSTOMERID = 1;
		
		Customer customer = new Customer(CUSTOMERID, "", "");
	}

	@Test
	public void equalAddresses_returnTrue() throws NoAddressException, EmptyAddressException {
		int CUSTOMERID = 1;
		Customer customer = new Customer(CUSTOMERID, "Calle Falsa 123", "Calle Falsa 123");

		assertTrue(customer.checkAddresses());
	}

	@Test
	public void shorterShippingAddress_returnFalse() throws NoAddressException, EmptyAddressException {
		int CUSTOMERID = 1;
		Customer customer = new Customer(CUSTOMERID, "Calle Falsa", "Calle Falsa 123");

		assertFalse(customer.checkAddresses());
	}

	@Test
	public void equalAddresses_returnFalse() throws NoAddressException, EmptyAddressException {
		int CUSTOMERID = 1;
		Customer customer = new Customer(CUSTOMERID, "Calle Verdadera 123", "Calle Falsa 123");

		assertFalse(customer.checkAddresses());
	}

}
