package com.youcode.rentalhive.infrastructure.reservation;

import com.youcode.rentalhive.domain.reservation.Reservation;
import com.youcode.rentalhive.domain.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ReservationController {


    public ResponseEntity<Reservation> save(@RequestBody Reservation reservation);

    public List<Reservation> findAll();


    public List<Reservation> findByEquipmentIdAndUserId(long equipmentId, long userID);
}
