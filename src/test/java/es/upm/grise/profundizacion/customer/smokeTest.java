package es.upm.grise.profundizacion.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class smokeTest {

	DBDriver dbDriver = new FakeDBDriver();

	//	@Test
	//	public void test() throws CustomerException, DatabaseException {
	//		int CUSTOMERID = 1;
	//
	//		Customer customer = new Customer(CUSTOMERID, dbDriver);
	//	}

	/*
	 * shippingAddress = "patata"
	 * invoicingAddress = "patata"
	 */
	@Test
	public void testTrue_SameShippingAndInvoice() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
		assertEquals(true, new Customer(1, dbDriver).checkAddresses());
	}

	/*
	 * shippingAddress = "carlos"
	 * invoicingAddress = "miguel"
	 */
	@Test
	public void testFalse_DiffShippingAndInvoice() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
		assertEquals(false, new Customer(2, dbDriver).checkAddresses());
	}

}
