package com.cine.gestionCinema.cinema.service;

import com.cine.gestionCinema.cinema.entities.*;
import com.cine.gestionCinema.cinema.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class ICinemaServiceImpl implements ICinemaService {

    @Autowired
    private VilleRepositorie villeRepositorie;

    @Autowired
    private CinemaRepositorie cinemaRepositorie;

    @Autowired
    private SalleRepositorie salleRepositorie;

    @Autowired
    private PlaceRepositorie placeRepositorie;

    @Autowired
    private SeanceRepositorie seanceRepositorie;

    @Autowired
    private CategorieRepositorie categorieRepositorie;

    @Autowired
    private FilmRepositorie filmRepositorie;

    @Autowired
    private ProjectionRepositorie projectionRepositorie;

    @Autowired
    private TicketRepositorie ticketRepositorie;

    @Override
    public void initVilles() {
        Stream.of("Dakar", "Fatick", "Seattle", "Manchester", "Paris").forEach(nomVille -> {
            Ville ville = new Ville();
            ville.setNameVille(nomVille);
            villeRepositorie.save(ville);
        });
    }

    @Override
    public void initCinema() {
        villeRepositorie.findAll().forEach(nomVille -> {
            Stream.of("Hollywood", "ParisWood", "CineCine", "GameFilm", "CineAction").forEach(nomCinema -> {
                Cinema cinema = new Cinema();
                cinema.setNameCinema(nomCinema);
                cinema.setVille(nomVille);
                cinema.setNombreSalles((int) (3 + Math.random()*8));
                cinemaRepositorie.save(cinema);
            });
        });
    }

    @Override
    public void initSalles() {
        cinemaRepositorie.findAll().forEach(nomCinema -> {
            for (int i = 0; i< nomCinema.getNombreSalles(); i++){
                Salle salle = new Salle();
                salle.setNameSalle("Salle" + (i + 1));
                salle.setCinema(nomCinema);
                salle.setNombrePlaces((int) (20 + Math.random()*15));
                salleRepositorie.save(salle);
            }
        });
    }

    @Override
    public void initPlaces() {
        salleRepositorie.findAll().forEach(nomSalle -> {
            for (int i = 0; i < nomSalle.getNombrePlaces(); i++ ) {
                Place place = new Place();
                place.setNumPlace(i + 1);
                place.setSalle(nomSalle);
                placeRepositorie.save(place);
            }
        });
    }

    @Override
    public void initSeances() {
        Stream.of("12:00", "15:00", "18:00", "21:00", "01:00").forEach(s -> {
            DateFormat dateFormat = new SimpleDateFormat("HH:mm");
            Seance seance = new Seance();
            try {
                seance.setHeureDebut(dateFormat.parse(s));
                seanceRepositorie.save(seance);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void initCategories() {
        Stream.of("Action", "Comedie", "Horreur", "Sport", "Fiction").forEach(cat -> {
            Categorie categorie =new Categorie();
            categorie.setNameCategorie(cat);
            categorieRepositorie.save(categorie);
        });
    }

    @Override
    public void initFilms() {
        Double[] durees = new Double[] {1.5, 2.5, 3.0, 2.4, 1.9};
        List<Categorie> categories = categorieRepositorie.findAll();
        Stream.of("angel of mine 2019","assieges 2020", "greenland le dernier refuge 2020", "intrigo samaria 2020", "joker 2019",
                  "la chute du president 2019", "mank 2020", "marraine ou presque 2020", "tenet 2020", "triple threat 2019",
                  "un tres mauvais plan 2020").forEach(nomfilm -> {
            Film film = new Film();
            film.setTitreFilm(nomfilm);
            film.setDureeFilm(durees[new Random().nextInt(durees.length)]);
            film.setPhoto(nomfilm);
            film.setCategorie(categories.get(new Random().nextInt(categories.size())));
            filmRepositorie.save(film);

        });
    }

    @Override
    public void initProjections() {
        Double[] prix = new Double[] {2500.0, 4000.0, 4500.0, 3000.0, 6250.0};
        List<Film> filmList = filmRepositorie.findAll();
        villeRepositorie.findAll().forEach(ville -> {
            cinemaRepositorie.findAll().forEach(cinema -> {
                salleRepositorie.findAll().forEach(salle -> {
                    int index = new Random().nextInt(filmList.size());
                        seanceRepositorie.findAll().forEach( seance -> {
                            Film film = filmList.get(index);
                            Projection projection = new Projection();
                            projection.setDateProjection(new Date());
                            projection.setPrixProjection(prix[new Random().nextInt(prix.length)]);
                            projection.setFilm(film);
                            projection.setSalle(salle);
                            projection.setSeance(seance);
                            projectionRepositorie.save(projection);

                    });
                });
            });
        });
    }

    @Override
    public void initTickets() {
        projectionRepositorie.findAll().forEach(projection -> {
            projection.getSalle().getPlaces().forEach(place -> {
                Ticket ticket = new Ticket();
                ticket.setPlace(place);
                ticket.setPrixTicket(projection.getPrixProjection());
                ticket.setProjection(projection);
                ticket.setReserve(false);
                ticketRepositorie.save(ticket);
            });
        });
    }
}
