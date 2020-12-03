package com.cine.gestionCinema.cinema;

import com.cine.gestionCinema.cinema.service.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CinemaApplication implements CommandLineRunner {

	//@Autowired
	//private ICinemaService iCinemaService;

	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*	iCinemaService.initVilles();
		iCinemaService.initCinema();
		iCinemaService.initSalles();
		iCinemaService.initPlaces();
		iCinemaService.initSeances();
		iCinemaService.initCategories();
		iCinemaService.initFilms();
		iCinemaService.initProjections();
		iCinemaService.initTickets();  */
	}
}
