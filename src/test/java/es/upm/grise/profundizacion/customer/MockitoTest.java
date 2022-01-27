package es.upm.grise.profundizacion.customer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockitoTest {

    CustomarDataAccess customerDAS;

    // Test 1: shippingAddress = null,  invoicingAddress = null
    @Test
    public void test1() throws CustomerException, DatabaseException, EmptyAddressException, NoAddressException {
        int CUSTOMERID = 1;
        customerDAS = mock(CustomarDataAccess.class);
        when(customerDAS.getShippingAddress(CUSTOMERID)).thenReturn(null);
        when(customerDAS.getInvoicingAddress(CUSTOMERID)).thenReturn(null);
        Customer customer = new Customer(CUSTOMERID, customerDAS);
        assertThrows(NoAddressException.class, () -> customer.checkAddresses());
    }

    // Test 2: shippingAddress = null,  invoicingAddress = "cadena1"
    @Test
    public void test2() throws CustomerException, DatabaseException, EmptyAddressException, NoAddressException {
        int CUSTOMERID = 1;
        customerDAS = mock(CustomarDataAccess.class);
        when(customerDAS.getShippingAddress(CUSTOMERID)).thenReturn(null);
        when(customerDAS.getInvoicingAddress(CUSTOMERID)).thenReturn("cadena1");
        Customer customer = new Customer(CUSTOMERID, customerDAS);
        assertThrows(NoAddressException.class, () -> customer.checkAddresses());
    }

    // Test 3: shippingAddress = "cadena2",  invoicingAddress = null
    @Test
    public void test3() throws CustomerException, DatabaseException, EmptyAddressException, NoAddressException {
        int CUSTOMERID = 1;
        customerDAS = mock(CustomarDataAccess.class);
        when(customerDAS.getShippingAddress(CUSTOMERID)).thenReturn("cadena2");
        when(customerDAS.getInvoicingAddress(CUSTOMERID)).thenReturn(null);
        Customer customer = new Customer(CUSTOMERID, customerDAS);
        assertThrows(NoAddressException.class, () -> customer.checkAddresses());
    }

    // Test 4: shippingAddress = "",  invoicingAddress = "cadena3"
    @Test
    public void test4() throws CustomerException, DatabaseException, EmptyAddressException, NoAddressException {
        int CUSTOMERID = 1;
        customerDAS = mock(CustomarDataAccess.class);
        when(customerDAS.getShippingAddress(CUSTOMERID)).thenReturn("");
        when(customerDAS.getInvoicingAddress(CUSTOMERID)).thenReturn("cadena3");
        Customer customer = new Customer(CUSTOMERID, customerDAS);
        assertThrows(EmptyAddressException.class, () -> customer.checkAddresses());
    }

    // Test 5: shippingAddress = "una_cadena",  invoicingAddress = "otra"
    @Test
    public void test5() throws CustomerException, DatabaseException, EmptyAddressException, NoAddressException {
        int CUSTOMERID = 1;
        customerDAS = mock(CustomarDataAccess.class);
        when(customerDAS.getShippingAddress(CUSTOMERID)).thenReturn("una_cadena");
        when(customerDAS.getInvoicingAddress(CUSTOMERID)).thenReturn("otra");
        Customer customer = new Customer(CUSTOMERID, customerDAS);
        assertEquals(false, customer.checkAddresses());
    }

    // Test 6: shippingAddress = "misma_long",  invoicingAddress = "MISMA-LONG"
    @Test
    public void test6() throws CustomerException, DatabaseException, EmptyAddressException, NoAddressException {
        int CUSTOMERID = 1;
        customerDAS = mock(CustomarDataAccess.class);
        when(customerDAS.getShippingAddress(CUSTOMERID)).thenReturn("misma_long");
        when(customerDAS.getInvoicingAddress(CUSTOMERID)).thenReturn("MISMA-LONG");
        Customer customer = new Customer(CUSTOMERID, customerDAS);
        assertEquals(false, customer.checkAddresses());
    }

    // Test 7: shippingAddress = "igual_cadena",  invoicingAddress = "igual_cadena"
    @Test
    public void test7() throws CustomerException, DatabaseException, EmptyAddressException, NoAddressException {
        int CUSTOMERID = 1;
        customerDAS = mock(CustomarDataAccess.class);
        when(customerDAS.getShippingAddress(CUSTOMERID)).thenReturn("igual_cadena");
        when(customerDAS.getInvoicingAddress(CUSTOMERID)).thenReturn("igual_cadena");
        Customer customer = new Customer(CUSTOMERID, customerDAS);
        assertEquals(true, customer.checkAddresses());
    }

}
