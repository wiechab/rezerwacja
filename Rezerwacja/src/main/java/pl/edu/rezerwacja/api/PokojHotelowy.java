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
	
	//poniższe metody dotyczą danego OBIEKTU do obsługi okna KARTOTEKI
	
	public List<Pokoj> dajListePokoiObiektu(Long id); // zwraca listę wszystkich pokoi dla id obiektu: id /numer / opis_skr/ status  itp
	
	public List<Pokoj> dajListePokoiObiektuKateg(Long id, String kategoria); // zwraca listę wszystkich pokoi dla id obiektu: id /numer / opis_skr/ status  itp
	
	public void dajListePokoiObiektuNaDzien(Long id, LocalDate data); //na GUI będą inaczej wyświetlone wolne / zarezerwowane 
	
	
	
}
