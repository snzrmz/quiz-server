package services;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import daoimp.JugadorDaoImp;
import entities.Jugador;

@ApplicationScoped
@Path("/login/{email}")
public class JugadorLoginRest {
	@Inject
	private JugadorDaoImp jugadorDAO;
	
	@GET
	@Produces(APPLICATION_JSON)
	public Response getByEmail(@PathParam("email") String email) {
		Response.Status responseStatus = Response.Status.OK;
		Jugador jugador = jugadorDAO.getOneByEmail(email);
		if (jugador != null)
			return Response.ok(jugador).build();
		else
			responseStatus = Response.Status.NOT_FOUND;
		return Response.status(responseStatus).build();
	}
}
