package br.com.flettieri.apicustomerservice.api.validations;

import org.springframework.stereotype.Service;

import br.com.flettieri.apicustomerservice.api.model.Customer;

@Service
public class CustomerValidator {

	public void validateToSave(Customer customer) throws Exception {
		if (customer.getName() == null || customer.getName().isEmpty()) {
			throw new Exception("The customer must contain name.");
		}
		
		if (customer.getDocument() == null || customer.getDocument().isEmpty()) {
			throw new Exception("The customer must contain document.");
		}
		
		if (customer.getDocumentType() == null) {
			throw new Exception("The customer must contain documentType.");
		}
	}
	
	public void validateToUpdate(Customer customerUpdate, Customer customer) throws Exception {
		if (customerUpdate.getDocument() == customer.getDocument() && 
				customerUpdate.getDocumentType() == customer.getDocumentType() &&
				customerUpdate.getName() == customer.getName()) {
			throw new Exception("The customer don't was fields to updated.");
		}
	}
	
	public void validateToDisable(Customer customer) throws Exception {
		if (customer.getEnabled() == false) {
			throw new Exception("Customer isn't enable.");
		}
	}
	
	public void validateToEnable(Customer customer) throws Exception {
		if (customer.getEnabled() == true) {
			throw new Exception("Customer isn't disable.");
		}
	}
}











