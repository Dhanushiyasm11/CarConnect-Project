
/*@author - Akshaya*/
package com.hexaware.cc.service;

import com.hexaware.cc.dao.CustomerDao; 
import com.hexaware.cc.dao.AdminDao;
import com.hexaware.cc.entity.Customer;
import com.hexaware.cc.entity.Admin;

public class AuthenticationService {

    private CustomerDao customerDao = new CustomerDao();
    private AdminDao adminDao = new AdminDao();

   
    public Customer authenticateCustomer(String username, String password) {
        Customer customer = customerDao.getCustomerByUsername(username);
        
        if (customer != null && customer.getPassword().equals(password)) {
           
            return customer;
        } else {
            
            return null;
        }
    }

  
    public Admin authenticateAdmin(String username, String password) {
        Admin admin = adminDao.getAdminByUsername(username);
        
        if (admin != null && admin.getPassword().equals(password)) {
           
            return admin;
        } else {
            
            return null;
        }
    }

	public boolean checkPassword(String password, String password2) {
		// TODO Auto-generated method stub
		return false;
	}
}
