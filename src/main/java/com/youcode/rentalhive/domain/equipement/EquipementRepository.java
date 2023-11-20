package com.youcode.rentalhive.domain.equipement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement, Long>{
    public Equipement findByNameAndUuid(String name, UUID uuid);
}
