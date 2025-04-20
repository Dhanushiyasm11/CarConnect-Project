package com.hexaware.cc.test;

import com.hexaware.cc.entity.Customer; 
import com.hexaware.cc.entity.Vehicle;
import com.hexaware.cc.service.CustomerService;
import com.hexaware.cc.service.VehicleService;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CarConnectTests {

    // 1. Test customer authentication with invalid credentials 
    @Test
    public void testCustomerAuthenticationInvalidCredentials() {
        CustomerService service = new CustomerService(null);
        Customer customer = service.authenticate("invalid@example.com", "wrongpassword");
        assertNull(customer, "Authentication should fail with invalid credentials.");
    }

    // 2. Test updating customer information
    @Test
    public void testUpdatingCustomerInformation() {
        CustomerService service = new CustomerService(null);

        // Ensure this ID exists in DB before testing
        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setFirstName("Updated Name");
        customer.setEmail("updated.email@example.com");
        customer.setPhoneNumber("9876543210");
        customer.setPassword("updatedpass");

        try {
            service.updateCustomer(customer);
            Customer updated = service.getCustomerById(1);

            assertNotNull(updated);
            assertEquals("Updated Name", updated.getFirstName());
            assertEquals("updated.email@example.com", updated.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Customer update failed due to exception: " + e.getMessage());
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
    }}