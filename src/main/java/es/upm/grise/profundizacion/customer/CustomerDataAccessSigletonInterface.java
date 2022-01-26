package es.upm.grise.profundizacion.customer;

public interface CustomerDataAccessSigletonInterface {

	// Get the shipping address from DB
	String getShippingAddress(int id) throws CustomerException, DatabaseException;

	//
	// Get the invoicing address from DB
	String getInvoicingAddress(int id) throws CustomerException, DatabaseException;

}