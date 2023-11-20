package com.youcode.rentalhive.application.reservation;

import com.youcode.rentalhive.domain.equipement.EquipementRepository;
import com.youcode.rentalhive.domain.reservation.Reservation;
import com.youcode.rentalhive.domain.reservation.ReservationRepository;
import com.youcode.rentalhive.application.reservation.ReservationService;
import com.youcode.rentalhive.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{


    private final ReservationRepository reservationRepository;
    private final EquipementRepository equipementRepository;



    @Override
    public Reservation save(Reservation reservation) {
        try {

            double dailyRentalCost = reservation.getEquipement().getDailyRentalCost();
            int numberOfDays = calculateNumberOfDays(reservation.getStartDate(), reservation.getEndDate());
            double totalCost = dailyRentalCost * numberOfDays;

            reservation.setCost(totalCost);

            return reservationRepository.save(reservation);
        } catch (Exception e) {

            System.err.println("Failed to create reservation. Please try again.");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findByIdAndUserId(long reservationId, User userId) {
        return reservationRepository.findByIdAndUserEquals(reservationId, userId);
    }


    private int calculateNumberOfDays(Date startDate, Date endDate) {
        long timeDifference = endDate.getTime() - startDate.getTime();

        int daysDifference = (int) (timeDifference / (1000 * 60 * 60 * 24));

        return daysDifference;
    }
}
