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
		Jugador jugador = jugadorDAO.getOne(idJugador);
		Response.Status response = Response.Status.OK;
		List<Mazo> mazos = null;
		if (jugador != null) {
			// si existe el jugador retornamos sus mazos.
			mazos = mazoDAO.getAll(idJugador);
		} else {
			response = Status.NOT_FOUND;
		}

		if (response == Status.OK) {
			return Response.ok(mazos).build();
		} else {
			return Response.status(response).build();
		}
	}
	
	@Path("/{nombre}")
	@GET
	@Produces(APPLICATION_JSON)
	public Response getMazo(@PathParam("id") int idJugador, @PathParam("nombre") String nombre) {
		Jugador jugador = jugadorDAO.getOne(idJugador);
		Response.Status response = Response.Status.OK;
		Mazo mazo = null;
		if (jugador != null) {
			mazo = mazoDAO.getOne(idJugador, nombre);
			if (mazo == null) {
				response = Status.NOT_FOUND;
			}
		} else {
			response = Status.NOT_FOUND;
		}

		if (response == Status.OK) {
			return Response.ok(mazo).build();
		} else {
			return Response.status(response).build();
		}
	}
	
	@POST
	@Consumes(APPLICATION_JSON)
	public Response createMazo(@PathParam("id") int idJugador, Mazo mazo) {
		Jugador jugador = jugadorDAO.getOne(idJugador);
		Response.Status response = Response.Status.OK;
		String nombreMazo = null;
		if (jugador!=null) {
			mazoDAO.create(mazo);
			if (nombreMazo == null) {
				response = Status.NOT_FOUND;
			}
		} else {
			response = Status.NOT_FOUND;
		}
		
		if (response == Status.OK) {
			return Response.ok(nombreMazo).build();
		} else {
			return Response.status(response).build();
		}
	}
	
	@PUT
	@Consumes(APPLICATION_JSON)
	public Response updateMazo(@PathParam("id") int idJugador, Mazo mazo) {
		Jugador jugador = jugadorDAO.getOne(idJugador);
		Response.Status response = Response.Status.OK;
		if (jugador != null) {
			mazoDAO.update(mazo);
		} else {
			response = Status.NOT_FOUND;
		}
		
		if (response == Status.OK) {
			return Response.ok().build();
		} else {
			return Response.status(response).build();
		}
	}
	
	@DELETE
	@Consumes(APPLICATION_JSON)
	public Response deleteMazo(@PathParam("id") int idJugador, Mazo mazo) {
		Jugador jugador = jugadorDAO.getOne(idJugador);
		Response.Status response = Response.Status.OK;
		if (jugador != null) {
			mazoDAO.delete(mazo);
		} else {
			response = Status.NOT_FOUND;
		}
		
		if (response == Status.OK) {
			return Response.ok().build();
		} else {
			return Response.status(response).build();
		}
	}
}
