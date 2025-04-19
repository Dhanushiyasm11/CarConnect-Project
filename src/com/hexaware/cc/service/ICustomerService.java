//@Author - Dhanushiya SM

package com.hexaware.cc.service;

import com.hexaware.cc.entity.Customer;
import java.util.List;

public interface ICustomerService {
    Customer getCustomerById(int customerId);
    Customer getCustomerByUsername(String username);
    void registerCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int customerId);
    List<Customer> getAllCustomers();
}
