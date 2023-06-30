package com.rest.service;

import java.util.List;

import com.rest.entity.Customer;

public interface CustomerService {
	public Customer addCustomer(Customer customer);
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(int customerId);
	public List<Customer> DeleteCustomerById(int customerId);
	public Customer updateCustomer(Customer customer);
}
