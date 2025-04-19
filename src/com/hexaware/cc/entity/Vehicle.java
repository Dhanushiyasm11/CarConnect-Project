/*@author - Dhanushiya SM
 * Date - 11-04-2025
 * Desc - Created Vehicle Entity Class
 */
package com.hexaware.cc.entity;

public class Vehicle {
    private int vehicleId;
    private String make;
    private String model;
    private int year;
    private double pricePerDay;
    private String status; 

    
    public Vehicle(int vehicleId, String make, String model, int year, double pricePerDay, String status) {
        this.vehicleId = vehicleId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.pricePerDay = pricePerDay;
        this.status = status;
    }

 
    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

 
}
