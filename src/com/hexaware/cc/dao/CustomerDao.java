package com.hexaware.cc.dao;

import com.hexaware.cc.entity.Customer;
import com.hexaware.cc.util.DBConnUtil;
import com.hexaware.cc.util.DBPropertyUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements ICustomerDao {
    Connection conn;

    public CustomerDao() {
        String connStr = DBPropertyUtil.getConnectionString("db.properties");
        conn = DBConnUtil.getConnection(connStr);
    }

    public Customer getCustomerById(int customerId) {
        Customer c = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer WHERE CustomerID = ?");
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new Customer();
                c.setCustomerId(rs.getInt("CustomerID"));
                c.setFirstName(rs.getString("FirstName"));
                c.setLastName(rs.getString("LastName"));
                c.setEmail(rs.getString("Email"));
                c.setPhoneNumber(rs.getString("PhoneNumber"));
                c.setAddress(rs.getString("Address"));
                c.setUsername(rs.getString("Username"));
                c.setPassword(rs.getString("Password"));
                c.setRegistrationDate(rs.getDate("RegistrationDate").toLocalDate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public Customer getCustomerByUsername(String username) {
        Customer c = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Customer WHERE Username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new Customer();
                c.setCustomerId(rs.getInt("CustomerID"));
                c.setFirstName(rs.getString("FirstName"));
                c.setLastName(rs.getString("LastName"));
                c.setEmail(rs.getString("Email"));
                c.setPhoneNumber(rs.getString("PhoneNumber"));
                c.setAddress(rs.getString("Address"));
                c.setUsername(rs.getString("Username"));
                c.setPassword(rs.getString("Password"));
                c.setRegistrationDate(rs.getDate("RegistrationDate").toLocalDate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public void registerCustomer(Customer c) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Customer (FirstName, LastName, Email, PhoneNumber, Address, Username, Password, RegistrationDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getPhoneNumber());
            ps.setString(5, c.getAddress());
            ps.setString(6, c.getUsername());
            ps.setString(7, c.getPassword());
            ps.setDate(8, java.sql.Date.valueOf(c.getRegistrationDate()));
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCustomer(Customer c) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE Customer SET FirstName=?, LastName=?, Email=?, PhoneNumber=?, Address=?, Password=? WHERE CustomerID=?");
            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getPhoneNumber());
            ps.setString(5, c.getAddress());
            ps.setString(6, c.getPassword());
            ps.setInt(7, c.getCustomerId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int customerId) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Customer WHERE CustomerID=?");
            ps.setInt(1, customerId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Customer");
            while (rs.next()) {
                Customer c = new Customer();
                c.setCustomerId(rs.getInt("CustomerID"));
                c.setFirstName(rs.getString("FirstName"));
                c.setLastName(rs.getString("LastName"));
                c.setEmail(rs.getString("Email"));
                c.setPhoneNumber(rs.getString("PhoneNumber"));
                c.setAddress(rs.getString("Address"));
                c.setUsername(rs.getString("Username"));
                c.setPassword(rs.getString("Password"));
                c.setRegistrationDate(rs.getDate("RegistrationDate").toLocalDate());
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}