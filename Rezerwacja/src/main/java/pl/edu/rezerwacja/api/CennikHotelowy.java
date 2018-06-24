package pl.edu.rezerwacja.api;

//cennik będzie obowiązywał dla danej kategorii pokoju w danym sezonie, w danym obiekcie

public interface CennikHotelowy {

	public Long dodajCennik(Long id_obiektu, int rok, String sezon) ; //zwraca id
	
	public void modyfikujCennik(Long id);  //dla id
	
	public void usunCennik(Long id);  //dla id
	
	public void przegladajCennik(Long id);
	

}
