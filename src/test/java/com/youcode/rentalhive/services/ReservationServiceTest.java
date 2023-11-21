package com.youcode.rentalhive.services;

import com.youcode.rentalhive.application.reservation.ReservationServiceImpl;
import com.youcode.rentalhive.domain.reservation.Reservation;
import com.youcode.rentalhive.domain.reservation.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationServiceImpl reservationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void findAllReservations() {
        List<Reservation> reservations = Collections.singletonList(new Reservation());
        when(reservationRepository.findAll()).thenReturn(reservations);

        List<Reservation> result = reservationService.findAll();

        assertEquals(reservations, result);
        verify(reservationRepository, times(1)).findAll();
    }

    @Test
    void testGetRentalHistoryForEquipement() {
        long equipementId = 1L;
        List<Reservation> expectedReservations = Collections.singletonList(new Reservation());

        when(reservationRepository.findAllByEquipementIdOrderByStartDateAsc(equipementId))
                .thenReturn(expectedReservations);

        List<Reservation> result = reservationService.getRentalHistoryForEquipement(equipementId);

        assertEquals(expectedReservations, result);
        verify(reservationRepository, times(1)).findAllByEquipementIdOrderByStartDateAsc(equipementId);
    }
}
