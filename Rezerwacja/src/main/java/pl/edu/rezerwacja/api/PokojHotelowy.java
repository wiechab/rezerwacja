package pl.edu.rezerwacja.api;

import java.time.LocalDate;

public interface PokojHotelowy {

	//do obsługi okna KARTOTEKI
	
	public Long dodajPokoj() ; //zwraca id
	
	public void modyfikujPokoj(Long id); //
	
	public void usunPokoj(Long id); //dla id
	
	public void przegladajPokoj(Long id); //dla id pokoju
	
	//poniższe metody dotyczą danego OBIEKTU do obsługi okna KARTOTEKI
	
	public void dajListePokoiObiektu(Long id); // zwraca listę wszystkich pokoi dla id obiektu: id /numer / opis_skr/ status  itp
	
	public void dajListePokoiObiektuNaDzien(Long id, LocalDate data); //na GUI będą inaczej wyświetlone wolne / zarezerwowane 
	
	
	
}
