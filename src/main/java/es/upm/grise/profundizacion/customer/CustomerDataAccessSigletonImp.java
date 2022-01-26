package es.upm.grise.profundizacion.customer;

public class CustomerDataAccessSigletonImp implements CustomerDataAccessSigletonInterface {

	@Override
	public String getShippingAddress(int id) throws CustomerException, DatabaseException {
		return "Ship";
	}

	@Override
	public String getInvoicingAddress(int id) throws CustomerException, DatabaseException {
		return "address";
	}

}
