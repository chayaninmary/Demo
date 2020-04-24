package com.example.demo;

/*
Name: Chayanin Petchdasda
Date: April 24, 2020  
Purpose: A controller class provides mapping for five requests 
includes both get all customers and get customer by id, insert, update, delete customers. 
*/

import java.util.List;

/*
Name: Chayanin Petchdasda
Date: April 24, 2020  

*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Simplify the creation of RESTful webservice
@RequestMapping("/api/v1") //Mapping an http request 
public class CustomerController {
	
	
	@Autowired
    private CustomerService customerService;
	
	@PostMapping(path = "/customers")
	//ResponseEntity is generic type can be use any type as the response
	//ResponseEntity also represent the HTTP respinse
    public ResponseEntity<CustomerData> createCustomer(@RequestBody CustomerData cust) {
		//System.out.println("TESTTTTTTTT" + cust.getId());
		//create new customers record
        return new ResponseEntity<>(customerService.createCustomer(cust), HttpStatus.CREATED);
    }
	 
	    @PutMapping (path = "/customers")
	    public ResponseEntity<CustomerData> updateCustomer(@RequestBody CustomerData cust) {
	    	//update existing customer record
	        return new ResponseEntity<>(customerService.updateCustomer(cust), HttpStatus.CREATED);
	    }
	 
	    @DeleteMapping(path = "/customers/{custId}")
	    public ResponseEntity<String> deleteCustomer(@PathVariable(value="custId") Long custId) {
	    	customerService.deleteCustomer(custId);
	    	//delete by a specific customer 
	        return new ResponseEntity<>("Customer with CustomerId : " + custId + " deleted successfully", HttpStatus.OK);
	    }
	 
	    @GetMapping(path = "/customers/{custId}") //getting customer details by customer id pass from url
	    public ResponseEntity<CustomerData> getCustomer(@PathVariable(value = "custId") Long custId) {
	        return new ResponseEntity<>(customerService.getCustomer(custId), HttpStatus.OK);
	    }
	 
	    @GetMapping(path = "/customers")
	    public ResponseEntity<List<CustomerData>> getAllCustomer() {
	    	//getting all customers  
	        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
	    }

}
