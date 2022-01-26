package es.upm.grise.profundizacion.customer;

public class DummyDataAccess implements CustomerDataAccess {

	@Override
	public String getShippingAddress(int id) throws CustomerException, DatabaseException {
		return "Pepe";
	}

	@Override
	public String getInvoicingAddress(int id) throws CustomerException, DatabaseException {
		return "Pepe";
	}

}
