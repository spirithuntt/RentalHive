package com.youcode.rentalhive.infrastructure.equipement;

import com.youcode.rentalhive.domain.equipement.Equipement;

import java.util.List;
import java.util.UUID;

public interface EquipementController {

    Equipement saveEquipement(Equipement equipement);

    List<Equipement> getAllEquipements();

    Equipement getEquipementByNameAndUuid(String name, UUID uuid);

}
