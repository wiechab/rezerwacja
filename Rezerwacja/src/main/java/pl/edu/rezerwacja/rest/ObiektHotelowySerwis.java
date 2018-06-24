package pl.edu.rezerwacja.rest;


import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pl.edu.rezerwacja.api.ObiektHotelowy;
import pl.edu.rezerwacja.dao.ObiektHotelowyDao;
import pl.edu.rezerwacja.entities.Obiekt;

@Path("/obiekt")
public class ObiektHotelowySerwis implements ObiektHotelowy{
	
	private Logger log = Logger.getLogger("ObiektHotelowySerwis");
	
	@EJB
	private ObiektHotelowyDao obiektHotelowyDao;


	@Override

	@POST
	@Path("/dodaj")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response dodajObiekt(Obiekt obiekt) {
		// TODO Auto-generated method stub
		try {
			obiektHotelowyDao.create(obiekt);
		} catch (Exception e) {
			e.printStackTrace();
		}
			return Response.status(200).entity(obiekt).build();
	}

	@Override
	@PUT
	@Path("/modyfukuj")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response modyfikujObiekt(Obiekt obiekt) {
		Obiekt result = obiektHotelowyDao.update(obiekt);
		return Response.status(200).entity(result).build();
	
	}

	@Override
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response przegladajObiekt(@PathParam("id") Long id) {
		Obiekt result = obiektHotelowyDao.find(id);
		
		return Response.status(200).entity(result).build();
		
	}

	@Override
	@GET
	@Path("/szukaj/{miejscowosc}")
	public List<Obiekt> szukajObiektu(@PathParam("miejscowosc") String miejscowosc) {
		
		List<Obiekt> obiekty = obiektHotelowyDao.szukajPoMiejscowosci(miejscowosc);

		return obiekty;

		}


}
