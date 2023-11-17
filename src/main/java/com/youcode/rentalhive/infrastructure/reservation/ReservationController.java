package com.youcode.rentalhive.infrastructure.reservation;

import com.youcode.rentalhive.domain.reservation.Reservation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ReservationController {


    public Reservation save(@RequestBody Reservation reservation);

    public List<Reservation> findAll();


    public Reservation findByIdAndUserId(int id, int userID);
}
