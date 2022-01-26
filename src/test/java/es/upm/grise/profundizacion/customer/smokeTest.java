package es.upm.grise.profundizacion.customer;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

public class smokeTest {

	Customer customer;
	CustomerDataAccessSingletonDouble customerMock;
	@Test
	public void test() throws CustomerException, DatabaseException {
		int CUSTOMERID = 1;
		
		Customer customer = new Customer(CUSTOMERID,customerMock);
	}

	@Test()
	public void testNullShippingAddress() throws DatabaseException, CustomerException {
		customerMock = mock(CustomerDataAccessSingletonDouble.class);
		customer = new Customer(1,customerMock);
		when(customerMock.getShippingAddress(1)).thenReturn(null);
		when(customerMock.getInvoicingAddress(1)).thenReturn(null);
		assertThrows(NoAddressException.class,()->customer.checkAddresses());
	}

	@Test()
	public void testNullInvoicingAddress() throws DatabaseException, CustomerException {
		customerMock = mock(CustomerDataAccessSingletonDouble.class);
		customer = new Customer(1,customerMock);
		when(customerMock.getShippingAddress(1)).thenReturn("hola");
		when(customerMock.getInvoicingAddress(1)).thenReturn(null);
		assertThrows(NoAddressException.class,()->customer.checkAddresses());
	}
}
