
/*@author - Akshaya*/
package com.hexaware.cc.service;

import com.hexaware.cc.dao.AdminDao;
import com.hexaware.cc.entity.Admin;
import java.util.List;

public class AdminService implements IAdminService {
    private AdminDao dao = new AdminDao();

    public Admin getAdminById(int id) {
        return dao.getAdminById(id);
    }

    public Admin getAdminByUsername(String username) {
        return dao.getAdminByUsername(username);
    }

    public void registerAdmin(Admin a) {
        dao.registerAdmin(a);
    }

    public void updateAdmin(Admin a) {
        dao.updateAdmin(a);
    }

    public void deleteAdmin(int id) {
        dao.deleteAdmin(id);
    }

    public List<Admin> getAllAdmins() {
        return dao.getAllAdmins();
    }
}
