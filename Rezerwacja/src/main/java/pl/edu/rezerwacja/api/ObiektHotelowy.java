package pl.edu.rezerwacja.api;



public interface ObiektHotelowy {

	public Long dodajObiekt(String nazwa, String miejscowosc, String adres) ; //zwraca id obiektu
	
	public void modyfikujObiekt(Long id); //dla id
	
	public void przegladajObiekt(Long id); //To samo co w modyfikuj ale bez możliwości edycji
	
	public void szukajObiektu(); //wg.kryteriów wyboru Lista na wejściu/wyjściu zwraca liste: ID/  Nazwa / lokalizacja / gwiazdki itp
	

}
