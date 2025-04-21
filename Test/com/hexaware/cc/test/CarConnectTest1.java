//@Author - Dhanushiya SM

package com.hexaware.cc.test;

import com.hexaware.cc.entity.Customer;
import com.hexaware.cc.entity.Vehicle;
import com.hexaware.cc.service.CustomerService;
import com.hexaware.cc.service.VehicleService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class CarConnectTest1 {

    // 1. Test customer authentication with invalid credentials
    @Test
    public void testCustomerAuthenticationInvalidCredentials() {
        CustomerService service = new CustomerService(null);

        
        try {
            Customer customer = service.authenticate("invalid@example.com", "wrongpassword");
            assertNull(customer, "Authentication should fail with invalid credentials.");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred during authentication: " + e.getMessage());
        }
    }

    // 2. Test updating customer information
    @Test
    public void testUpdatingCustomerInformation() {
        CustomerService service = new CustomerService(null);

        
        Customer customer = service.getCustomerById(1); 

        if (customer != null) {
            
            customer.setFirstName("Updated Name");
            customer.setLastName("Updated Last Name");  
            customer.setEmail("updated.email@example.com");
            customer.setPhoneNumber("9876543210");
            customer.setPassword("updatedpass");

            try {
                service.updateCustomer(customer);
                Customer updated = service.getCustomerById(customer.getCustomerId());

                assertNotNull(updated, "Updated customer should not be null.");
                assertEquals("Updated Name", updated.getFirstName(), "Customer first name should be updated.");
                assertEquals("Updated Last Name", updated.getLastName(), "Customer last name should be updated.");
                assertEquals("updated.email@example.com", updated.getEmail(), "Customer email should be updated.");
            } catch (Exception e) {
                e.printStackTrace();
                fail("Customer update failed due to exception: " + e.getMessage());
            }
        } else {
            fail("Customer with ID 1 not found in database.");
        }
    }

    // 3. Test adding a new vehicle
    @Test
    public void testAddingNewVehicle() {
        VehicleService service = new VehicleService(null);

        Vehicle vehicle = new Vehicle();
        vehicle.setModel("Tata Nexon");
        vehicle.setMake("Tata");
        vehicle.setYear(2023);
        vehicle.setColor("Red");
        vehicle.setRegistrationNumber("REG" + System.currentTimeMillis()); // Unique
        vehicle.setAvailability(true);
        vehicle.setDailyRate(3500);

        try {
            service.addVehicle(vehicle);
            List<Vehicle> allVehicles = service.getAllVehicles();
            boolean found = allVehicles.stream()
                .anyMatch(v -> v.getRegistrationNumber().equals(vehicle.getRegistrationNumber()));
            assertTrue(found, "Vehicle should be added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Add vehicle failed due to exception: " + e.getMessage());
        }
    }
}
