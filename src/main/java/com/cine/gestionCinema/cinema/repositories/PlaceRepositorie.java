package com.cine.gestionCinema.cinema.repositories;

import com.cine.gestionCinema.cinema.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PlaceRepositorie extends JpaRepository<Place, Long> {
}
