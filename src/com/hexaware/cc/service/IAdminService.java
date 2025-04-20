/*@author - Akshaya*/

package com.hexaware.cc.service;

import com.hexaware.cc.entity.Admin;
import java.util.List;

public interface IAdminService {
    Admin getAdminById(int adminId);
    Admin getAdminByUsername(String username);
    void registerAdmin(Admin admin);
    void updateAdmin(Admin admin);
    void deleteAdmin(int adminId);
    List<Admin> getAllAdmins();
}
