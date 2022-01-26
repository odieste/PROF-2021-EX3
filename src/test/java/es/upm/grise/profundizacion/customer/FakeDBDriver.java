package es.upm.grise.profundizacion.customer;

public class FakeDBDriver implements DBDriver {

	@Override
	public String getShippingAddress(int id)
			throws CustomerException, DatabaseException {
		// TODO Auto-generated method stub
		if (id == 1)
			return "patata";
		else
			return "carlos";
	}

	@Override
	public String getInvoicingAddress(int id)
			throws CustomerException, DatabaseException {
		// TODO Auto-generated method stub
		if (id == 1)
			return "patata";
		else
			return "miguel";
	}

}
