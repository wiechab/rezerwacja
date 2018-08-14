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

	import pl.edu.rezerwacja.api.CennikHotelowy;

	import pl.edu.rezerwacja.dao.CennikHotelowyDao;
	import pl.edu.rezerwacja.entities.Cennik;

	@Path("/cennik")

	public class CennikHotelowySerwis implements CennikHotelowy{
		
		@EJB
		private CennikHotelowyDao cennikHotelowyDao;

	

		@Override
		@POST
		@Path("/dodaj")
		@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
		public Response dodajCennik(Cennik cennik) {
			try {
				cennikHotelowyDao.create(cennik);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return Response.status(200).entity(cennik.getId()).build();
			//return Response.status(200).entity(cennik).build(); //to nie działa, trzeba zrobić innego builda
		}
		

		@Override
		@PUT
		@Path("/modyfikuj")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Response modyfikujCennik(Cennik cennik) {
			// TODO Auto-generated method stub
			cennikHotelowyDao.update(cennik);
			return Response.status(200).entity(cennik.getId()).build();
			
		}

		@Override
		@DELETE
		@Path("/usun/{id}")
		public void usunCennik(@PathParam("id") Long id) {
			// TODO Auto-generated method stub
			
		}

		// podaję id obiektu
		
		@Override
		@GET
		@Path("/przegladaj/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public Response przegladajCennik(@PathParam("id") Long id ) {
			// TODO Auto-generated method stub
			List<Cennik> result = cennikHotelowyDao.cennikObiektu(id);
			return Response.status(200).entity(result).build();
		}


	}

