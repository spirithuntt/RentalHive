package com.youcode.rentalhive.domain.reservation;

import com.youcode.rentalhive.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    public Reservation findByIdAndUserEquals(Long id , User userId);

}
