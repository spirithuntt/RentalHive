package com.youcode.rentalhive.application.equipement;

import com.youcode.rentalhive.domain.equipement.Equipement;
import com.youcode.rentalhive.domain.equipement.EquipementRepository;
import jakarta.validation.Valid;
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
        if (validateEquipement(equipement)) {
            return equipementRepository.save(equipement);
        }
        throw new IllegalArgumentException("Equipement is not valid");
    }

    @Override
    public List<Equipement> findAll() {
        return equipementRepository.findAll();
    }

    @Override
    public Equipement findByNameAndUuid(String name, UUID uuid) {
        if (isEquipementNameValid(name) &&
                isEquipementUuidValid(uuid)) {
            return equipementRepository.findByNameAndUuid(name, uuid);
        }
        throw new IllegalArgumentException("Equipement is not valid");
    }

    public boolean isEquipementNameValid(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        if (name.length() > 50) {
            throw new IllegalArgumentException("Name cannot be longer than 50 characters");
        }
        if (name.length() < 3) {
            throw new IllegalArgumentException("Name cannot be shorter than 3 characters");
        }
        return true;
    }
    public boolean isEquipementDailyRentalCostValid(Double dailyRentalCost) {
        if (dailyRentalCost == null) {
            throw new IllegalArgumentException("dailyRentalCost cannot be null");
        }
        if (dailyRentalCost < 0) {
            throw new IllegalArgumentException("dailyRentalCost cannot be negative");
        }
        return true;
    }
    public boolean isEquipementUuidValid(UUID uuid) {
        if (uuid == null) {
            throw new IllegalArgumentException("uuid cannot be null");
        }
        return true;
    }
    private boolean validateEquipement(Equipement equipement) {
        return isEquipementNameValid(equipement.getName()) &&
                isEquipementDailyRentalCostValid(equipement.getDailyRentalCost()) &&
                isEquipementUuidValid(equipement.getUuid());
    }

}
