/*@author - Akshaya*/
package com.hexaware.cc.service;

import com.hexaware.cc.dao.AdminDao;
import com.hexaware.cc.entity.Admin;
import com.hexaware.cc.exception.InvalidInputException;

import java.util.List;

public class AdminService implements IAdminService {
    private AdminDao dao = new AdminDao();

    @Override
    public Admin getAdminById(int id) {
        if (id <= 0) {
            throw new InvalidInputException("Admin ID must be positive.");
        }
        return dao.getAdminById(id);
    }

    @Override
    public Admin getAdminByUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new InvalidInputException("Username cannot be empty.");
        }
        return dao.getAdminByUsername(username);
    }

    @Override
    public void registerAdmin(Admin a) {
        validateAdmin(a);
        dao.registerAdmin(a);
    }

    @Override
    public void updateAdmin(Admin a) {
        if (a.getAdminId() <= 0) {
            throw new InvalidInputException("Invalid Admin ID.");
        }
        validateAdmin(a);
        dao.updateAdmin(a);
    }

    @Override
    public void deleteAdmin(int id) {
        if (id <= 0) {
            throw new InvalidInputException("Admin ID must be positive.");
        }
        dao.deleteAdmin(id);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return dao.getAllAdmins();
    }

   
    private void validateAdmin(Admin a) {
        if (a.getFirstName() == null || a.getFirstName().trim().isEmpty()) {
            throw new InvalidInputException("First name cannot be empty.");
        }
        if (a.getLastName() == null || a.getLastName().trim().isEmpty()) {
            throw new InvalidInputException("Last name cannot be empty.");
        }
        if (a.getEmail() == null || !a.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
            throw new InvalidInputException("Invalid email format.");
        }
        if (a.getPhoneNumber() == null || !a.getPhoneNumber().matches("\\d{10}")) {
            throw new InvalidInputException("Phone number must be 10 digits.");
        }
        if (a.getUsername() == null || a.getUsername().trim().isEmpty()) {
            throw new InvalidInputException("Username cannot be empty.");
        }
        if (a.getPassword() == null || a.getPassword().length() < 6) {
            throw new InvalidInputException("Password must be at least 6 characters long.");
        }
        if (a.getRole() == null || a.getRole().trim().isEmpty()) {
            throw new InvalidInputException("Role must be provided.");
        }
    }
}
