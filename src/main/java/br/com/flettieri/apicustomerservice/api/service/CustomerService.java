package br.com.flettieri.apicustomerservice.api.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.flettieri.apicustomerservice.api.model.Customer;
import br.com.flettieri.apicustomerservice.api.repository.CustomerRepository;
import br.com.flettieri.apicustomerservice.api.validations.CustomerValidator;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private CustomerValidator validator;
	
	public Customer save(Customer customerSave) throws Exception {
		validator.validateToSave(customerSave);
		
		customerSave.setUuid(UUID.randomUUID().toString());
		customerSave.setCreatedDate(LocalDateTime.now());
		customerSave.setEnabled(true);
		
		return repository.save(customerSave);
	}
	
	public Customer update(Customer customerUpdate, Long id) throws Exception {
		Customer customer = findById(id);

		validator.validateToUpdate(customerUpdate, customer);

		if (customerUpdate.getDocument() != null || customerUpdate.getDocumentType() != null) {
			customer.setDocument(customerUpdate.getDocument());
			customer.setDocumentType(customerUpdate.getDocumentType());
		}

		if (customerUpdate.getName() != null) {
			customer.setName(customerUpdate.getName());
		}
		
		customer.setUpdatedDate(LocalDateTime.now());
		
		return repository.save(customer);
	}

	private Customer findById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("Customer does not exist"));
	}

	public List<Customer> findAll() {
		return repository.findAll();
	}

	public Customer disableCustomer(Long id) throws Exception {
		Customer customer = findById(id);
		
		validator.validateToDisable(customer);

		customer.setEnabled(false);
		customer.setDisabledDate(LocalDateTime.now());
		customer.setUpdatedDate(LocalDateTime.now());
		
		return repository.save(customer);
	}
	
	public Customer enableCustomer(Long id) throws Exception {
		Customer customer = findById(id);
		
		validator.validateToEnable(customer);
		
		customer.setEnabled(true);
		customer.setDisabledDate(null);
		customer.setUpdatedDate(LocalDateTime.now());
		
		return repository.save(customer);
	}
	
	public Customer findCustomer(Long id) throws Exception {
		return findById(id);
	}
	
}
