package com.youcode.rentalhive.application.equipement;

import com.youcode.rentalhive.domain.equipement.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface EquipementService{
    public Equipement save(Equipement equipement);

    public List<Equipement> findAll();

    public Equipement findByNameAndPlateNumber(String name, UUID plateNumber);
}