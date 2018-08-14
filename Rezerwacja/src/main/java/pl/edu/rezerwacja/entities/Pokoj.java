package pl.edu.rezerwacja.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Entity implementation class for Entity: Pokoj
 *
 */
@Entity
@Table(name = "REZ_POKOJE")
@XmlRootElement
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
	@XmlAttribute
	public void setId(Long id) {
		this.id = id;
	}

	public Obiekt getObiekt() {
		return obiekt;
	}
	@XmlElement
	public void setObiekt(Obiekt obiekt) {
		this.obiekt = obiekt;
	}

	public String getNumer() {
		return numer;
	}
	@XmlElement
	public void setNumer(String numer) {
		this.numer = numer;
	}

	public KategoriaPokoju getKategoria() {
		return kategoria;
	}
	@XmlElement
	public void setKategoria(KategoriaPokoju kategoria) {
		this.kategoria = kategoria;
	}

	public int getKondygnacja() {
		return kondygnacja;
	}
	@XmlElement
	public void setKondygnacja(int kondygnacja) {
		this.kondygnacja = kondygnacja;
	}

	public String getOpis() {
		return opis;
	}
	@XmlElement
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	@Override
	public String toString() {
		return String.format(
				"Pokoj [id=%s, numer=%s, kategoria=%s, kondygnacja=%s, opis=%s]",
				id, numer, kategoria, kondygnacja, opis);
		/*
		return String.format(
				"Pokoj [id=%s, obiekt=%s, numer=%s, kategoria=%s, kondygnacja=%s, opis=%s]",
				id, obiekt, numer, kategoria, kondygnacja, opis);
				*/
	}
	
	public Pokoj() {
		super();
	}

   
}
