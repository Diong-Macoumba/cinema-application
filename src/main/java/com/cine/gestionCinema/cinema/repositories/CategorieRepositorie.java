package com.cine.gestionCinema.cinema.repositories;

import com.cine.gestionCinema.cinema.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategorieRepositorie extends JpaRepository<Categorie, Long> {
}
