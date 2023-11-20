package com.youcode.rentalhive.infrastructure.equipement;

import com.youcode.rentalhive.application.equipement.EquipementService;
import com.youcode.rentalhive.domain.equipement.Equipement;
import com.youcode.rentalhive.infrastructure.equipement.EquipementController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/equipements")
public class EquipementControllerImp implements EquipementController {

        private final EquipementService equipementService;

        @Autowired
        public EquipementControllerImp(EquipementService equipementService) {
            this.equipementService = equipementService;
        }

        @PostMapping("/save")
        public Equipement saveEquipement(@RequestBody Equipement equipement) {
            return equipementService.save(equipement);
        }

        @GetMapping
        public List<Equipement> getAllEquipements() {
            return equipementService.findAll();
        }

        @GetMapping("/{name}/{uuid}")
        public Equipement getEquipementByNameAndUuid(@PathVariable String name, @PathVariable UUID uuid) {
            return equipementService.findByNameAndUuid(name, uuid);
        }

}
