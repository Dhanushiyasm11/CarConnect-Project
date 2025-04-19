package com.hexaware.cc.dao;

import com.hexaware.cc.entity.Vehicle;
import java.util.List;

public interface IVehicleDao {
    Vehicle getVehicleById(int vehicleId);
    List<Vehicle> getAvailableVehicles();
    void addVehicle(Vehicle vehicle);
    void updateVehicle(Vehicle vehicle);
    void removeVehicle(int vehicleId);
    List<Vehicle> getAllVehicles();
}
