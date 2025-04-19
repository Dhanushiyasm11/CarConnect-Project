//@Author - Dhanushiya SM

package com.hexaware.cc.service;

import com.hexaware.cc.entity.Vehicle;
import java.util.List;

public interface IVehicleService {
    Vehicle getVehicleById(int vehicleId);
    List<Vehicle> getAvailableVehicles();
    void addVehicle(Vehicle vehicle);
    void updateVehicle(Vehicle vehicle);
    void removeVehicle(int vehicleId);
    List<Vehicle> getAllVehicles();
}
