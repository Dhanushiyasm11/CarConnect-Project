/*@author - Akshaya
 * date- 11-04-2025
 * desc- created reservation class
 * 
 * */


package com.hexaware.cc.entity;

import java.util.Date;

public class Reservation {
    private int reservationId;
    private int customerId;
    private int vehicleId;
    private Date startDate;
    private Date endDate;
    private double totalCost;
    private String status;

    public Reservation() {}

    public Reservation(int reservationId, int customerId, int vehicleId, Date startDate,
                       Date endDate, double totalCost, String status) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.status = status;
    }

    // Getters and Setters

    public double calculateTotalCost(double dailyRate) {
        long days = (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24);
        return days * dailyRate;
    }
}
