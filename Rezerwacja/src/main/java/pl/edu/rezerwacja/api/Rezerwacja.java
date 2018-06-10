package pl.edu.rezerwacja.api;

import java.time.LocalDate;

//Założenia
//1 Rezerwacja dot. 1 Klienta i 1 Obiektu w danym, ciągłym przedziale dat od..do
//Rezerwacja może obejmować wiele pokoi, ale w 1 obiekcie
//Żeby nie komplikować cennik sezonowy dla kategori pokoju

public interface Rezerwacja {

	public Long zarejestrujRezerwacje(Long id_klienta, Long id_obiektu, Long id_pokoju, LocalDate dataOd, LocalDate dataDo) ; //zwraca id rez Long id_pokoju - tu ma być LISTA
	
	public void modyfikujRezerwacje(Long id);
	
	public void anulujRezerwacje(Long id);
	
	public void przegladajRezerwacje(Long id); //To samo co w modyfikuj ale bez możliwości edycji
	
	public void dajListeRezerwacjiObiektu(Long id); //dla id obiektu
	
	public void dajListeRezerwacjiPokoju(Long id); //dla id pokoju
	
	public void dajListeRezerwacjiKlienta(Long id); //dla id klienta
	
	//to szukanie dotyczy pokojów w wielu obiektach - obsługa okna REZERWACJI
	
	public void szukajWolnegoPokoju(LocalDate dataOd, LocalDate dataDo); //wg.kryteriów wyboru Lista na wejściu/wyjściu; zwraca liste: id / obiekt /numer / opis_skr/ status  itp

	public void szukajWolnegoPokojuWObiekcie(Long ObjectID, LocalDate dataOd, LocalDate dataDo); //wg.kryteriów wyboru Lista na wejściu/wyjściu; zwraca liste: id /numer / opis_skr/ status  itp
		
	 	
}
