<<<<<<< HEAD
/*@author - Akshaya
 * date- 11-04-2025
 * desc- created reservation class
 * 
 * */

package com.hexaware.cc.entity;

import java.util.Date;
=======
/*@author - Akshaya*/

package com.hexaware.cc.entity;

import java.time.LocalDate;
>>>>>>> dhanushiya-dev

public class Admin {
    private int adminId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;
    private String role;
<<<<<<< HEAD
    private Date joinDate;
=======
    private LocalDate joinDate;
>>>>>>> dhanushiya-dev

    public Admin() {}

    public Admin(int adminId, String firstName, String lastName, String email,
                 String phoneNumber, String username, String password,
<<<<<<< HEAD
                 String role, Date joinDate) {
=======
                 String role, LocalDate joinDate) {
>>>>>>> dhanushiya-dev
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

<<<<<<< HEAD
    // Getters and Setters

    public boolean authenticate(String inputPassword) {
        return this.password.equals(inputPassword);
    }
}
=======
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public boolean authenticate(String password2) {
		// TODO Auto-generated method stub
		return false;
	}


}
>>>>>>> dhanushiya-dev
