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

import pl.edu.rezerwacja.entities.Cennik;
import pl.edu.rezerwacja.entities.Obiekt;
import pl.edu.rezerwacja.kernel.RequestTest;

@Stateless
public class CennikHotelowyDao {
	
	private Logger log = Logger.getLogger("PokojHotelowyDao");
	
	@Inject
	private RequestTest requestTest;

	@PersistenceContext(unitName = "Rezerwacja")
	private EntityManager em;
	
	public CennikHotelowyDao() {
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void create(Cennik cennik) {
		log.info("Cennik przed persist");
		cennik.setObiekt(em.find(Obiekt.class, cennik.getObiekt().getId()));
		em.persist(cennik);
		requestTest.add("Cennik po odpaleniu");
		
	}
	
	public Cennik update(Cennik cennik) {
		System.out.println(em.contains(cennik));
		return em.merge(cennik);
	}

	public Cennik find(Long id) {
		return em.find(Cennik.class, id);
	}
	
	public void usun(Long id) {
		em.remove(Cennik.class);
	}
	@SuppressWarnings("unchecked")
	public List<Cennik> cennikObiektu (Long obiektId){
		Query query = em.createQuery("select c from Cennik c where c.obiekt.id = ?1", Cennik.class);
		query.setParameter(1, obiektId);
		return query.getResultList();
	}

}
