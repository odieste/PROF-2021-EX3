package es.upm.grise.profundizacion.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.*;

public class smokeTest {

	@Test
	public void test() throws CustomerException, DatabaseException {
		int CUSTOMERID = 1;
		
		CustomerDataAccessSigletonInterface cdsi = new CustomerDataAccessSigletonImp();
		
		Customer customer = new Customer(CUSTOMERID,cdsi);
		
	}
	
	@Test
	public void test_checkAddress_equals() 
			throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
		CustomerDataAccessSigletonInterface cdsi = new CustomerDataAccessSigletonImp();
		Customer customer = new Customer(0,cdsi);
		assertEquals(true, customer.checkAddresses());
	}
	
	@Test
	public void test_checkAddress_noequals() 
			throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
		CustomerDataAccessSigletonInterface cdsi = new CustomerDataAccessSigletonImp();
		Customer customer = new Customer(1,cdsi);
		assertEquals(false, customer.checkAddresses());
	}
}
