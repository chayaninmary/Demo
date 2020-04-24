package com.example.demo;

/*
Name: Chayanin Petchdasda
Date: April 24, 2020  
Purpose of this class is create an implementation for CustomerSerice interface 
*/

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Register this class as Spring service bean
public class CustomerServiceImpl implements CustomerService {

	@Autowired//perform database related operations
    private CustomerRepository customerRepository;
	
	@Override
	public CustomerData createCustomer(CustomerData cust) {
		System.out.println("SERVICESSSSS!!!!!" + cust.getId());
		return customerRepository.save(cust);
	}

	@Override
	public CustomerData updateCustomer(CustomerData cust) {

		return customerRepository.save(cust);
	}

	@Override
	public CustomerData getCustomer(Long custId) {
		
		Optional<CustomerData> optionalCust =  customerRepository.findById(custId);
        if(optionalCust.isPresent()) {
            return optionalCust.get();
        }
		return null;
		
	}

	@Override
	public void deleteCustomer(Long custId) {
		
		customerRepository.deleteById(custId);
		
	}

	@Override
	public List<CustomerData> getAllCustomer() {

		return customerRepository.findAll();
	}

}
