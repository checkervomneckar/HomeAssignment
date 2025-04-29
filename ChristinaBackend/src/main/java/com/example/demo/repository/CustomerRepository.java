package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Customer;
//import java.util.List;

/**
 * Interface-Repository for Customer
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	//List<Customer> findByCustomerUsername(String unm);
}
