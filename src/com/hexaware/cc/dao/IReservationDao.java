/*@author - Akshaya*/


package com.hexaware.cc.dao;

import com.hexaware.cc.entity.Reservation;
import java.util.List;

public interface IReservationDao {
    Reservation getReservationById(int reservationId);
    List<Reservation> getReservationsByCustomerId(int customerId);
    void createReservation(Reservation reservation);
    void updateReservation(Reservation reservation);
    void cancelReservation(int reservationId);
}