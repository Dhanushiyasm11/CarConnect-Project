//@Author - Dhanushiya SM

package com.hexaware.cc.service;

import com.hexaware.cc.entity.Customer;
import com.hexaware.cc.exception.InvalidInputException;
import com.hexaware.cc.exception.AuthenticationException;
import java.util.List;

public interface ICustomerService {
    Customer getCustomerById(int id) 
    		
    		throws InvalidInputException;
    
    Customer getCustomerByUsername(String username)
    		throws InvalidInputException;
    
    void registerCustomer(Customer c)
    		throws InvalidInputException;
   
    void updateCustomer(Customer c)
    		throws InvalidInputException;
   
    void deleteCustomer(int id) 
    		throws InvalidInputException;
    List<Customer> getAllCustomers();
    
    
    Customer authenticate(String username, String password)
        throws InvalidInputException, AuthenticationException;
}
