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
import pl.edu.rezerwacja.entities.Obiekt;



@Stateless
public class ObiektHotelowyDao {
	private Logger log = Logger.getLogger("ObiektHotelowyDao");
	

	@PersistenceContext(unitName = "Rezerwacja")
	private EntityManager em;

	@Inject
	private RequestTest requestTest;
	

	@Inject
	private PokojHotelowyDao pokojHotelowyDao;
	
	public ObiektHotelowyDao() {
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void create(Obiekt obiekt) {
		log.info("Obiekt przed persist");
		em.persist(obiekt);

		requestTest.add("Po odpaleniu");
	
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Obiekt find(Long id) {
		EntityGraph<Obiekt> eg = (EntityGraph<Obiekt>) em.createEntityGraph(Obiekt.class);
		eg.addSubgraph("pokoje");
		eg.addSubgraph("cennik");
		Map hints = new HashMap<>();
		hints.put("javax.persistence.fetchgraph", eg);
		return em.find(Obiekt.class, id);
	}
	
	public Obiekt update(Obiekt obiekt) {
		System.out.println(em.contains(obiekt));
		return em.merge(obiekt);
	}

	@SuppressWarnings("unchecked")
	public List<Obiekt> listaObiektow (){
		Query query = em.createQuery("select o from Obiekt o");
		return query.getResultList();
	}
	
	@ExcludeClassInterceptors
	public Obiekt updateObiektHotelowyNazwa(Long id, String nazwa) {
		Obiekt updateObiektHotelowy = find(id);
		em.lock(updateObiektHotelowy, LockModeType.WRITE);
		updateObiektHotelowy.setNazwa(nazwa);
		return updateObiektHotelowy;
	}
	
	
	public Obiekt szukajPoNazwie(String nazwa) {
		Query query = em.createQuery(
				//"select o from Obiekt o where o.nazwa = ?1");
				"select o from Obiekt o LEFT JOIN FETCH o.pokoje p LEFT JOIN o.cennik c where o.nazwa = ?1");
		query.setParameter(1, nazwa);
		return (Obiekt) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public  List<Obiekt>  szukajPoMiejscowosci(String miejscowosc) {
		Query query = em.createQuery(
				"select o from Obiekt o where o.miejscowosc = ?1");
				//"select o from Obiekt o LEFT JOIN FETCH o.pokoje p LEFT JOIN o.cennik c where o.miejscowosc = ?1");
		query.setParameter(1, miejscowosc);
		query.getResultList().forEach(System.out::println);
		return query.getResultList();
	}
	
	@PrePersist
	private void beforeCreate(Obiekt object) {
		System.out.println("Walidacja ...." + object);
	}

	@PostLoad
	private void postLoad(Obiekt obiekt) {
		obiekt.setPokoje(pokojHotelowyDao.pokojeObiektu(obiekt.getId()));
		//obiekt.getCennik().size();
		System.out.println(obiekt);
	}

}
