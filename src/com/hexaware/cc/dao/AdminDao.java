/*@author - Akshaya*/


package com.hexaware.cc.dao;

import com.hexaware.cc.entity.Admin;
import com.hexaware.cc.util.DBConnUtil;
import com.hexaware.cc.util.DBPropertyUtil;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdminDao implements IAdminDao {
    Connection conn;

    public AdminDao() {
        String connStr = DBPropertyUtil.getConnectionString("db.properties");
        conn = DBConnUtil.getConnection(connStr);
    }

    public Admin getAdminById(int id) {
        Admin a = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Admin WHERE AdminID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) a = mapRow(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public Admin getAdminByUsername(String username) {
        Admin a = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Admin WHERE Username=?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) a = mapRow(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    public void registerAdmin(Admin a) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Admin (FirstName, LastName, Email, PhoneNumber, Username, Password, Role, JoinDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, a.getFirstName());
            ps.setString(2, a.getLastName());
            ps.setString(3, a.getEmail());
            ps.setString(4, a.getPhoneNumber());
            ps.setString(5, a.getUsername());
            ps.setString(6, a.getPassword());
            ps.setString(7, a.getRole());
            ps.setDate(8, Date.valueOf(a.getJoinDate()));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAdmin(Admin a) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE Admin SET FirstName=?, LastName=?, Email=?, PhoneNumber=?, Password=?, Role=? WHERE AdminID=?");
            ps.setString(1, a.getFirstName());
            ps.setString(2, a.getLastName());
            ps.setString(3, a.getEmail());
            ps.setString(4, a.getPhoneNumber());
            ps.setString(5, a.getPassword());
            ps.setString(6, a.getRole());
            ps.setInt(7, a.getAdminId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAdmin(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Admin WHERE AdminID=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Admin> getAllAdmins() {
        List<Admin> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Admin");
            while (rs.next()) list.add(mapRow(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private Admin mapRow(ResultSet rs) throws SQLException {
        Admin a = new Admin();
        a.setAdminId(rs.getInt("AdminID"));
        a.setFirstName(rs.getString("FirstName"));
        a.setLastName(rs.getString("LastName"));
        a.setEmail(rs.getString("Email"));
        a.setPhoneNumber(rs.getString("PhoneNumber"));
        a.setUsername(rs.getString("Username"));
        a.setPassword(rs.getString("Password"));
        a.setRole(rs.getString("Role"));
        a.setJoinDate(rs.getDate("JoinDate").toLocalDate());
        return a;
    }
}
