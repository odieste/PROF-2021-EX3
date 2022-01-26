/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.upm.grise.profundizacion.customer;

/**
 *
 * @author Bartomeu Ramis
 */
public class CustomerDataAccessSingletonDouble extends CustomerDataAccessSingleton{
    
    protected String shippingAdress  = "Example shipping addres";
    protected String invoicingAdress  = "Example invoicing adress";
    // Constructor
	protected CustomerDataAccessSingletonDouble() {
		super();
	}
       
        public String getShippingAddress(int id) throws CustomerException, DatabaseException {
            return shippingAdress;
		
	}
        
        // Get the invoicing address from DB
	public String getInvoicingAddress(int id) throws CustomerException, DatabaseException {	
		return invoicingAdress ;		
	}

    public void setShippingAdress(String shippingAdress) {
        this.shippingAdress = shippingAdress;
    }

    public void setInvoicingAdress(String invoicingAdress) {
        this.invoicingAdress = invoicingAdress;
    }
        
        
}
