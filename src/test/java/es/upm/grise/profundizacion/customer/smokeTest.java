package es.upm.grise.profundizacion.customer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;
import org.junit.Before;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class smokeTest {
    //Cuando index es menor que stringLenght y shippingAndress y invoicingAdress son iguales --> true
    //Cunado index es menor questringLenght y shippingAdress y invoicingAdress son diferentes --> false
    //Cuando index es igual que stringLenght (0 y 0) y shippingAdress y invoicingAdress son iguales --> true
    //Cuando index es igual que stringLenght (0 y 0) y shippingAdress y invoicingAdress son diferentes --> true 

    private static Customer customer;
    private final int CUSTOMERID = 1;
    CustomerDataAccessSingletonDouble cdas; 
    CustomerDataAccessSingleton cdasMock; 

    public smokeTest() throws CustomerException, DatabaseException {
        cdas = new CustomerDataAccessSingletonDouble();
        cdasMock = mock(CustomerDataAccessSingleton.class);
        customer = new Customer(CUSTOMERID, cdas);
    }

    @Test
    public void testUsingMockitoSameAdress() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
        when(cdasMock.getShippingAddress(1)).thenReturn("Adress1");
        when(cdasMock.getInvoicingAddress(1)).thenReturn("Adress1");
        customer = new Customer(CUSTOMERID, cdasMock);
        assertTrue("Shipping and invoicing adress are the same", customer.checkAddresses());
    }
    
    @Test
    public void testUsingMockitoDifferentAdress() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
        when(cdasMock.getShippingAddress(1)).thenReturn("Adress1");
        when(cdasMock.getInvoicingAddress(1)).thenReturn("Adress2");
        customer = new Customer(CUSTOMERID, cdasMock);
        assertFalse("Shipping and invoicing adress are different", customer.checkAddresses());
    }
    
    @Test
    public void testUsingMockitoNullShippingAdress() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
        when(cdasMock.getShippingAddress(1)).thenReturn(null);
        when(cdasMock.getInvoicingAddress(1)).thenReturn("Adress2");
        customer = new Customer(CUSTOMERID, cdasMock);
        assertThrows("Shipping or invoicing adress are null",NoAddressException.class, () ->customer.checkAddresses());
    }
    
    @Test
    public void testUsingMockitoNullInvoicingAdress() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
        when(cdasMock.getShippingAddress(1)).thenReturn(null);
        when(cdasMock.getInvoicingAddress(1)).thenReturn("Adress2");
        customer = new Customer(CUSTOMERID, cdasMock);
        assertThrows("Shipping or invoicing adress are null",NoAddressException.class, () ->customer.checkAddresses());
    }
    
    @Test
    public void testUsingMockitoEmptyShippingAdress() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
        when(cdasMock.getShippingAddress(1)).thenReturn("");
        when(cdasMock.getInvoicingAddress(1)).thenReturn("Adress2");
        customer = new Customer(CUSTOMERID, cdasMock);
        assertThrows("Shipping or invoicing adress have lenght 0",EmptyAddressException.class, () ->customer.checkAddresses());
    }
    
    @Test
    public void testUsingMockitoEmptyInvoicingAdress() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
        when(cdasMock.getShippingAddress(1)).thenReturn("Adress1");
        when(cdasMock.getInvoicingAddress(1)).thenReturn("");
        customer = new Customer(CUSTOMERID, cdasMock);
        assertThrows("Shipping or invoicing adress have lenght 0",EmptyAddressException.class, () ->customer.checkAddresses());
    }

    @Test
    public void testUsingMockitoLenghtDifference() throws CustomerException, DatabaseException, NoAddressException, EmptyAddressException {
        when(cdasMock.getShippingAddress(1)).thenReturn("Adress1");
        when(cdasMock.getInvoicingAddress(1)).thenReturn("Adress111111");
        customer = new Customer(CUSTOMERID, cdasMock);
        assertFalse("Shipping and invoicing adress are different lenght", customer.checkAddresses());
    }
}
