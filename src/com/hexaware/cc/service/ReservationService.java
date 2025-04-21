//@Author - Akshaya
package com.hexaware.cc.service;

import com.hexaware.cc.dao.ReservationDao;
import com.hexaware.cc.entity.Reservation;
import com.hexaware.cc.exception.InvalidInputException;

import java.util.List;

public class ReservationService implements IReservationService {
    private ReservationDao dao = new ReservationDao();

    @Override
    public Reservation getReservationById(int id) {
        if (id <= 0) {
            throw new InvalidInputException("Reservation ID must be greater than 0.");
        }
        return dao.getReservationById(id);
    }

    @Override
    public List<Reservation> getReservationsByCustomerId(int customerId) {
        if (customerId <= 0) {
            throw new InvalidInputException("Customer ID must be greater than 0.");
        }
        return dao.getReservationsByCustomerId(customerId);
    }

    @Override
    public void createReservation(Reservation r) {
        validateReservation(r);  // Validate reservation before proceeding
        dao.createReservation(r);
    }

    @Override
    public void updateReservation(Reservation r) {
        if (r.getReservationId() <= 0) {
            throw new InvalidInputException("Invalid Reservation ID.");
        }
        validateReservation(r);  // Validate reservation before updating
        dao.updateReservation(r);
    }

    @Override
    public void cancelReservation(int id) {
        if (id <= 0) {
            throw new InvalidInputException("Reservation ID must be greater than 0.");
        }
        dao.cancelReservation(id);
    }

    
    private void validateReservation(Reservation r) {
        if (r.getStartDate() == null) {
            throw new InvalidInputException("Start date cannot be null.");
        }
        if (r.getEndDate() == null) {
            throw new InvalidInputException("End date cannot be null.");
        }
        if (r.getTotalCost() <= 0) {
            throw new InvalidInputException("Total cost must be greater than 0.");
        }
        if (r.getStatus() == null || r.getStatus().trim().isEmpty()) {
            throw new InvalidInputException("Reservation status cannot be empty.");
        }
        if (r.getStartDate().isAfter(r.getEndDate())) {
            throw new InvalidInputException("Start date cannot be after the end date.");
        }
    }
}
