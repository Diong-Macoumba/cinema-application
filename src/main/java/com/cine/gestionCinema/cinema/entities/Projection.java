package com.cine.gestionCinema.cinema.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Projection implements Serializable {

    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idProjection;

    @Temporal(TemporalType.DATE)
    private Date dateProjection;
    private double prixProjection;

    @ManyToOne
    @JoinColumn(name = "Sal_Proj")
    private Salle salle;

    @ManyToOne
    @JoinColumn(name = "Film_Proj")
    private Film film;

    @OneToMany(mappedBy = "projection")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Ticket> tickets;

    @ManyToOne
    private Seance seance;
}
