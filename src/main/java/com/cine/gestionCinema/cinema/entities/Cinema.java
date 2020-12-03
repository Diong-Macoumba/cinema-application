package com.cine.gestionCinema.cinema.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Cinema implements Serializable {

    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idCinema;

    @Column(length = 50)
    private String nameCinema;
    private double longitude, lattitude, altitude;
    private int nombreSalles;

    @ManyToOne
    @JoinColumn(name = "Vi_Cine")
    private Ville ville;

    @OneToMany(mappedBy = "cinema")
    private Collection<Salle> salles;
}
