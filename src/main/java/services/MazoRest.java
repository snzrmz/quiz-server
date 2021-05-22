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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import daoimp.JugadorDaoImp;
import daoimp.MazoDaoImp;
import entities.Jugador;
import entities.Mazo;
import entities.MazoPK;

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
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createMazo(MazoPK mazopk) {
		Mazo mazo = new Mazo();
		mazo.setMazoPK(mazopk);
		mazoDAO.create(mazo);
		return Response.status(Response.Status.CREATED).build();
	}

	@Path("/{nombre}")
	@PUT
	@Consumes(APPLICATION_JSON)
	@Produces("application/json")
	public Response updateMazo(@PathParam("id") int idJugador, @PathParam("nombre") String nombreMazo) {
		Jugador jugador = jugadorDAO.getOne(idJugador);
		Response.Status response = Response.Status.OK;
		Mazo mazo = mazoDAO.getOne(idJugador, nombreMazo);
		if (jugador != null && mazo != null) {
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

	@Path("/{nombre}")
	@DELETE
	@Consumes(APPLICATION_JSON)
	public Response deleteMazo(@PathParam("id") int idJugador, @PathParam("nombre") String nombre) {
		Jugador jugador = jugadorDAO.getOne(idJugador);
		Response.Status response = Response.Status.OK;
		if (jugador != null) {
			Mazo mazo = mazoDAO.getOne(idJugador, nombre);
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
