package com.youcode.rentalhive.infrastructure.reservation;

import com.youcode.rentalhive.application.reservation.ReservationService;
import com.youcode.rentalhive.domain.reservation.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reservations")
public class ReservationControllerImpl implements ReservationController{

    private final ReservationService reservationService;


    @PostMapping("/save")
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }
    @GetMapping("/")
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @GetMapping("/find/")
    public Reservation findByIdAndUserId(int id, int userID) {
        return reservationService.findByIdAndUserId(id ,userID);
    }

}
