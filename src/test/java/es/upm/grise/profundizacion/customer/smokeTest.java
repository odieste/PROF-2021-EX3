package es.upm.grise.profundizacion.customer;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

public class smokeTest {

	Customer customer;

	@BeforeEach
	public void initSingleton()  {
		customer = new Customer(1);
	}


	@Test
	public void testDosNombresIguales() throws CustomerException, DatabaseException {
		int CUSTOMERID = 1;

		customer = new Customer(1);
		customer.customerInit_Test("Nombre", "Nombre");

		try {
			assertTrue(customer.checkAddresses());
		}catch (EmptyAddressException | NoAddressException ignored){

		}
	}

	@Test
	public void testDosNombresDistintos() throws CustomerException, DatabaseException {
		int CUSTOMERID = 1;

		customer = new Customer(1);
		Customer customer = new Customer(CUSTOMERID);
		customer.customerInit_Test("Nombre", "NombrX");

		try {
			assertFalse(customer.checkAddresses());
		}catch (EmptyAddressException | NoAddressException ignored){

		}
	}

}
