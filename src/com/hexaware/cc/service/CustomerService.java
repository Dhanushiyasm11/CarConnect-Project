package com.hexaware.cc.service;

import com.hexaware.cc.dao.CustomerDao;
import com.hexaware.cc.entity.Customer;
import java.util.List;

public class CustomerService implements ICustomerService {
    private CustomerDao dao = new CustomerDao();

    public CustomerService(Object object) {
		// TODO Auto-generated constructor stub
	}

	public CustomerService() {
		// TODO Auto-generated constructor stub
	}

	public Customer getCustomerById(int id) {
        return dao.getCustomerById(id);
    }

    public Customer getCustomerByUsername(String username) {
        return dao.getCustomerByUsername(username);
    }

    public void registerCustomer(Customer c) {
        dao.registerCustomer(c);
    }

    public void updateCustomer(Customer c) {
        dao.updateCustomer(c);
    }

    public void deleteCustomer(int id) {
        dao.deleteCustomer(id);
    }

    public List<Customer> getAllCustomers() {
        return dao.getAllCustomers();
    }

	public Customer authenticate(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
}
