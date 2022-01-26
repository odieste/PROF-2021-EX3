package es.upm.grise.profundizacion.customer;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestCasosDefinidos {

    @Test
    public void firstCaseTest() throws EmptyAddressException, NoAddressException {
        Customer c = mock(Customer.class);
        c.shippingAddress = "Avenida1";
        c.invoicingAddress = "Avenida1";
        when (c.checkAddresses()).thenReturn(true);
        assertEquals(true, c.checkAddresses());
    }

    @Test
    public void secondCaseTest() throws EmptyAddressException, NoAddressException {
        Customer c = mock(Customer.class);
        c.shippingAddress = "1";
        c.invoicingAddress = "1";
        assertEquals(false, c.checkAddresses());
    }

    @Test
    public void thirdCaseTest() throws EmptyAddressException, NoAddressException {
        Customer c = mock(Customer.class);
        c.shippingAddress = "";
        c.invoicingAddress = "";
        assertEquals(false, c.checkAddresses());
    }

    @Test
    public void forthCaseTest() throws EmptyAddressException, NoAddressException {
        Customer c = mock(Customer.class);
        c.shippingAddress = "Avenida1";
        c.invoicingAddress = "Avenida2";
        assertEquals(false, c.checkAddresses());
    }

    @Test
    public void fifthCaseTest() throws EmptyAddressException, NoAddressException {
        Customer c = mock(Customer.class);
        assertEquals(false, c.checkAddresses());
    }

}
