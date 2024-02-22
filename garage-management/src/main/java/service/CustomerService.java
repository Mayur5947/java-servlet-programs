package service;

import java.util.List;

import model.Customer;
import repository.customerRepository;

public class CustomerService {

	customerRepository customerRepository = new customerRepository();

	public void addCutomer(Customer customer) throws Exception {
		customerRepository.addCutomer(customer);
	}

	public Customer getCustomer(long customer_phone) throws Exception {
		return customerRepository.getCustomer(customer_phone);
	}

	public List<Customer> getAllCustomers() throws Exception {
		return customerRepository.getAllCustomers();
	}
	
	public void updateCustomer(Customer customer) throws Exception {
		customerRepository.updateCustomer(customer);
	}
	
	
}
