package pl.edu.rezerwacja.api;

import javax.ws.rs.core.Response;

import pl.edu.rezerwacja.entities.Cennik;

//cennik będzie obowiązywał dla danej kategorii pokoju w danym sezonie, w danym obiekcie

public interface CennikHotelowy {

	public Response dodajCennik(Cennik cennik) ; //zwraca id
	
	public Response modyfikujCennik(Cennik cennik);  //dla id
	
	public void usunCennik(Long id);  //dla id
	
	public Response przegladajCennik(Long id);

	

}
