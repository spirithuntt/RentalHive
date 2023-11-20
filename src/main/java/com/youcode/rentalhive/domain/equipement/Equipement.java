package com.youcode.rentalhive.domain.equipement;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.youcode.rentalhive.domain.equipement.Equipement;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.UUID;

@Data
@Entity
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;


    @NotNull(message = "dailyRentalCost cannot be null")
    @NotBlank(message = "dailyRentalCost cannot be blank")
    @Pattern(regexp = "^[0-9]+(\\.[0-9]{1,2})?$", message = "dailyRentalCost must be a number with 2 decimal places")
    @Column(name = "daily_rental_cost")
    private Double dailyRentalCost;

    private UUID uuid;

    private EquipementStatus status;

}
