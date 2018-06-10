package pl.edu.rezerwacja.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Klient
 *
 */

@Entity
@Table(name = "REZ_KLIENT")
public class Klient implements Serializable {

	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "LOGIN", nullable = false, length = 10)
	private String login;
	
	@Column(name = "NAZWISKO_NAZWA", nullable = false, length = 10)
	private String nazwisko_nazwa;
	
	@Column(name = "IMIE", nullable = true, length = 10)
	private String imie;
	
	@Column(name = "OSOBA_FIZ", nullable = false)
	private boolean osoba_fiz;
	
	@Column(name = "ADRES", nullable = false, length = 350)
	private String adres;
	
	@Column(name = "ADRES_E_MAIL", nullable = false, length = 30)
	private String adres_e_mail;
	
	@Column(name = "TELEFON", nullable = true, length = 30)
	private String telefon;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNazwisko_nazwa() {
		return nazwisko_nazwa;
	}

	public void setNazwisko_nazwa(String nazwisko_nazwa) {
		this.nazwisko_nazwa = nazwisko_nazwa;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public boolean isOsoba_fiz() {
		return osoba_fiz;
	}

	public void setOsoba_fiz(boolean osoba_fiz) {
		this.osoba_fiz = osoba_fiz;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getAdres_e_mail() {
		return adres_e_mail;
	}

	public void setAdres_e_mail(String adres_e_mail) {
		this.adres_e_mail = adres_e_mail;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	
	/*
	public Klient() {
		super();
	}
	
	*/
   
}
