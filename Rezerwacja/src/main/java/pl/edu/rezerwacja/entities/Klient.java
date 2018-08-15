package pl.edu.rezerwacja.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: Klient
 *
 */

@Entity
@Table(name = "REZ_KLIENT")
@XmlRootElement
public class Klient implements Serializable {

	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "LOGIN", nullable = false, length = 10)
	private String login;
	

	@Column(name = "PASS", nullable = true, length = 10)
	private String pass;
	
	@Column(name = "NAZWISKO_NAZWA", nullable = false, length = 50)
	private String nazwiskoNazwa;
	
	@Column(name = "IMIE", nullable = true, length = 35)
	private String imie;
	
	@Column(name = "OSOBA_FIZ", nullable = false)
	private boolean osobaFiz;
	
	@Column(name = "ADRES", nullable = false, length = 350)
	private String adres;
	
	@Column(name = "ADRES_E_MAIL", nullable = false, length = 50)
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

	

	public String getImie() {
		return imie;
	}
	@XmlElement//(name = "IMIE") ten zakomentowany wpis bruzi
	public void setImie(String imie) {
		this.imie = imie;
	}


	public String getAdres() {
		return adres;
	}
	@XmlElement//(name = "adres")
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
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Pokoj [id=%s, nazwisko_nazwa = %s, imie=%s, adres=%s, login=%s]",
				id, nazwiskoNazwa, imie, adres, login);
	}
	/*
	public Klient() {
		super();
	}
	
	*/

	public String getNazwiskoNazwa() {
		return nazwiskoNazwa;
	}

	public void setNazwiskoNazwa(String nazwiskoNazwa) {
		this.nazwiskoNazwa = nazwiskoNazwa;
	}

	public boolean isOsobaFiz() {
		return osobaFiz;
	}

	public void setOsobaFiz(boolean osobaFiz) {
		this.osobaFiz = osobaFiz;
	}
   
}
