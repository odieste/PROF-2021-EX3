package es.upm.grise.profundizacion.customer;

import org.junit.jupiter.api.Test;

public class smokeTest {

	@Test
	public void test() throws CustomerException, DatabaseException {
		int CUSTOMERID = 1;
		
		Customer customer = new Customer(CUSTOMERID,new CustomerDataAccessSingletonDouble());
	}

}
