package es.upm.grise.profundizacion.customer;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
public class smokeTest {

	@Test
	public void testShippingAddressInvoicingAddressIguales() throws CustomerException, DatabaseException, NoAddressException,
			EmptyAddressException{
		Customer mockCustomer = new Customer();
		mockCustomer.id=1;
		mockCustomer.invoicingAddress="Cabo Gros";
		mockCustomer.shippingAddress="Cabo Gros";
		assertTrue(mockCustomer.checkAddresses());
	}

	@Test
	public void testShippingAddressInvoicingAddressDistintos() throws CustomerException, DatabaseException, NoAddressException,
			EmptyAddressException{
		Customer mockCustomer = mock(Customer.class);
		mockCustomer.id=1;
		//mockCustomer.invoicingAddress="Cabo Gros";
		CustomerDataAccessSingleton mock = mock(CustomerDataAccessSingleton.class);
		Mockito.when(mock.getInvoicingAddress(1)).thenReturn("Cabo Gros");
		Mockito.when(mock.getShippingAddress(1)).thenReturn("Cabo Moro");
		mockCustomer.invoicingAddress=mock.getInvoicingAddress(mockCustomer.id);
		mockCustomer.shippingAddress=mock.getShippingAddress(mockCustomer.id);
		assertFalse(mockCustomer.checkAddresses());

	}

	@Test
	public void testShippingAddressInvoicingAddressPrimeraLetraDistinta() throws CustomerException, DatabaseException, NoAddressException,
			EmptyAddressException{
		Customer mockCustomer = mock(Customer.class);;
		mockCustomer.id=1;
		mockCustomer.invoicingAddress="cabo Gros";
		mockCustomer.shippingAddress="Cabo Gros";
		assertFalse(mockCustomer.checkAddresses());

	}

}
