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
public class Place implements Serializable {

    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idPlace;
    private int numPlace;
    private double longitude, lattitude, altitude;

    @ManyToOne
    @JoinColumn(name = "Pla_Sal")
    private Salle salle;

    @OneToMany(mappedBy = "place")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Ticket> tickets;

}
