package br.com.flettieri.apicustomerservice.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.flettieri.apicustomerservice.api.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
