package es.upm.grise.profundizacion.customer;

import org.junit.jupiter.api.Test;

public class smokeTest {

	CustomarDataAccess customerDAS;

	@Test
	public void test() throws CustomerException, DatabaseException {
		int CUSTOMERID = 1;
		customerDAS = new CustomarDataAccess();
		Customer customer = new Customer(CUSTOMERID, customerDAS);
	}

}
