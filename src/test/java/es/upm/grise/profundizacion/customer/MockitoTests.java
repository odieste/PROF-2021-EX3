package es.upm.grise.profundizacion.customer;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MockitoTests {

    private static final int CUSTOMERID = 1;

    @BeforeAll
    static public void beforeAll(){
        System.out.println("Starting Ex8 Mockito tests");
    }

    @BeforeEach
    public void init(TestInfo testInfo){
        // Using Customer id == 1
//        customerDataAccessSingletonDouble = new CustomerDataAccessSingletonDouble(1);
        System.out.println("Start... " + testInfo.getDisplayName());
    }

    @DisplayName("Test1: shippingAddress == null")
    @Test
    public void shippingAddressNull() throws CustomerException, DatabaseException {
        CustomerDataAccessSingleton customerDataAccessSingleton = Mockito.mock(CustomerDataAccessSingleton.class);
        when(customerDataAccessSingleton.getShippingAddress(1)).thenReturn(null);
        when(customerDataAccessSingleton.getInvoicingAddress(1)).thenReturn(null);
        Customer customer = new Customer(CUSTOMERID, customerDataAccessSingleton);
        assertThrows(NoAddressException.class, () -> customer.checkAddresses());
    }

    @DisplayName("Test2: shippingAddress == empty ")
    @Test
    public void shippingAddressEmpty() throws CustomerException, DatabaseException {
        CustomerDataAccessSingleton customerDataAccessSingleton = Mockito.mock(CustomerDataAccessSingleton.class);
        when(customerDataAccessSingleton.getShippingAddress(1)).thenReturn("");
        when(customerDataAccessSingleton.getInvoicingAddress(1)).thenReturn("MyAddress 1234");
        Customer customer = new Customer(CUSTOMERID, customerDataAccessSingleton);
        assertThrows(EmptyAddressException.class, () -> customer.checkAddresses());
    }

    @DisplayName("Test3: Shipping/Invoice Lengths are not equal")
    @Test
    public void checkAddressAndShippingDifferentLengths() throws CustomerException, DatabaseException, EmptyAddressException, NoAddressException {
        CustomerDataAccessSingleton customerDataAccessSingleton = Mockito.mock(CustomerDataAccessSingleton.class);
        when(customerDataAccessSingleton.getShippingAddress(1)).thenReturn("MyAddress 12");
        when(customerDataAccessSingleton.getInvoicingAddress(1)).thenReturn("MyAddress 1234");
        Customer customer = new Customer(CUSTOMERID, customerDataAccessSingleton);
        assertEquals(false, customer.checkAddresses());
    }

    @DisplayName("Test4: Shipping/Invoice are equal ")
    @Test
    public void checkAddressAndShippingSameAddress() throws CustomerException, DatabaseException, EmptyAddressException, NoAddressException {
        CustomerDataAccessSingleton customerDataAccessSingleton = Mockito.mock(CustomerDataAccessSingleton.class);
        when(customerDataAccessSingleton.getShippingAddress(1)).thenReturn("MyAddress 1234");
        when(customerDataAccessSingleton.getInvoicingAddress(1)).thenReturn("MyAddress 1234");
        Customer customer = new Customer(CUSTOMERID, customerDataAccessSingleton);
        assertEquals(true, customer.checkAddresses());
    }

    // ------------------------------------------------------------------------------
    // Acabo de revisar el examen y he visto que en el ultimo apartado de la pregunta 4 he puesto test1 y test11
    // Deberia ser test1 y test2, se me ha colado....
    // ------------------------------------------------------------------------------
    @DisplayName("Test5: Shipping/Invoice are different ")
    @Test
    public void checkAddressAndShippingDifferentAddress() throws CustomerException, DatabaseException, EmptyAddressException, NoAddressException {
        CustomerDataAccessSingleton customerDataAccessSingleton = Mockito.mock(CustomerDataAccessSingleton.class);
        when(customerDataAccessSingleton.getShippingAddress(1)).thenReturn("MyAddress 1234");
        when(customerDataAccessSingleton.getInvoicingAddress(1)).thenReturn("random street1");
        Customer customer = new Customer(CUSTOMERID, customerDataAccessSingleton);
        assertEquals(false, customer.checkAddresses());
    }



    @AfterEach
    public void tearDown(TestInfo testInfo) {
        System.out.println("Finished... " + testInfo.getDisplayName());
    }

    @AfterAll
    static public void closeSubscriptionServiceTest(){
        System.out.println("Finished Mockito tests");
    }
}
