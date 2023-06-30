package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.entity.Customer;
import com.rest.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	@Override
	public Customer addCustomer(Customer customer) {
		Customer c=customerRepository.addCustomer(customer);
		return c;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> list=customerRepository.getAllCustomers();
		return list;
	}

	@Override
	public Customer getCustomerById(int customerId) {
		Customer cust=customerRepository.getCustomerById(customerId);
		return cust;
	}

	@Override
	public List<Customer> DeleteCustomerById(int customerId) {
		List<Customer> cust=customerRepository.DeleteCustomerById(customerId);
		return cust;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer cust=customerRepository.updateCustomer(customer);
		return cust;
	}

}
