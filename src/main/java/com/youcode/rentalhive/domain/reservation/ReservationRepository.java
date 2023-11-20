package com.youcode.rentalhive.domain.reservation;

import com.youcode.rentalhive.domain.equipement.Equipement;
import com.youcode.rentalhive.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    public List<Reservation> findByEquipementIdAndUserId(Long equipement , Long user);

    @Query("SELECT r FROM Reservation r " +
            "WHERE r.equipement = :equipment " +
            "AND (:startDate BETWEEN r.startDate AND r.endDate OR :endDate BETWEEN r.startDate AND r.endDate)")
    List<Reservation> validateReservationDates(@Param("equipment") Equipement equipment,
                                                  @Param("startDate") Date startDate,
                                                  @Param("endDate") Date endDate);

    @Query("SELECT r FROM Reservation r " +
            "WHERE r.equipement = :equipment " +
            "AND (:endDate > r.startDate AND :startDate < r.endDate)")
    List<Reservation> conflictingReservations(@Param("equipment") Equipement equipment,
                                                  @Param("startDate") Date startDate,
                                                  @Param("endDate") Date endDate);
    public List<Reservation> findAllByEquipementIdOrderByStartDateAsc(Long equipementId);
}
