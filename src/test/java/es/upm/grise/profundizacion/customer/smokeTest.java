package es.upm.grise.profundizacion.customer;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class smokeTest {

	//@Mock
	//Customer customer;

	@Mock
	CustomerDataAccessSingleton customerDataAccessSingleton;

	/*
	@Test
	public void test() throws CustomerException, DatabaseException {
		int CUSTOMERID = 1;
		
		Customer customer = new Customer(CUSTOMERID);
	}*/

	@Test
	public void checkAddressesMismoString() throws EmptyAddressException, NoAddressException {
		Customer customer = new Customer(1, "gato", "gato");
		assertEquals(customer.checkAddresses(), true);
	}

	@Test
	public void checkAddressesDistintoStringMismaLong() throws EmptyAddressException, NoAddressException {
		Customer customer = new Customer(1, "gato", "pera");
		assertEquals(customer.checkAddresses(), true);
	}

}
