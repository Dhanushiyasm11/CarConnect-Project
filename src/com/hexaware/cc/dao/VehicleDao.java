//@Author - Dhanushiya SM

package com.hexaware.cc.dao;

import com.hexaware.cc.entity.Vehicle;
import com.hexaware.cc.util.DBConnUtil;
import com.hexaware.cc.util.DBPropertyUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDao implements IVehicleDao {
    Connection conn;

    public VehicleDao() {
        String connStr = DBPropertyUtil.getConnectionString("db.properties");
        conn = DBConnUtil.getConnection(connStr);
    }

    public Vehicle getVehicleById(int vehicleId) {
        Vehicle v = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Vehicle WHERE VehicleID=?");
            ps.setInt(1, vehicleId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                v = mapRow(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return v;
    }

    public List<Vehicle> getAvailableVehicles() {
        List<Vehicle> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Vehicle WHERE Availability=true");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addVehicle(Vehicle v) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Vehicle (Model, Make, Year, Color, RegistrationNumber, Availability, DailyRate) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, v.getModel());
            ps.setString(2, v.getMake());
            ps.setInt(3, v.getYear());
            ps.setString(4, v.getColor());
            ps.setString(5, v.getRegistrationNumber());
            ps.setBoolean(6, v.isAvailability());
            ps.setDouble(7, v.getDailyRate());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateVehicle(Vehicle v) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE Vehicle SET Model=?, Make=?, Year=?, Color=?, RegistrationNumber=?, Availability=?, DailyRate=? WHERE VehicleID=?");
            ps.setString(1, v.getModel());
            ps.setString(2, v.getMake());
            ps.setInt(3, v.getYear());
            ps.setString(4, v.getColor());
            ps.setString(5, v.getRegistrationNumber());
            ps.setBoolean(6, v.isAvailability());
            ps.setDouble(7, v.getDailyRate());
            ps.setInt(8, v.getVehicleId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeVehicle(int vehicleId) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Vehicle WHERE VehicleID=?");
            ps.setInt(1, vehicleId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> list = new ArrayList<>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Vehicle");
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private Vehicle mapRow(ResultSet rs) throws SQLException {
        Vehicle v = new Vehicle();
        v.setVehicleId(rs.getInt("VehicleID"));
        v.setModel(rs.getString("Model"));
        v.setMake(rs.getString("Make"));
        v.setYear(rs.getInt("Year"));
        v.setColor(rs.getString("Color"));
        v.setRegistrationNumber(rs.getString("RegistrationNumber"));
        v.setAvailability(rs.getBoolean("Availability"));
        v.setDailyRate(rs.getDouble("DailyRate"));
        return v;
    }
}