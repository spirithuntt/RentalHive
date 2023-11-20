package com.youcode.rentalhive.domain.reservation;

import com.youcode.rentalhive.domain.equipement.Equipement;
import com.youcode.rentalhive.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    public List<Reservation> findByEquipementIdAndUserId(Long equipement , Long user);

    public List<Reservation> findAllByEquipementIdOrderByStartDateAsc(Long equipementId);

}
