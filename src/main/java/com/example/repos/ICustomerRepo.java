package com.example.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.models.Customer;


public interface ICustomerRepo extends CrudRepository<Customer, Integer> {

	boolean existsByNameAndSurname(String name, String surname);

	boolean existsByPassword(String password);
	
	boolean existsByNameAndSurnameAndPassword(String name, String surname, String password);

	Customer findByNameAndSurname(String name, String surname);

}
