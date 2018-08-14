package pl.edu.rezerwacja.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: Pokoj
 *
 */
@Entity
@Table(name = "REZ_POKOJE")
public class Pokoj implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "ID_OBIEKT", foreignKey = @ForeignKey(name = "FK_POKOJ_TO_OBJEKT"))
	private Obiekt obiekt;

	@Column(name = "NUMER", nullable = false, length = 10)
	private String numer;
	
	//w kategorii zawarta ilość osób
	
	@Column(name = "KATEGORIA", nullable = false, length = 15)
	@Enumerated(EnumType.STRING)
	private KategoriaPokoju kategoria;
	
	@Column(name = "KONDYGNACJA")
	private int kondygnacja;
	
	@Column(name = "OPIS")
	private String opis;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Obiekt getObiekt() {
		return obiekt;
	}

	public void setObiekt(Obiekt obiekt) {
		this.obiekt = obiekt;
	}

	public String getNumer() {
		return numer;
	}

	public void setNumer(String numer) {
		this.numer = numer;
	}

	public KategoriaPokoju getKategoria() {
		return kategoria;
	}

	public void setKategoria(KategoriaPokoju kategoria) {
		this.kategoria = kategoria;
	}

	public int getKondygnacja() {
		return kondygnacja;
	}

	public void setKondygnacja(int kondygnacja) {
		this.kondygnacja = kondygnacja;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	/*
	public Pokoj() {
		super();
	}
	*/
   
}
