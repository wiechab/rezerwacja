package pl.edu.rezerwacja.api;

import pl.edu.rezerwacja.entities.Klient;

import java.util.List;

import javax.ws.rs.core.Response;

public interface KlientHotelowy {

	public Response dodajKlienta(Klient klient) ; 
	
	public Response modyfikujDaneKlienta(Klient klient);  
	
	public void usunKlienta(Long id);  //dla id
	
	public Response przegladajDaneKlienta(Long id);
	
	public Response szukajKlienta(String nazwisko_nazwa);
	
	public List<Klient> dajListeKlientow(); 
	

}
