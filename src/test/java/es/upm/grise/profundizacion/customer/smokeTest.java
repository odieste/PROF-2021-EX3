package es.upm.grise.profundizacion.customer;

import org.junit.jupiter.api.Test;

public class smokeTest {

	@Test
	public void test() throws CustomerException, DatabaseException {
		int CUSTOMERID = 1;
		String a = "prueba1";
		String b = "prueba2";
		Customer customer = new Customer(CUSTOMERID,a, b);
	}

}
