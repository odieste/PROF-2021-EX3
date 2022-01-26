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
    
    // Constructor
	protected CustomerDataAccessSingletonDouble() {
		super();
	}
       
        public String getShippingAddress(int id) throws CustomerException, DatabaseException {
            return "Example shipping addres";
		
	}
        
        // Get the invoicing address from DB
	public String getInvoicingAddress(int id) throws CustomerException, DatabaseException {	
		return "Example invoicing adress";		
	}
}
