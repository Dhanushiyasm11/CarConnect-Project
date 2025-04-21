//@Author - Dhanushiya SM

package com.hexaware.cc.service;

import com.hexaware.cc.dao.CustomerDao;
import com.hexaware.cc.entity.Customer;
import com.hexaware.cc.exception.InvalidInputException;  

import java.util.List;

public class CustomerService implements ICustomerService {
    private CustomerDao dao = new CustomerDao();

   
    public CustomerService(Object object) {
    
    }


    public CustomerService() {
       
    }

    @Override
    public Customer getCustomerById(int id) {
        if (id <= 0) {
            throw new InvalidInputException("Customer ID must be greater than 0.");
        }
        return dao.getCustomerById(id);
    }

    @Override
    public Customer getCustomerByUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new InvalidInputException("Username cannot be empty.");
        }
        return dao.getCustomerByUsername(username);
    }

    @Override
    public void registerCustomer(Customer c) {
        validateCustomer(c);
        dao.registerCustomer(c);
    }

    @Override
    public void updateCustomer(Customer c) {
        if (c.getCustomerId() <= 0) {
            throw new InvalidInputException("Invalid Customer ID.");
        }
        validateCustomer(c);
        dao.updateCustomer(c);
    }

    @Override
    public void deleteCustomer(int id) {
        if (id <= 0) {
            throw new InvalidInputException("Customer ID must be greater than 0.");
        }
        dao.deleteCustomer(id);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return dao.getAllCustomers();
    }

   
    private void validateCustomer(Customer c) {
        if (c.getFirstName() == null || c.getFirstName().trim().isEmpty()) {
            throw new InvalidInputException("First name is required.");
        }
        if (c.getLastName() == null || c.getLastName().trim().isEmpty()) {
            throw new InvalidInputException("Last name is required.");
        }
        if (c.getEmail() == null || !c.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
            throw new InvalidInputException("Invalid email format.");
        }
        if (c.getPhoneNumber() == null || !c.getPhoneNumber().matches("\\d{10}")) {
            throw new InvalidInputException("Phone number must be 10 digits.");
        }
        if (c.getUsername() == null || c.getUsername().trim().isEmpty()) {
            throw new InvalidInputException("Username is required.");
        }
        if (c.getPassword() == null || c.getPassword().length() < 6) {
            throw new InvalidInputException("Password must be at least 6 characters long.");
        }
    }

    @Override
    public Customer authenticate(String username, String password) {
      
        return null;
    }
}
