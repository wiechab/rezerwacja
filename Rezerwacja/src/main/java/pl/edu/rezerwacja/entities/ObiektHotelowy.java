package pl.edu.rezerwacja.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: ObiektHotelowy
 *
 */
@Entity
@Table(name = "REZ_OBIEKT_HOTELOWY")
public class ObiektHotelowy implements Serializable {

	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "NAZWA", nullable = false, length = 35)
	private String nazwa;

	@Column(name = "MIEJSCOWOSC", nullable = false, length = 50)
	private String miejscowosc;
	
	@Column(name = "ADRES", nullable = false, length = 350)
	private String adres;
	
	@Column(name = "KATEGORIA", nullable = false, length = 15)
	@Enumerated(EnumType.STRING)
	private KategoriaObiektu kategoria;
	
	@Column(name = "ADRES_E_MAIL", nullable = true, length = 30)
	private String adres_e_mail;
	
	@Column(name = "TELEFON", nullable = true, length = 30)
	private String telefon;
	
	@Column(name = "OPIS", nullable = true, length = 250)
	private String opis;
	
	@OneToMany(mappedBy = "obiekt", fetch = FetchType.LAZY)
	private List<Pokoj> pokoje;

	@OneToMany(mappedBy = "obiekt", fetch = FetchType.LAZY)
	private List<Cennik> cennik;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNazwa() {
		return nazwa;
	}


	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}


	public String getMiejscowosc() {
		return miejscowosc;
	}


	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}


	public String getAdres() {
		return adres;
	}


	public void setAdres(String adres) {
		this.adres = adres;
	}


	public KategoriaObiektu getKategoria() {
		return kategoria;
	}


	public void setKategoria(KategoriaObiektu kategoria) {
		this.kategoria = kategoria;
	}


	public String getOpis() {
		return opis;
	}


	public void setOpis(String opis) {
		this.opis = opis;
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


	public List<Pokoj> getPokoje() {
		return pokoje;
	}


	public void setPokoje(List<Pokoj> pokoje) {
		this.pokoje = pokoje;
	}


	public List<Cennik> getCennik() {
		return cennik;
	}


	public void setCennik(List<Cennik> cennik) {
		this.cennik = cennik;
	}
   
/*
	public ObiektHotelowy() {
		super();
	}
	*/
}
