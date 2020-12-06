package com.cine.gestionCinema.cinema.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

@Projection(name = "p1", types = {com.cine.gestionCinema.cinema.entities.Projection.class})
public interface FilmProjection {

     Long getIdProjection();
     Date getDateProjection();
     double getPrixProjection();
     Salle getSalle();
     Film getFilm();
     Collection<Ticket> listTickets();
     Seance getSeance();


}
