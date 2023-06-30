package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.entity.Customer;
import com.rest.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/customers/customer")
	public Customer addCustomer(@RequestBody Customer cust) {
		Customer c=customerService.addCustomer(cust);
		return c;
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		List<Customer> list=customerService.getAllCustomers();
		return list;
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomerById(@PathVariable("id") int customerId) {
		Customer cust=customerService.getCustomerById(customerId);
		if(cust==null) {
			throw new NullPointerException(""+customerId);
		}
		return cust;
	}
	
	@DeleteMapping("/customers/{id}") 
	public List<Customer> DeleteCustomerById(@PathVariable("id") int customerId){
		List<Customer> cust=customerService.DeleteCustomerById(customerId);
		return cust;
	}
	
	@PutMapping("/customers/customer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		Customer cust=customerService.updateCustomer(customer);
		return cust;
	}
	
}
