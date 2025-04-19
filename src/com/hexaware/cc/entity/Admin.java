/*@author - Akshaya
 * date- 11-04-2025
 * desc- created reservation class
 * 
 * */

package com.hexaware.cc.entity;

import java.util.Date;

public class Admin {
    private int adminId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;
    private String role;
    private Date joinDate;

    public Admin() {}

    public Admin(int adminId, String firstName, String lastName, String email,
                 String phoneNumber, String username, String password,
                 String role, Date joinDate) {
        this.adminId = adminId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.role = role;
        this.joinDate = joinDate;
    }

    // Getters and Setters

    public boolean authenticate(String inputPassword) {
        return this.password.equals(inputPassword);
    }
}
