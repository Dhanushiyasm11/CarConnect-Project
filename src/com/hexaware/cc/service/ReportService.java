package com.hexaware.cc.service;

import java.sql.*;
import com.hexaware.cc.util.DBConnUtil;
import com.hexaware.cc.util.DBPropertyUtil;

public class ReportService implements IReportService {

    @Override
    public void generateReservationHistoryReport() {
        String query = "SELECT r.ReservationID, c.FirstName, c.LastName, v.Model, v.RegistrationNumber, " +
                       "r.StartDate, r.EndDate, r.TotalCost, r.Status " +
                       "FROM Reservation r " +
                       "JOIN Customer c ON r.CustomerID = c.CustomerID " +
                       "JOIN Vehicle v ON r.VehicleID = v.VehicleID";

        try (Connection conn = DBConnUtil.getConnection(DBPropertyUtil.getConnectionString("db.properties"));
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("=== Reservation History Report ===");
            while (rs.next()) {
                System.out.println("Reservation ID   : " + rs.getInt("ReservationID"));
                System.out.println("Customer Name    : " + rs.getString("FirstName") + " " + rs.getString("LastName"));
                System.out.println("Vehicle Model    : " + rs.getString("Model"));
                System.out.println("Reg. Number      : " + rs.getString("RegistrationNumber"));
                System.out.println("Start Date       : " + rs.getDate("StartDate"));
                System.out.println("End Date         : " + rs.getDate("EndDate"));
                System.out.println("Total Cost       : ₹" + rs.getDouble("TotalCost"));
                System.out.println("Status           : " + rs.getString("Status"));
                System.out.println("---------------------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error generating reservation history report: " + e.getMessage());
        }
    }

    @Override
    public void generateVehicleUtilizationReport() {
        String query = "SELECT v.VehicleID, v.Model, v.RegistrationNumber, " +
                       "COUNT(r.ReservationID) AS TotalReservations " +
                       "FROM Vehicle v LEFT JOIN Reservation r ON v.VehicleID = r.VehicleID " +
                       "GROUP BY v.VehicleID";

        try (Connection conn = DBConnUtil.getConnection(DBPropertyUtil.getConnectionString("db.properties"));
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("=== Vehicle Utilization Report ===");
            while (rs.next()) {
                System.out.println("Vehicle ID       : " + rs.getInt("VehicleID"));
                System.out.println("Model            : " + rs.getString("Model"));
                System.out.println("Reg. Number      : " + rs.getString("RegistrationNumber"));
                System.out.println("Total Reservations : " + rs.getInt("TotalReservations"));
                System.out.println("---------------------------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error generating vehicle utilization report: " + e.getMessage());
        }
    }

    @Override
    public void generateRevenueReport() {
        String query = "SELECT SUM(TotalCost) AS TotalRevenue " +
                       "FROM Reservation WHERE Status = 'completed'";

        try (Connection conn = DBConnUtil.getConnection(DBPropertyUtil.getConnectionString("db.properties"));
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            System.out.println("=== Revenue Report ===");
            if (rs.next()) {
                System.out.println("Total Revenue from Completed Reservations: ₹" + rs.getDouble("TotalRevenue"));
            } else {
                System.out.println("No completed reservations found.");
            }

        } catch (SQLException e) {
            System.out.println("Error generating revenue report: " + e.getMessage());
        }
    }
}
