package es.upm.grise.profundizacion.customer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class smokeTest {

	@InjectMocks
	Customer customer;

	@Mock
	private CustomerDataAccessSingleton customerDataAccessSingleton;

	private int CUSTOMERID = 1;


	@Test
	public void whenCheckAddressHasDifferentChars_thenReturnFalse() throws CustomerException, EmptyAddressException, NoAddressException {
		String invoicingAddress = "prueba";
		String  shippingAddress = "pruebo";
		Customer customer = new Customer(CUSTOMERID,shippingAddress,invoicingAddress);
		boolean resultado = customer.checkAddresses();
		assertEquals(false, resultado);
	}

	@Test
	public void whenCheckAddressHasDifferentChars_thenReturnTrue() throws CustomerException, EmptyAddressException, NoAddressException {
		String invoicingAddress = "prueba";
		String  shippingAddress = "prueba";
		Customer customer = new Customer(CUSTOMERID, shippingAddress,invoicingAddress);

		boolean resultado = customer.checkAddresses();
		assertEquals(true, resultado);
	}

}
