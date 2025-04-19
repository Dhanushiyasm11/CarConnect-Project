//@Author - Dhanushiya SM


package com.hexaware.cc.service;

import com.hexaware.cc.dao.VehicleDao;
import com.hexaware.cc.entity.Vehicle;
import java.util.List;

public class VehicleService implements IVehicleService {
    private VehicleDao dao = new VehicleDao();

    public Vehicle getVehicleById(int id) {
        return dao.getVehicleById(id);
    }

    public List<Vehicle> getAvailableVehicles() {
        return dao.getAvailableVehicles();
    }

    public void addVehicle(Vehicle v) {
        dao.addVehicle(v);
    }

    public void updateVehicle(Vehicle v) {
        dao.updateVehicle(v);
    }

    public void removeVehicle(int id) {
        dao.removeVehicle(id);
    }

    public List<Vehicle> getAllVehicles() {
        return dao.getAllVehicles();
    }
}
