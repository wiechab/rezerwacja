package pl.edu.rezerwacja.rest;

import java.time.LocalDate;
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

import pl.edu.rezerwacja.api.PokojHotelowy;
import pl.edu.rezerwacja.dao.PokojHotelowyDao;
import pl.edu.rezerwacja.entities.Pokoj;

@Path("/pokoj")

public class PokojHotelowySerwis implements PokojHotelowy{
	
	@EJB
	private PokojHotelowyDao pokojHotelowyDao;

	@Override
	@POST
	@Path("/dodaj")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response dodajPokoj(Pokoj pokoj) { 
		try {
		pokojHotelowyDao.create(pokoj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(pokoj.toString()); //to działa
		return Response.status(200).entity(pokoj.getNumer() ).build();
		//return Response.status(200).entity("kat:" + pokoj.getKategoria() + "opis:" +  pokoj.getOpis() ).build(); //Unexpected 'k'
		//return Response.status(200).entity(pokoj.toString()).build(); //teraz ma Unexpected 'P', trzeba chyba zbudować mu Jsona
		//return Response.status(200).entity(pokoj.getKategoria() ).build();//pojedyncze działają //pokoj.getKategoria() getId()
		//return Response.status(200).entity(pokoj.toString()).build();// to nie działa 
		//return Response.status(200).entity(pokoj).build(); //to nie działa
	}
	

	@Override
	@PUT
	@Path("/modyfikuj")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response modyfikujPokoj(Pokoj pokoj) {
		Pokoj result = pokojHotelowyDao.update(pokoj);
		return Response.status(200).entity(result).build();
		
	}

	@Override
	@DELETE
	@Path("/usun/{id}")
	public void usunPokoj(@PathParam(value = "id") Long id) {
		pokojHotelowyDao.usun(id);
		
	}

	@Override
	@GET
	@Path("/przegladaj/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response przegladajPokoj(@PathParam(value = "id") Long id){
		Pokoj result = pokojHotelowyDao.find(id);
		return Response.status(200).entity(result).build();
		
	}

	
	@Override
	@GET
	@Path("/szukaj/{idObiektu}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pokoj> dajListePokoiObiektu(@PathParam(value = "idObiektu") Long id) {
		List<Pokoj> pokoje = pokojHotelowyDao.pokojeObiektu(id);
		return pokoje;
	}

	@Override
	@GET
	@Path("/obiekt/{idObiektu}/kategoria/{kategoria}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pokoj> dajListePokoiObiektuKateg(@PathParam("idObiektu") Long id,
			@PathParam("kategoria") String kategoria) {
		List<Pokoj> pokoje = pokojHotelowyDao.pokojeObiektuKategoria(id, kategoria);
		return pokoje;
	}
	

/*
	@Override
	@GET
	@Path("/obiekt/{idObiektu}/daty/{dataOd} {dataDo}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pokoj> dajListeWolnychPokoi(@PathParam("idObiektu") Long id_obiektu, 
			@PathParam("dataOd") LocalDate dataOd, @PathParam("dataDo") LocalDate dataDo) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@GET
	@Path("/obiekt/{idObiektu}/kategoria/{kategoria}/daty/{dataOd} {dataDo}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pokoj> dajListeWolnychPokoi(@PathParam("idObiektu") Long id_obiektu,
			@PathParam("kategoria") String kategoria, 
			@PathParam("dataOd") LocalDate dataOd, @PathParam("dataDo") LocalDate dataDo) {
		// TODO Auto-generated method stub
		return null;
	}
*/

}
