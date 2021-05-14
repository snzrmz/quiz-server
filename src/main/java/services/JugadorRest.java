package services;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.net.URI;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import daoimp.JugadorDaoImp;
import entities.Jugador;

@ApplicationScoped
@Path("/jugadores/{id}")
public class JugadorRest {
	@Inject
	private JugadorDaoImp jugadorDAO;

	@GET
	@Produces(APPLICATION_JSON)
	public Response getById(@PathParam("id") int idJugador) {
		Response.Status responseStatus = Response.Status.OK;
		Jugador jugador = jugadorDAO.getOne(idJugador);
		if (jugador != null)
			return Response.ok(jugador).build();
		else
			responseStatus = Response.Status.NOT_FOUND;
		return Response.status(responseStatus).build();
	}

	@PUT
	@Consumes(APPLICATION_JSON)
	public Response putUsuario(@PathParam("id") int idJugador, Jugador jugador) {
		Response.Status responseStatus = Response.Status.OK;
		jugadorDAO.update(jugador);
		return Response.status(responseStatus).build();
	}

	@POST
	@Consumes(APPLICATION_JSON)
	public Response postUsuario(@Context UriInfo uriInfo, Jugador jugador) {

		int idJugador = jugadorDAO.create(jugador);

		if (idJugador!=-1) {
			UriBuilder uriBuilder = uriInfo.getRequestUriBuilder();
			URI uri = uriBuilder.path(Integer.toString(idJugador)).build();
			return Response.created(uri).build();
		}
		else {
			Response.Status responseStatus = Response.Status.NOT_FOUND;
			return Response.status(responseStatus).build();
		}
		
	}

}