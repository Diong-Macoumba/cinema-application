package com.cine.gestionCinema.cinema.repositories;

import com.cine.gestionCinema.cinema.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TicketRepositorie extends JpaRepository<Ticket, Long> {
}
