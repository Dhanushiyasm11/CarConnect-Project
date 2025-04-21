//@Author - Dhanushiya SM

package com.hexaware.cc.main;

import com.hexaware.cc.entity.*;
import com.hexaware.cc.service.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainModule {
    static Scanner sc = new Scanner(System.in);
    static ICustomerService customerService = new CustomerService();
    static IAdminService adminService = new AdminService();
    static IVehicleService vehicleService = new VehicleService();
    static IReservationService reservationService = new ReservationService();
    static AuthenticationService authService = new AuthenticationService(); 

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==== CarConnect Main Menu ====");
            System.out.println("1. Customer Login");
            System.out.println("2. Customer Register");
            System.out.println("3. Admin Login");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    customerLogin();
                    break;
                case 2:
                    customerRegister();
                    break;
                case 3:
                    adminLogin();
                    break;
                case 4:
                    System.out.println("Thank you for using CarConnect!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }

    static void customerRegister() {
        System.out.println("=== Customer Registration ===");
        Customer c = new Customer();
        sc.nextLine(); 
        System.out.print("First Name: ");
        c.setFirstName(sc.nextLine());
        System.out.print("Last Name: ");
        c.setLastName(sc.nextLine());
        System.out.print("Email: ");
        c.setEmail(sc.nextLine());
        System.out.print("Phone: ");
        c.setPhoneNumber(sc.nextLine());
        System.out.print("Address: ");
        c.setAddress(sc.nextLine());
        System.out.print("Username: ");
        c.setUsername(sc.nextLine());
        System.out.print("Password: ");
        c.setPassword(sc.nextLine());
        c.setRegistrationDate(LocalDate.now());

        
        customerService.registerCustomer(c);
        System.out.println("Customer registered successfully!");
    }

    static void customerLogin() {
        System.out.print("Enter Username: ");
        String username = sc.next();
        System.out.print("Enter Password: ");
        String password = sc.next();

        
        Customer c = authService.authenticateCustomer(username, password);
        if (c != null) {
            System.out.println("Login successful!");
            customerMenu(c);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    static void customerMenu(Customer c) {
        while (true) {
            System.out.println("\n-- Customer Menu --");
            System.out.println("1. View Profile");
            System.out.println("2. Update Profile");
            System.out.println("3. View Available Vehicles");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Welcome " + c.getFirstName() + " " + c.getLastName());
                    System.out.println("Email: " + c.getEmail());
                    System.out.println("Phone: " + c.getPhoneNumber());
                    break;
                case 2:
                    sc.nextLine(); // clear buffer
                    System.out.print("New Email: ");
                    c.setEmail(sc.nextLine());
                    System.out.print("New Phone: ");
                    c.setPhoneNumber(sc.nextLine());
                    System.out.print("New Password: ");
                    c.setPassword(sc.nextLine());
                    customerService.updateCustomer(c);
                    System.out.println("Profile updated!");
                    break;
                case 3:
                    List<Vehicle> list = vehicleService.getAvailableVehicles();
                    System.out.println("--- Available Vehicles ---");
                    for (Vehicle v : list) {
                        System.out.println(v.getVehicleId() + " - " + v.getMake() + " " + v.getModel() + " - ₹" + v.getDailyRate());
                    }
                    break;
                case 4:
                    System.out.println("Logged out.");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    static void adminLogin() {
        System.out.print("Enter Admin Username: ");
        String username = sc.next();
        System.out.print("Enter Password: ");
        String password = sc.next();

  
        Admin a = authService.authenticateAdmin(username, password);
        if (a != null) {
            System.out.println("Welcome Admin " + a.getFirstName());
            adminMenu(a);
        } else {
            System.out.println("Invalid admin credentials.");
        }
    }

    static void adminMenu(Admin a) {
        while (true) {
            System.out.println("\n-- Admin Menu --");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View All Vehicles");
            System.out.println("3. View All Customers");
            System.out.println("4. Logout");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    Vehicle v = new Vehicle();
                    sc.nextLine();
                    System.out.print("Model: ");
                    v.setModel(sc.nextLine());
                    System.out.print("Make: ");
                    v.setMake(sc.nextLine());
                    System.out.print("Year: ");
                    v.setYear(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Color: ");
                    v.setColor(sc.nextLine());
                    System.out.print("Registration No: ");
                    v.setRegistrationNumber(sc.nextLine());
                    System.out.print("Daily Rate: ");
                    v.setDailyRate(sc.nextDouble());
                    v.setAvailability(true);
                    vehicleService.addVehicle(v);
                    System.out.println("Vehicle added.");
                    break;
                case 2:
                    List<Vehicle> list = vehicleService.getAllVehicles();
                    System.out.println("--- All Vehicles ---");
                    for (Vehicle v1 : list) {
                        System.out.println(v1.getVehicleId() + " - " + v1.getMake() + " " + v1.getModel() + " - Available: " + v1.isAvailability());
                    }
                    break;
                case 3:
                    List<Customer> list1 = customerService.getAllCustomers();
                    System.out.println("--- Customers ---");
                    for (Customer c : list1) {
                        System.out.println(c.getCustomerId() + ": " + c.getFirstName() + " " + c.getLastName() + " - " + c.getEmail());
                    }
                    break;
                case 4:
                    System.out.println("Admin logged out.");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
