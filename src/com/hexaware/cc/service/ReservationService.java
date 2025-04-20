
/*@author - Akshaya*/
package com.hexaware.cc.service;

import com.hexaware.cc.dao.ReservationDao;
import com.hexaware.cc.entity.Reservation;
import java.util.List;

public class ReservationService implements IReservationService {
    private ReservationDao dao = new ReservationDao();

    public Reservation getReservationById(int id) {
        return dao.getReservationById(id);
    }

    public List<Reservation> getReservationsByCustomerId(int customerId) {
        return dao.getReservationsByCustomerId(customerId);
    }

    public void createReservation(Reservation r) {
        dao.createReservation(r);
    }

    public void updateReservation(Reservation r) {
        dao.updateReservation(r);
    }

    public void cancelReservation(int id) {
        dao.cancelReservation(id);
    }
}
