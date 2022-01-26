package es.upm.grise.profundizacion.customer;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class smokeTest {

	private CustomerDataAccessSingleton customerDataAccessSingleton;

	@Test
	public void testSameAddress() throws CustomerException, DatabaseException, EmptyAddressException, NoAddressException {
		int CUSTOMERID = 1;
		
		Customer customer = new Customer(CUSTOMERID, "Hola", "Hola");
		assert customer.checkAddresses();
	}
	@Test
	public void testDifferentAddress() throws CustomerException, DatabaseException, EmptyAddressException, NoAddressException {
		int CUSTOMERID = 1;

		Customer customer = new Customer(CUSTOMERID, "Hola", "Cara");
		assert !customer.checkAddresses();
	}



}
