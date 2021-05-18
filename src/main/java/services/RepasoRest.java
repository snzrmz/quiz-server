package services;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import daoimp.MazoDaoImp;
import daoimp.RepasoDaoImp;
import entities.Mazo;
import entities.Repaso;

@ApplicationScoped
@Path("jugadores/{id}/mazos/{nombreMazo}/repasos")
public class RepasoRest {
	@Inject
	private RepasoDaoImp repasoDAO;
	@Inject
	private MazoDaoImp mazoDAO;
	
	@GET
	@Produces(APPLICATION_JSON)
	public Response  getAllFrom(@PathParam("id") int idJugador, @PathParam("nombreMazo") String nombreMazo) {
		List<Repaso> repasos = repasoDAO.getAllFrom(nombreMazo, idJugador);
		if(repasos!=null) {
			return Response.ok(repasos).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@POST
	@Consumes(APPLICATION_JSON)
	public Response postRepaso(@PathParam("id") int idJugador, @PathParam("nombreMazo") String nombreMazo, Repaso repaso) {
		Mazo mazo = mazoDAO.getOne(idJugador, nombreMazo);
		Response.Status response = Response.Status.OK;
		if(mazo!=null) {
			repasoDAO.create(repaso);
		} else {
			response = Response.Status.NOT_FOUND;
		}
		
		if (response == Status.OK) {
			return Response.ok().build();
		} else {
			return Response.status(response).build();
		}
	}
}