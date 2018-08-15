package pl.edu.rezerwacja.api;

import java.time.LocalDate;
import java.util.List;

import javax.ws.rs.core.Response;

import pl.edu.rezerwacja.entities.Pokoj;



public interface PokojHotelowy {

	public Response dodajPokoj(Pokoj pokoj) ;

	
	public Response modyfikujPokoj(Pokoj pokoj); //
	
	public void usunPokoj(Long id); //dla id
	
	public Response przegladajPokoj(Long id); //dla id pokoju
	
	
	public List<Pokoj> dajListePokoiObiektu(Long id); 
	
	public List<Pokoj> dajListePokoiObiektuKateg(Long id, String kategoria); 
	
	
	//public List<Pokoj> dajListeWolnychPokoi(Long id_obiektu, LocalDate dataOd, LocalDate dataDo); 

	//public List<Pokoj> dajListeWolnychPokoi(Long id_obiektu,  String kategoria, LocalDate dataOd, LocalDate dataDo);
	
}
