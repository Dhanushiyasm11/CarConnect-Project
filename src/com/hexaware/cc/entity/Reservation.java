/*@author - Akshaya
 * Date - 11-04-2025
 * Desc - Created Reservation Entity Class
 */


package com.hexaware.cc.entity;

import java.time.LocalDate;

public class Reservation {
    private int reservationID;
    private int customerID;
    private int vehicleID;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalCost;
    private String status;

    public Reservation() {}

    public Reservation(int reservationID, int customerID, int vehicleID,
                       LocalDate startDate, LocalDate endDate,
                       double totalCost, String status) {
        this.reservationID = reservationID;
        this.customerID = customerID;
        this.vehicleID = vehicleID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.status = status;
    }

    public int getReservationID() { return reservationID; }
    public void setReservationID(int reservationID) { this.reservationID = reservationID; }

    public int getCustomerID() { return customerID; }
    public void setCustomerID(int customerID) { this.customerID = customerID; }

    public int getVehicleID() { return vehicleID; }
    public void setVehicleID(int vehicleID) { this.vehicleID = vehicleID; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public double getTotalCost() { return totalCost; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public void calculateTotalCost(double dailyRate) {
        long days = java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
        this.totalCost = dailyRate * days;
    }
}