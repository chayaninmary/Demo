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
		return customerRepository.save(cust); //repository class return save method to add new entry into database 
	}

	@Override
	public CustomerData updateCustomer(CustomerData cust) {

		return customerRepository.save(cust); //repository class return save method to update existing ones into database 
	}

	@Override
	public CustomerData getCustomer(Long custId) { //this method used to read customer data by customer id
	 
		Optional<CustomerData> optionalCust =  customerRepository.findById(custId);
		//Optional object use for check if a customer id is existing or not
        if(optionalCust.isPresent()) {
            return optionalCust.get(); //if customer id is exist then return a value
        }
		return null;
		
	}

	@Override
	public void deleteCustomer(Long custId) {
		//delete by customer id
		customerRepository.deleteById(custId);
		
	}

	@Override
	public List<CustomerData> getAllCustomer() {
		//return all lists of customer details from database
		return customerRepository.findAll();
	}

}
