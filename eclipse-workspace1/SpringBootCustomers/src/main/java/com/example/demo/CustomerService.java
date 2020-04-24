package com.example.demo;

/*
Name: Chayanin Petchdasda
Date: April 24, 2020  
Purpose of this interface is business logic inside service layer, 
which gives a layer of separation from controller and database related operations.
all methods below are  defined for create, update, get customer by Id, 
delete and get all available customer from database. 
*/

import java.util.List;

public interface CustomerService {


    public CustomerData createCustomer(CustomerData cust);
    public CustomerData updateCustomer(CustomerData cust);
    public CustomerData getCustomer(Long custId);
    public void deleteCustomer(Long custId);
    public List<CustomerData> getAllCustomer();
	
}
