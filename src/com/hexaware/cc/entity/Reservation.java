/*
 * @author:Akshaya
 * date:11-04-2025
 * desc:created reservation entity class
 * 
 * */


package com.hexaware.cc.entity;

import java.time.LocalDateTime;

public class Reservation {
    private int reservationId;
    private int customerId;
    private int vehicleId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private double totalCost;
    private String status;

    public Reservation() {}

    public Reservation(int reservationId, int customerId, int vehicleId,
                       LocalDateTime startDate, LocalDateTime endDate,
                       double totalCost, String status) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.status = status;
    }

    // Getters and Setters
    public int getReservationId() { return reservationId; }
    public void setReservationId(int reservationId) { this.reservationId = reservationId; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }

    public LocalDateTime getStartDate() { return startDate; }
    public void setStartDate(LocalDateTime startDate) { this.startDate = startDate; }

    public LocalDateTime getEndDate() { return endDate; }
    public void setEndDate(LocalDateTime endDate) { this.endDate = endDate; }

    public double getTotalCost() { return totalCost; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Business method
    public void calculateTotalCost(double dailyRate) {
        long days = java.time.Duration.between(startDate, endDate).toDays();
        if (days <= 0) days = 1; // Minimum 1 day charge
        this.totalCost = days * dailyRate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
               "reservationId=" + reservationId +
               ", customerId=" + customerId +
               ", vehicleId=" + vehicleId +
               ", startDate=" + startDate +
               ", endDate=" + endDate +
               ", totalCost=" + totalCost +
               ", status='" + status + '\'' +
               '}';
    }
}