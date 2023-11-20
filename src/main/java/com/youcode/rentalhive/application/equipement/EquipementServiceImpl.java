package com.youcode.rentalhive.application.equipement;

import com.youcode.rentalhive.domain.equipement.Equipement;
import com.youcode.rentalhive.domain.equipement.EquipementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


@Component
@RequiredArgsConstructor
public class EquipementServiceImpl implements EquipementService {

    private final EquipementRepository equipementRepository;



    @Override
    public Equipement save(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public List<Equipement> findAll() {
        return equipementRepository.findAll();
    }

    @Override
    public Equipement findByNameAndUuid(String name, UUID uuid) {
        return equipementRepository.findByNameAndPlateNumber(name, uuid);
    }
}
