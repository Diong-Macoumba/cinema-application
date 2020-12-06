package com.cine.gestionCinema.cinema.web;

import com.cine.gestionCinema.cinema.entities.Film;
import com.cine.gestionCinema.cinema.entities.Ticket;
import com.cine.gestionCinema.cinema.repositories.FilmRepositorie;
import com.cine.gestionCinema.cinema.repositories.TicketRepositorie;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class CinemaRestController {

    @Autowired
    private FilmRepositorie filmRepositorie;

    @Autowired
    private TicketRepositorie  ticketRepositorie;

   @GetMapping(path = "/imageFilm/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
   public byte[] imageFilm(@PathVariable(name = "id") Long id) throws IOException {
       Film film = filmRepositorie.findById(id).get();
       String photoFilm = film.getPhoto();
       File file = new File("C:/Users/Maczo/Pictures/images films/" + photoFilm + ".jpg");
       Path path = Paths.get(file.toURI());
       return Files.readAllBytes(path);
   }


   @PostMapping("/listTickets")
   public List<Ticket> ticketList(@RequestBody TicketForm ticketForm){
       List<Ticket> tickets = new ArrayList<>();
       ticketForm.getListIdTickets().forEach(idTicket -> {
           Ticket ticket = ticketRepositorie.findById(idTicket).get();
           ticket.setNomClient(ticketForm.getNomClient());
           ticket.setReserve(true);
           ticketRepositorie.save(ticket);
           tickets.add(ticket);
       });
       return tickets;
   }

   @Data
   class TicketForm{
       private String nomClient;
       private List<Long> listIdTickets;
   }
}
