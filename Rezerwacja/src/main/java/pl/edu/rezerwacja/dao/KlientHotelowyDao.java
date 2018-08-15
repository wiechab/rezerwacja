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

import pl.edu.rezerwacja.entities.Klient;
import pl.edu.rezerwacja.kernel.RequestTest;

@Stateless
public class KlientHotelowyDao {

	private Logger log = Logger.getLogger("KlientHotelowyDao");
	

	@PersistenceContext(unitName = "Rezerwacja")
	private EntityManager em;

	@Inject
	private RequestTest requestTest;
	
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void create(Klient klient) {
		log.info("Klient przed persist");
		em.persist(klient);

		requestTest.add("Po odpaleniu");
	
	}
	
	public Klient update(Klient klient) {
		System.out.println(em.contains(klient));
		return em.merge(klient);
	}
	

	public Klient find(Long id) {
		return em.find(Klient.class, id);
		
	}
	
	public void usun(Long id) {
		em.remove(Klient.class);		
	}

	public Klient daneKlientaLogin (String login){
		Query query = em.createQuery("select k from Klient k where k.login = ?1", Klient.class);
		query.setParameter(1, login);
		return (Klient) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Klient> daneKlientaNazwa (String nazwisko_nazwa){
		Query query = em.createQuery("select k from Klient k where k.nazwiskoNazwa = ?1", Klient.class);
		query.setParameter(1, nazwisko_nazwa);
		return query.getResultList();
	}

	
	@SuppressWarnings("unchecked")
	public List<Klient> listaKlientow (){
		Query query = em.createQuery("select k from Klient k", Klient.class);
		return query.getResultList();
	}
}
