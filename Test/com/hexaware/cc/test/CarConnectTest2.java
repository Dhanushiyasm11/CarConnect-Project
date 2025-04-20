//@Author - Akshaya S


package com.hexaware.cc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.hexaware.cc.entity.Vehicle;
import com.hexaware.cc.service.VehicleService;

public class CarConnectTest2 {

//4. Test updating vehicle details
@Test
public void testUpdatingVehicleDetails() {
    VehicleService service = new VehicleService(null);

    Vehicle vehicle = new Vehicle();
    vehicle.setVehicleId(1); // Ensure this ID exists in DB
    vehicle.setModel("Hyundai Verna");
    vehicle.setMake("Hyundai");
    vehicle.setYear(2021);
    vehicle.setColor("White");
    vehicle.setRegistrationNumber("REG" + System.currentTimeMillis()); 
    vehicle.setAvailability(true);
    vehicle.setDailyRate(4000);

    try {
        service.updateVehicle(vehicle);
        Vehicle updated = service.getVehicleById(1);

        assertNotNull(updated);
        assertEquals("Hyundai Verna", updated.getModel());
        assertEquals("White", updated.getColor());
    } catch (Exception e) {
        e.printStackTrace();
        fail("Vehicle update failed due to exception: " + e.getMessage());
    }
}

// 5. Test getting a list of available vehicles
@Test
public void testGetAvailableVehicles() {
    VehicleService service = new VehicleService(null);

    List<Vehicle> available = service.getAvailableVehicles();
    assertNotNull(available, "Available vehicle list should not be null.");
    assertTrue(available.stream().allMatch(Vehicle::isAvailability), 
               "All returned vehicles should be available.");
}

// 6. Test getting a list of all vehicles
@Test
public void testGetAllVehicles() {
    VehicleService service = new VehicleService(null);

    List<Vehicle> all = service.getAllVehicles();
    assertNotNull(all, "Vehicle list should not be null.");
    assertTrue(all.size() > 0, "Vehicle list should contain records.");
}
}