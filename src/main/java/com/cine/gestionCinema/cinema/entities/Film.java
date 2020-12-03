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
public class Film implements Serializable {

    @Id @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idFilm;

    @Column(length = 50)
    private String titreFilm;
    private double dureeFilm;

    @Column(length = 50)
    private String realisateur;

    @Column(length = 50)
    private String description;

    @Column(length = 50)
    private String photo;

    @Temporal(TemporalType.DATE)
    private Date dateSortieFilm;

    @OneToMany(mappedBy = "film")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Projection> projections;

    @ManyToOne
    @JoinColumn(name = "Film_Categ")
    private Categorie categorie;
}
