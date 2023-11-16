package com.youcode.rentalhive.application.reservation;

import com.youcode.rentalhive.domain.reservation.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {

    public Reservation save(Reservation reservation);

    public List<Reservation> findAll();

    public Reservation findByIdAndUserId(int id , int userId);
}
