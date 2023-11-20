package com.youcode.rentalhive.infrastructure.reservation;

import com.youcode.rentalhive.application.reservation.ReservationService;
import com.youcode.rentalhive.domain.equipement.Equipement;
import com.youcode.rentalhive.domain.equipement.EquipementRepository;
import com.youcode.rentalhive.domain.reservation.Reservation;
import com.youcode.rentalhive.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reservations")
public class ReservationControllerImpl implements ReservationController{

    private final ReservationService reservationService;


    @PostMapping("/save")
    public ResponseEntity<Reservation> save(@RequestBody Reservation reservation) {

        Reservation reservation1 = reservationService.save(reservation);

        if (reservation1 != null) {
            return ResponseEntity.status(HttpStatus.OK).body(reservation1);
        } else {
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @GetMapping("/")
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @GetMapping("/find/{id}/{userID}")
    public List<Reservation> findByEquipmentIdAndUserId(@PathVariable(value = "id") long equipmentId ,@PathVariable(value = "userI") long userID) {
        long e = equipmentId;
        long u = userID;
        return reservationService.findByEquipmentIdAndUserId(equipmentId ,userID);
    }

}
