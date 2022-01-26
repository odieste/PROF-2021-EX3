package es.upm.grise.profundizacion.customer;

public class CustomerDataAccessSingletonDouble extends CustomerDataAccessSingleton{
    protected CustomerDataAccessSingletonDouble() {
        super();
    }

    public String getShippingAddress(int id) throws CustomerException, DatabaseException {
        return "Example shipping addres";

    }

    // Get the invoicing address from DB
    public String getInvoicingAddress(int id) throws CustomerException, DatabaseException {
        return "Example invoicing adress";
    }
}
