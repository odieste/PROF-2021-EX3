package es.upm.grise.profundizacion.customer;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class smokeTest {

	DBDriver dbDriver = new FakeDBDriver();

	@Test
	public void test() throws SQLException, CustomerException, DatabaseException {
		int CUSTOMERID = 1;

		Customer customer = new Customer(CUSTOMERID, dbDriver);
	}

}
