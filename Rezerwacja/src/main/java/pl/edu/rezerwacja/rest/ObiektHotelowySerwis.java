package pl.edu.rezerwacja.rest;

import java.util.logging.Logger;

import javax.ws.rs.Path;

import pl.edu.rezerwacja.api.ObiektHotelowy;
@Path("/rezerwacja/obiekt")
public class ObiektHotelowySerwis implements ObiektHotelowy{
	
	private Logger log = Logger.getLogger("ObiektHotelowySerwis");

	@Override
	public Long dodajObiekt(String nazwa, String miejscowosc, String adres) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modyfikujObiekt(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void przegladajObiekt(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void szukajObiektu() {
		// TODO Auto-generated method stub
		
	}

}
