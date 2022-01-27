package es.upm.grise.profundizacion.customer;

public class CustomarDataAccess extends CustomarDataAccessSingleton {
    // Get the shipping address from DB
    @Override
    public String getShippingAddress(int id) throws CustomerException, DatabaseException{
        return "shippingAddress 12345";
    }

    // Get the invoicing address from DB
    @Override
    public String getInvoicingAddress(int id) throws CustomerException, DatabaseException{
        return "invoicingAddress 12345";
    }

}
