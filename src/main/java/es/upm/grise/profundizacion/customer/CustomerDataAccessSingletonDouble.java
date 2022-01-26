package es.upm.grise.profundizacion.customer;

// Remove final
public class CustomerDataAccessSingletonDouble extends CustomerDataAccessSingleton{


    protected CustomerDataAccessSingletonDouble() {
    }

    @Override
    public String getShippingAddress(int id) throws CustomerException, DatabaseException {
        return "Shipping Address 1234";

    }

    @Override
    public String getInvoicingAddress(int id) throws CustomerException, DatabaseException {
        return "Address 1234";
    }


}
