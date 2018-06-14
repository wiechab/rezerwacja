package pl.edu.rezerwacja.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.interceptor.ExcludeClassInterceptors;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Query;

import pl.edu.rezerwacja.kernel.RequestTest;
import pl.edu.rezerwacja.entities.ObiektHotelowy;



@Stateless
public class ObiektHotelowyDao {
	private Logger log = Logger.getLogger("ObiektHotelowyDao");
	

	@PersistenceContext(unitName = "PolisaPU")
	private EntityManager em;

	@Inject
	private RequestTest requestTest;
	
	public ObiektHotelowyDao() {
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void create(ObiektHotelowy obiektHotelowy) {
		log.info("ObiektHotelowy przed persist");
		em.persist(obiektHotelowy);

		requestTest.add("Po odpaleniu");
		
		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ObiektHotelowy find(Long id) {
		EntityGraph<ObiektHotelowy> eg = (EntityGraph<ObiektHotelowy>) em.createEntityGraph(ObiektHotelowy.class);
		eg.addSubgraph("pokoje");
		eg.addSubgraph("cennik");
		Map hints = new HashMap<>();
		hints.put("javax.persistence.fetchgraph", eg);
		return em.find(ObiektHotelowy.class, id);
	}
	
	public ObiektHotelowy update(ObiektHotelowy obiekt) {
		System.out.println(em.contains(obiekt));
		return em.merge(obiekt);
	}

	
	public List<ObiektHotelowy> select (){
		Query query = em.createQuery("select o from ObiektHotelowy o");
		return query.getResultList();
	}
	
	@ExcludeClassInterceptors
	public ObiektHotelowy updateObiektHotelowyNazwa(Long id, String nazwa) {
		ObiektHotelowy updateObiektHotelowy = find(id);
		em.lock(updateObiektHotelowy, LockModeType.WRITE);
		updateObiektHotelowy.setNazwa(nazwa);
		return updateObiektHotelowy;
	}
	
	public ObiektHotelowy szukajPoNazwie(String nazwa) {
		Query query = em.createQuery(
				"select o from ObiektHotelowy o LEFT JOIN FETCH o.pokoje p LEFT JOIN o.cennik c where o.nazwa = ?1");
		query.setParameter(1, nazwa);
		return (ObiektHotelowy) query.getSingleResult();
	}

	public  List<ObiektHotelowy>  szukajPoMiejscowosci(String miejscowosc) {
		Query query = em.createQuery(
				"select o from ObiektHotelowy o LEFT JOIN FETCH o.pokoje p LEFT JOIN o.cennik c where o.miejscowosc = ?1");
		query.setParameter(1, miejscowosc);
		return query.getResultList();
	}
	
	@PrePersist
	private void beforeCreate(ObiektHotelowy object) {
		System.out.println("Walidacja ...." + object);
	}

	@PostLoad
	private void postLoad(ObiektHotelowy obiekt) {
		//obiekt.setPokoje(pokojeDao.pokojeObiektu(obiekt.getId()));
		obiekt.getCennik().size();
		System.out.println(obiekt);
	}

}
