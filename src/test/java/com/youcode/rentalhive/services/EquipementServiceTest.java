package com.youcode.rentalhive.services ;

import com.youcode.rentalhive.application.equipement.EquipementServiceImpl;
import com.youcode.rentalhive.domain.equipement.Equipement;
import com.youcode.rentalhive.domain.equipement.EquipementRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EquipementServiceImplTest {

    @Mock
    private EquipementRepository equipementRepository;

    @InjectMocks
    private EquipementServiceImpl equipementService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void saveEquipement() {
        Equipement equipementToSave = new Equipement();
        when(equipementRepository.save(any(Equipement.class))).thenReturn(equipementToSave);
        Equipement savedEquipement = equipementService.save(equipementToSave);
        assertEquals(equipementToSave, savedEquipement);
        verify(equipementRepository, times(1)).save(equipementToSave);
    }

    @Test
    void findAllEquipements() {
        Equipement equipement1 = new Equipement();
        Equipement equipement2 = new Equipement();
        List<Equipement> equipements = Arrays.asList(equipement1, equipement2);
        when(equipementRepository.findAll()).thenReturn(equipements);

        List<Equipement> result = equipementService.findAll();

        assertEquals(equipements, result);
        verify(equipementRepository, times(1)).findAll();
    }

    @Test
    void findEquipementByNameAndUuid() {
        String equipementName = "SampleEquipement";
        UUID equipementUuid = UUID.randomUUID();
        Equipement expectedEquipement = new Equipement();
        when(equipementRepository.findByNameAndUuid(eq(equipementName), eq(equipementUuid)))
                .thenReturn(expectedEquipement);

        Equipement result = equipementService.findByNameAndUuid(equipementName, equipementUuid);

        assertEquals(expectedEquipement, result);
        verify(equipementRepository, times(1)).findByNameAndUuid(equipementName, equipementUuid);
    }
}
