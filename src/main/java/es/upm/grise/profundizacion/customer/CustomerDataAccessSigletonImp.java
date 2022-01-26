package es.upm.grise.profundizacion.customer;

public class CustomerDataAccessSigletonImp implements CustomerDataAccessSigletonInterface {

	@Override
	public String getShippingAddress(int id) throws CustomerException, DatabaseException {
		if (id == 0)
			return "id0";
		else
			return "id1";
	}

	@Override
	public String getInvoicingAddress(int id) throws CustomerException, DatabaseException {
		return "id0";
	}

}
