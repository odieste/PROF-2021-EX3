package es.upm.grise.profundizacion.customer;

public interface DBDriver {

	String getShippingAddress(int id) throws CustomerException, DatabaseException;
	String getInvoicingAddress(int id) throws CustomerException, DatabaseException;
}
