package com.cine.gestionCinema.cinema.repositories;

import com.cine.gestionCinema.cinema.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("http://localhost:4200")
public interface SeanceRepositorie extends JpaRepository<Seance, Long> {
}
