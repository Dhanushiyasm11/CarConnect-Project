<<<<<<< HEAD
/*@author - Akshaya
 * date- 11-04-2025
 * desc- created reservation class
 * 
 * */
=======
/*@author - Akshaya*/
>>>>>>> dhanushiya-dev


package com.hexaware.cc.entity;

<<<<<<< HEAD
import java.util.Date;
=======
import java.time.LocalDateTime;
>>>>>>> dhanushiya-dev

public class Reservation {
    private int reservationId;
    private int customerId;
    private int vehicleId;
<<<<<<< HEAD
    private Date startDate;
    private Date endDate;
=======
    private LocalDateTime startDate;
    private LocalDateTime endDate;
>>>>>>> dhanushiya-dev
    private double totalCost;
    private String status;

    public Reservation() {}

<<<<<<< HEAD
    public Reservation(int reservationId, int customerId, int vehicleId, Date startDate,
                       Date endDate, double totalCost, String status) {
=======
    public Reservation(int reservationId, int customerId, int vehicleId,
                       LocalDateTime startDate, LocalDateTime endDate,
                       double totalCost, String status) {
>>>>>>> dhanushiya-dev
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.vehicleId = vehicleId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalCost = totalCost;
        this.status = status;
    }

<<<<<<< HEAD
    // Getters and Setters

    public double calculateTotalCost(double dailyRate) {
        long days = (endDate.getTime() - startDate.getTime()) / (1000 * 60 * 60 * 24);
        return days * dailyRate;
    }
}
=======
	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    

   
}
>>>>>>> dhanushiya-dev
