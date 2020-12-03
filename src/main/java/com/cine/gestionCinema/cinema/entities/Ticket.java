package com.cine.gestionCinema.cinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Ticket implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;

    @Column(length = 50)
    private String nomClient;
    private double prixTicket;
    private int codePayement;
    private Boolean reserve;

    @ManyToOne
    @JoinColumn(name = "Proj_Tick")
    private Projection projection;

    @ManyToOne
    @JoinColumn(name = "Pla_tick")
    private Place place;
}
