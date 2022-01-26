package es.upm.grise.profundizacion.customer;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class mocktests {

	@Mock
	CustomerDataAccessSingleton customerDataAccessSingleton;
	
	@Test
	public void test2() throws  NoAddressException, EmptyAddressException {
		Customer customer = new Customer(1, "casamia", "casamia");
	    when (customer.checkAddresses()).thenReturn(true);
        assertEquals(customer.checkAddresses(), true);
	}
	
	@Test
	public void test3() throws  NoAddressException, EmptyAddressException {
		Customer customer = new Customer(1, "casatuya", "casamia");
	    when (customer.checkAddresses()).thenReturn(false);
        assertEquals(customer.checkAddresses(), false);
	}

    @Test
    public void test4() throws EmptyAddressException, NoAddressException {
		Customer customer = new Customer(1, "", "");
        assertEquals(customer.checkAddresses(), false);
    }
	
}
