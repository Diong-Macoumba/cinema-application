package com.cine.gestionCinema.cinema.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Ville implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVille;

    @Column(length = 50)
    private String nameVille;
    private double longitude, lattitude, altitude;

    @OneToMany(mappedBy = "ville")
    private Collection<Cinema> cinemas;
}
