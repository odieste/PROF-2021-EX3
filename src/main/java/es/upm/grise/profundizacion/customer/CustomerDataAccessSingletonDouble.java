package es.upm.grise.profundizacion.customer;

public class CustomerDataAccessSingletonDouble extends CustomerDataAccessSingleton{

    protected CustomerDataAccessSingletonDouble(){
        super();
    }

    public String getShippingAddress (int id) throws CustomerException, DatabaseException{
        return "Shipping address";
    }

    public String getInvoicingAddress(int id) throws  CustomerException, DatabaseException{
        return "Invoicing address";
    }

}
