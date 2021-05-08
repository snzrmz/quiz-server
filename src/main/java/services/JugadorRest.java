package services;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import daoimp.JugadorDaoImp;
import daoimp.MazoDaoImp;
import entities.Jugador;
import entities.Mazo;

@ApplicationScoped
@Path("/jugadores")
public class JugadorRest {
	@Inject
	private JugadorDaoImp jugadorDAO;
	@Inject
	private MazoDaoImp mazoDAO;

	@GET
	@Produces(APPLICATION_JSON)
	public List<Jugador> all() {
		return jugadorDAO.getJugadores();
	}

	@GET
	@Path("/{id}")
	@Produces(APPLICATION_JSON)
	public Response getById(@PathParam("id") int idJugador) {
		Response.Status responseStatus = Response.Status.OK;
		Jugador jugador = jugadorDAO.getJugadorById(idJugador);
		if (jugador != null)
			return Response.ok(jugador).build();
		else
			responseStatus = Response.Status.NOT_FOUND;
		return Response.status(responseStatus).build();
	}
	
	@GET
	@Path("/{id}/mazos")
	@Produces(APPLICATION_JSON)
	public Response getMazosOf(@PathParam("id") int idJugador) {
		Jugador jugador = jugadorDAO.getJugadorById(idJugador);
		List<Mazo> mazos = null;
		if (jugador != null) {
			//si existe el jugador retornamos sus mazos.
			 mazos = mazoDAO.getMazosFrom(jugador.getIdJugador());
		}			
		else
			return Response.status(Status.NOT_FOUND).build();
		return Response.ok(mazos).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(APPLICATION_JSON)
	public Response putUsuario(@PathParam("id") int idJugador, Jugador jugador) {
		//TODO
		Response.Status responseStatus = Response.Status.NOT_IMPLEMENTED;
		return Response.status(responseStatus).build();
	}

	@POST
	@Consumes(APPLICATION_JSON)
	public Response postUsuario(@Context UriInfo uriInfo, Jugador jugador) {
		//TODO
		Response.Status responseStatus = Response.Status.NOT_IMPLEMENTED;
		return Response.status(responseStatus).build();

	}

	@DELETE
	@Path("/{id}")
	public Response deleteUsuario(@PathParam("id") int idJugador) {
		//TODO
		Response.Status responseStatus = Response.Status.OK;
		return Response.status(responseStatus).build();
	}

}