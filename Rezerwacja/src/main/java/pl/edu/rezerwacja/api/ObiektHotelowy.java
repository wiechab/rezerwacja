package pl.edu.rezerwacja.api;

import java.util.List;

import javax.ws.rs.core.Response;

import pl.edu.rezerwacja.entities.Obiekt;

public interface ObiektHotelowy {

	public Response dodajObiekt(Obiekt obiekt) ; 
	
	public Response modyfikujObiekt(Obiekt obiekt); 
	
	public Response przegladajObiekt(Long id); 
	
	public List<Obiekt> szukajObiektu(String miejscowosc); //wg.kryteriów wyboru Lista na wejściu/wyjściu zwraca liste: ID/  Nazwa / lokalizacja / gwiazdki itp



}
