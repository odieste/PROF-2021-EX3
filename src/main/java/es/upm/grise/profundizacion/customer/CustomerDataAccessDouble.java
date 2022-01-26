package es.upm.grise.profundizacion.customer;

public class CustomerDataAccessDouble extends CustomerDataAccessSingleton{

    protected CustomerDataAccessDouble() {
        super();
    }

    public String getShippingAddress(int id) throws CustomerException, DatabaseException {
        return "ShippingAddress";
    }

    public String getInvoicingAddress(int id) throws CustomerException, DatabaseException {
        return "InvoicingAddress";
    }

}
