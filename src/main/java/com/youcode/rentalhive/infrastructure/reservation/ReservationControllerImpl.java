package com.youcode.rentalhive.infrastructure.reservation;

import com.youcode.rentalhive.application.reservation.ReservationService;
import com.youcode.rentalhive.domain.equipement.Equipement;
import com.youcode.rentalhive.domain.equipement.EquipementRepository;
import com.youcode.rentalhive.domain.reservation.Reservation;
import com.youcode.rentalhive.domain.user.User;
import lombok.RequiredArgsConstructor;
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
    private final EquipementRepository equipementRepository;



    @PostMapping("/save")
    public Reservation save(@RequestBody Reservation reservation) {

        User userId = reservation.getUser();
        Equipement equipementId = reservation.getEquipement();

        User user = new User();
        user.setId(userId.getId());

        Equipement equipement = new Equipement();
        equipement.setId(equipementId.getId());

        reservation.setUser(user);
        reservation.setEquipement(equipement);

        Optional<Equipement> fetchedEquipement = equipementRepository.findById(equipement.getId());

        if (fetchedEquipement != null) {
            reservation.setCost(fetchedEquipement.get().getDailyRentalCost());
        } else {
            System.err.println("Equipement not found for ID: " + equipement.getId());
        }

        return reservationService.save(reservation);

    }
    @GetMapping("/")
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @GetMapping("/find/{id}/{userID}")
    public Reservation findByIdAndUserId(@PathVariable long id ,@PathVariable User userID) {

        return reservationService.findByIdAndUserId(id ,userID);
    }

}
