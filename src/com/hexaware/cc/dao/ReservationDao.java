/*@author - Akshaya*/


package com.hexaware.cc.dao;

import com.hexaware.cc.entity.Reservation;
import com.hexaware.cc.util.DBConnUtil;
import com.hexaware.cc.util.DBPropertyUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ReservationDao implements IReservationDao {
    Connection conn;

    public ReservationDao() {
        String connStr = DBPropertyUtil.getConnectionString("db.properties");
        conn = DBConnUtil.getConnection(connStr);
    }

    public Reservation getReservationById(int id) {
        Reservation r = null;
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reservation WHERE ReservationID=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) r = mapRow(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    public List<Reservation> getReservationsByCustomerId(int customerId) {
        List<Reservation> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reservation WHERE CustomerID=?");
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(mapRow(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void createReservation(Reservation r) {
        try {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Reservation (CustomerID, VehicleID, StartDate, EndDate, TotalCost, Status) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, r.getCustomerId());
            ps.setInt(2, r.getVehicleId());
            ps.setTimestamp(3, Timestamp.valueOf(r.getStartDate()));
            ps.setTimestamp(4, Timestamp.valueOf(r.getEndDate()));
            ps.setDouble(5, r.getTotalCost());
            ps.setString(6, r.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateReservation(Reservation r) {
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE Reservation SET StartDate=?, EndDate=?, TotalCost=?, Status=? WHERE ReservationID=?");
            ps.setTimestamp(1, Timestamp.valueOf(r.getStartDate()));
            ps.setTimestamp(2, Timestamp.valueOf(r.getEndDate()));
            ps.setDouble(3, r.getTotalCost());
            ps.setString(4, r.getStatus());
            ps.setInt(5, r.getReservationId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cancelReservation(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Reservation WHERE ReservationID=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Reservation mapRow(ResultSet rs) throws SQLException {
        Reservation r = new Reservation();
        r.setReservationId(rs.getInt("ReservationID"));
        r.setCustomerId(rs.getInt("CustomerID"));
        r.setVehicleId(rs.getInt("VehicleID"));
        r.setStartDate(rs.getTimestamp("StartDate").toLocalDateTime());
        r.setEndDate(rs.getTimestamp("EndDate").toLocalDateTime());
        r.setTotalCost(rs.getDouble("TotalCost"));
        r.setStatus(rs.getString("Status"));
        return r;
    }
}