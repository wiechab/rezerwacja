package pl.edu.rezerwacja.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cennik
 *
 */
@Entity
@Table(name = "REZ_CENNIK")
public class Cennik implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "ID_OBIEKT", foreignKey = @ForeignKey(name = "FK_CENNIK_TO_OBJEKT"))
	private ObiektHotelowy obiekt;
	
	@Column(name = "KATEGORIA", nullable = false, length = 15)
	@Enumerated(EnumType.STRING)
	private KategoriaPokoju kategoria;
	
	@Column(name = "ROK", nullable = false )
	private int rok;
	
	@Column(name = "SEZON", nullable = false, length = 15)
	@Enumerated(EnumType.STRING)
	private Sezon sezon;
	
	@Column(name = "CENA", nullable = false )
	private BigDecimal cena;
	

	/*
	public Cennik() {
		super();
	}
	*/
   
}
