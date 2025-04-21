//@Author - Dhanushiya SM

package com.hexaware.cc.service;

import com.hexaware.cc.dao.VehicleDao;
import com.hexaware.cc.entity.Vehicle;
import com.hexaware.cc.exception.InvalidInputException;
import java.util.List;

public class VehicleService implements IVehicleService {
    private VehicleDao dao = new VehicleDao();

    public VehicleService(Object object) {
       
    }

    public VehicleService() {
       
    }

    @Override
    public Vehicle getVehicleById(int id) {
        if (id <= 0) {
            throw new InvalidInputException("Vehicle ID must be greater than 0.");
        }
        return dao.getVehicleById(id);
    }

    @Override
    public List<Vehicle> getAvailableVehicles() {
        return dao.getAvailableVehicles();
    }

    @Override
    public void addVehicle(Vehicle v) {
        validateVehicle(v); // Validate the vehicle before adding it to the database
        dao.addVehicle(v);
    }

    @Override
    public void updateVehicle(Vehicle v) {
        if (v.getVehicleId() <= 0) {
            throw new InvalidInputException("Invalid Vehicle ID.");
        }
        validateVehicle(v); // Validate the vehicle before updating it
        dao.updateVehicle(v);
    }

    @Override
    public void removeVehicle(int id) {
        if (id <= 0) {
            throw new InvalidInputException("Vehicle ID must be greater than 0.");
        }
        dao.removeVehicle(id);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return dao.getAllVehicles();
    }

   
    private void validateVehicle(Vehicle v) {
        if (v.getModel() == null || v.getModel().trim().isEmpty()) {
            throw new InvalidInputException("Model cannot be empty.");
        }
        if (v.getMake() == null || v.getMake().trim().isEmpty()) {
            throw new InvalidInputException("Make cannot be empty.");
        }
        if (v.getRegistrationNumber() == null || v.getRegistrationNumber().trim().isEmpty()) {
            throw new InvalidInputException("Registration number cannot be empty.");
        }
        if (v.getDailyRate() <= 0) {
            throw new InvalidInputException("Daily rate must be greater than 0.");
        }
        if (v.getYear() <= 0 || v.getYear() > 2023) {  // Example: vehicle year should be valid
            throw new InvalidInputException("Invalid manufacturing year.");
        }
        if (v.getColor() == null || v.getColor().trim().isEmpty()) {
            throw new InvalidInputException("Color cannot be empty.");
        }
    }
}
