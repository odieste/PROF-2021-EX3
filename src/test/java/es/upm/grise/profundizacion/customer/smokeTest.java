package es.upm.grise.profundizacion.customer;

import org.junit.jupiter.api.Test;
import org.junit.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.*;

//@ExtendWith(MockitoExtension.class)
public class smokeTest {


	@Test
	public void test() throws CustomerException, DatabaseException, EmptyAddressException, NoAddressException {
		int CUSTOMERID = 1;
		CustomerDataAccessSingleton customDouble = new CustomerDataAccessSingletonDouble();
		Customer customer = new Customer(CUSTOMERID, customDouble);

	}

}
