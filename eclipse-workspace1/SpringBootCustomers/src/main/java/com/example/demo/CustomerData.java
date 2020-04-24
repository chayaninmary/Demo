package com.example.demo;

/*
Name: Chayanin Petchdasda
Date: April 24, 2020  
Purpose of this class is related to employees table in a database.
Also, use Lombok library to minimize code Getter, Setter, Constructor w/ param and w/o param.
Below are all columns that contains in database (id is a key and auto count, firstname, lastname and email)	 
*/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //Make it an entity class
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "customers") //Specify to which database table the class is mapped to
public class CustomerData {
	
	@Id //Id field is auto generated number
    @GeneratedValue(strategy = GenerationType.IDENTITY) //generated strategy type as Identity
	@Column(name="id")
    private long id; //id number is auto generate
	
	@Column(name = "customer_name", nullable = false) //database table name field
    private String name;// name of customer

	@Column(name = "customer_email", nullable = false) //database table email field
    private String email;//customer email

}
