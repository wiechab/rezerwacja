package pl.edu.rezerwacja.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Entity implementation class for Entity: ObiektHotelowy
 *
 */
@Entity
@Table(name = "RE_OBIEKT_HOTELOWY")
public class ObiektHotelowy implements Serializable {

	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "NAZWA", nullable = false, length = 35)
	private String nazwa;

	@Column(name = "MIEJSCOWOSC", nullable = false, length = 50)
	private String miejscowosc;
	
	@Column(name = "ADRES", nullable = false, length = 250)
	private String adres;
	
	@Column(name = "KATEGORIA", nullable = false, length = 15)
	@Enumerated(EnumType.STRING)
	private KategoriaObiektu kategoria;

	

	public ObiektHotelowy() {
		super();
	}
   
}
