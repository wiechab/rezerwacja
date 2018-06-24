package pl.edu.rezerwacja.api;

public interface KlientHotelowy {

	public Long dodajKlienta() ; //zwraca id
	
	public void modyfikujDaneKlienta(Long id);  //dla id
	
	public void usunKlienta(Long id);  //dla id
	
	public void przegladajDaneKlienta(Long id);
	
	public void szukajKlienta();
	
	public void dajListeKlientow(); 
	

}
