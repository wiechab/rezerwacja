package pl.edu.rezerwacja.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import pl.edu.rezerwacja.api.KlientHotelowy;
import pl.edu.rezerwacja.dao.KlientHotelowyDao;
import pl.edu.rezerwacja.entities.Klient;


@Path("/klient")
public class KlientHotelowySerwis implements KlientHotelowy{
	
	
	
	@EJB
	private KlientHotelowyDao klientHotelowyDao;

	@Override
	@POST
	@Path("/dodaj")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response dodajKlienta(Klient klient) {
		// TODO Auto-generated method stub
		try {
			klientHotelowyDao.create(klient);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//return Response.status(200).entity(klient.getId()).build();
		return Response.status(200).entity(klient).build(); 
	}

	@Override
	@PUT
	@Path("/modyfikuj")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response modyfikujDaneKlienta(Klient klient) {
		// TODO Auto-generated method stub
		klientHotelowyDao.update(klient);
		return Response.status(200).entity(klient.getId()).build();
	}

	@Override
	@DELETE
	@Path("/usun/{id}")
	public void usunKlienta(@PathParam(value = "id") Long id)  {
		// TODO Auto-generated method stub
		klientHotelowyDao.usun(id);
	}

	@Override
	@GET
	@Path("/szukaj/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response przegladajDaneKlienta(@PathParam(value = "id") Long id) {
		// TODO Auto-generated method stub
		Klient result = klientHotelowyDao.find(id);
		return Response.status(200).entity(result).build();
	}

	@Override
	@GET
	@Path("/dane/login/{login}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response daneKlienta(@PathParam(value = "login") String login) {
		// TODO Auto-generated method stub
		Klient result = klientHotelowyDao.daneKlientaLogin(login);
		return Response.status(200).entity(result).build();
	}

	@Override
	@GET
	@Path("/dane/nazwa/{nazwisko_nazwa}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response szukajKlienta(@PathParam(value = "login") String nazwisko_nazwa) {
		// TODO Auto-generated method stub
		List<Klient> result = klientHotelowyDao.daneKlientaNazwa (nazwisko_nazwa);
		return Response.status(200).entity(result).build();
	}

	@Override
	@GET
	@Path("/lista")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Klient> dajListeKlientow() {
		// TODO Auto-generated method stub
		List<Klient> klienci = klientHotelowyDao.listaKlientow();
		return klienci;
	}

}
