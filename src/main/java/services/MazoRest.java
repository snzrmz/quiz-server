package services;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import daoimp.JugadorDaoImp;
import daoimp.MazoDaoImp;
import entities.Jugador;
import entities.Mazo;

@ApplicationScoped
@Path("jugadores/{id}/mazos")
public class MazoRest {
	@Inject
	private MazoDaoImp mazoDAO;
	@Inject
	private JugadorDaoImp jugadorDAO;
	
	@GET
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

}
