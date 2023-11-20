package com.youcode.rentalhive.domain.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.youcode.rentalhive.domain.equipement.Equipement;
import com.youcode.rentalhive.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "start_date" )
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;


    @Column(name = "end_date" )
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    private double cost;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "equipement_id")
    private Equipement equipement;
}
