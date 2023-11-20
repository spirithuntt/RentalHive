package com.youcode.rentalhive.application.reservation;

import com.youcode.rentalhive.domain.equipement.Equipement;
import com.youcode.rentalhive.domain.equipement.EquipementRepository;
import com.youcode.rentalhive.domain.reservation.Reservation;
import com.youcode.rentalhive.domain.reservation.ReservationRepository;
import com.youcode.rentalhive.application.reservation.ReservationService;
import com.youcode.rentalhive.domain.user.User;
import com.youcode.rentalhive.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.temporal.ChronoUnit;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{


    private final ReservationRepository reservationRepository;
    private final EquipementRepository equipementRepository;
    private final UserRepository userRepository;



    @Override
    public Reservation save(Reservation reservation) {

        Date currentDate = new Date();
        if (reservation.getStartDate().before(currentDate)) {
            throw new IllegalArgumentException("Reservation date cannot be in the past");
        }

        if (reservation.getStartDate().after(reservation.getEndDate())) {
            throw new IllegalArgumentException("Start time must be before end time");
        }
        try {

            Optional<Equipement> fetchedEquipement = equipementRepository.findById(reservation.getEquipement().getId());
            Optional<User> fetchedUser = userRepository.findById(reservation.getEquipement().getId());

            EquipmentAvailability(fetchedEquipement.get(),reservation.getStartDate(), reservation.getEndDate());

            validateReservationDates(fetchedEquipement.get(), reservation.getStartDate(), reservation.getEndDate());

            if (fetchedEquipement.isPresent() && fetchedUser.isPresent()) {
                reservation.setEquipement(fetchedEquipement.get());
                reservation.setUser(fetchedUser.get());
            } else {
                System.err.println("Equipement not found for ID: " + reservation.getEquipement().getId());
            }

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
    public List<Reservation> findByEquipmentIdAndUserId(long equipmentId, long userId) {
        Optional<Equipement> fetchedEquipement = equipementRepository.findById(equipmentId);
        Optional<User> fetchedUser = userRepository.findById(userId);

        return reservationRepository.findByEquipementIdAndUserId(fetchedEquipement.get().getId(), fetchedUser.get().getId());
    }


    private int calculateNumberOfDays(Date startDate, Date endDate) {
        long timeDifference = endDate.getTime() - startDate.getTime();

        int daysDifference = (int) (timeDifference / (1000 * 60 * 60 * 24));

        return daysDifference;
    }

    private void validateReservationDates(Equipement equipement, Date startDate, Date endDate) {
        List<Reservation> overlappingReservations = reservationRepository.validateReservationDates(
                equipement, startDate, endDate);

        if (!overlappingReservations.isEmpty()) {
            throw new IllegalArgumentException("Equipement has overlapping reservations for the specified date range");
        }
    }


    private void EquipmentAvailability(Equipement equipement, Date startDate, Date endDate) {
        List<Reservation> conflictingReservations = reservationRepository.conflictingReservations(
                equipement, startDate, endDate);

        if (!conflictingReservations.isEmpty()) {
            throw new IllegalArgumentException("Equipement is not available for the specified date range");
        }
    }
    private LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public List<Reservation> getRentalHistoryForEquipement(long equipementId) {
        return reservationRepository.findAllByEquipementIdOrderByStartDateAsc(equipementId);
    }

}
