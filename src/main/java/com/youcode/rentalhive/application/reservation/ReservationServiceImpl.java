package com.youcode.rentalhive.application.reservation;

import com.youcode.rentalhive.domain.reservation.Reservation;
import com.youcode.rentalhive.domain.reservation.ReservationRepository;
import com.youcode.rentalhive.application.reservation.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{


    private final ReservationRepository reservationRepository;



    @Override
    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findByIdAndUserId(int id , int userId) {
        return reservationRepository.findByIdAndUserId(id,userId);
    }
}
