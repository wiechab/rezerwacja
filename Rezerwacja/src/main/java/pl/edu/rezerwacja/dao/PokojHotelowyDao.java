package pl.edu.rezerwacja.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pl.edu.rezerwacja.entities.Obiekt;
import pl.edu.rezerwacja.entities.Pokoj;
import pl.edu.rezerwacja.kernel.RequestTest;

@Stateless
public class PokojHotelowyDao {
	
	private Logger log = Logger.getLogger("PokojHotelowyDao");
	
	@Inject
	private RequestTest requestTest;

	@PersistenceContext(unitName = "Rezerwacja")
	private EntityManager em;
	
	public PokojHotelowyDao() {
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void create(Pokoj pokoj) {
		log.info("Pokoj przed persist");
		pokoj.setObiekt(em.find(Obiekt.class, pokoj.getObiekt().getId()));
		em.persist(pokoj);
		requestTest.add("Po odpaleniu");
		
	}
	

	public Pokoj update(Pokoj pokoj) {
		System.out.println(em.contains(pokoj));
		return em.merge(pokoj);
	}

	public Pokoj find(Long id) {
		return em.find(Pokoj.class, id);
	}
	
	public void usun(Long id) {
		em.remove(Pokoj.class);
	}

	@SuppressWarnings("unchecked")
	public List<Pokoj> pokojeObiektu (Long obiektId){
		Query query = em.createQuery("select p from Pokoj p where p.obiekt.id = ?1", Pokoj.class);
		query.setParameter(1, obiektId);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Pokoj> pokojeObiektuKategoria (Long obiektId, String kategoria){
		Query query = em.createQuery("select p from Pokoj p where p.obiekt.id = ?1 and p.kategoria =?2", Pokoj.class);
		query.setParameter(1, obiektId);
		query.setParameter(2, kategoria);
		return query.getResultList();
	}
	
}
