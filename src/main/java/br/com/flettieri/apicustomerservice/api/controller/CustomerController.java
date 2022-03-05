package br.com.flettieri.apicustomerservice.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.flettieri.apicustomerservice.api.model.Customer;
import br.com.flettieri.apicustomerservice.api.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/save")
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) throws Exception {
		return ResponseEntity.ok().body(customerService.save(customer));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long id) throws Exception {
		return ResponseEntity.ok().body(customerService.update(customer, id));
	}
	
	@GetMapping("/find-all")
	public ResponseEntity<List<Customer>> getAll() {
		return ResponseEntity.ok().body(customerService.findAll());
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok().body(customerService.findCustomer(id));
	}
	
	@PutMapping("/disable/{id}")
	public ResponseEntity<Customer> disableCustomer(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok().body(customerService.disableCustomer(id));
	}
	
	@PutMapping("/enable/{id}")
	public ResponseEntity<Customer> enableCustomer(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok().body(customerService.enableCustomer(id));
	}
}