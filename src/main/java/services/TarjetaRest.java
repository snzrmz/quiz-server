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

import daoimp.MazoDaoImp;
import daoimp.TarjetaDaoImp;
import entities.Mazo;
import entities.Tarjeta;

@ApplicationScoped
@Path("jugadores/{id}/mazos/{nombreMazo}/tarjetas")
public class TarjetaRest {
	@Inject
	private TarjetaDaoImp tarjetaDAO;
	@Inject
	private MazoDaoImp mazoDAO;

	@GET
	@Produces(APPLICATION_JSON)
	public Response getAllOfMazo(@PathParam("id") int idJugador, @PathParam("nombreMazo") String nombreMazo) {
		List<Tarjeta> tarjetas = tarjetaDAO.getAllOfMazo(nombreMazo, idJugador);
		if(tarjetas!=null) {
			return Response.ok(tarjetas).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@Path("/{idTarjeta}")
	@GET
	@Produces(APPLICATION_JSON)
	public Response getTarjetas(@PathParam("idTarjeta") int idTarjeta) {
		Tarjeta tarjeta = tarjetaDAO.getOne(idTarjeta);
		if(tarjeta!=null) {
			return Response.ok(tarjeta).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@POST
	@Consumes(APPLICATION_JSON)
	public Response postTarjeta(@PathParam("id") int idJugador, @PathParam("nombreMazo") String nombreMazo, Tarjeta tarjeta) {
		Mazo mazo = mazoDAO.getOne(idJugador, nombreMazo);
		Response.Status response = Response.Status.OK;
		if(mazo!=null) {
			tarjetaDAO.create(tarjeta);
		} else {
			response = Response.Status.NOT_FOUND;
		}
		
		if (response == Status.OK) {
			return Response.ok().build();
		} else {
			return Response.status(response).build();
		}
	}
	
	@PUT
	@Consumes(APPLICATION_JSON)
	public Response putTarjeta(@PathParam("id") int idJugador, @PathParam("nombreMazo") String nombreMazo, Tarjeta tarjeta) {
		Mazo mazo = mazoDAO.getOne(idJugador, nombreMazo);
		Response.Status response = Response.Status.OK;
		if(mazo!=null) {
			tarjetaDAO.update(tarjeta);
		} else {
			response = Response.Status.NOT_FOUND;
		}
		
		if (response == Status.OK) {
			return Response.ok().build();
		} else {
			return Response.status(response).build();
		}
	}
	
	@DELETE
	@Consumes(APPLICATION_JSON)
	public Response deleteTarjeta(@PathParam("id") int idJugador, @PathParam("nombreMazo") String nombreMazo, Tarjeta tarjeta) {
		Mazo mazo = mazoDAO.getOne(idJugador, nombreMazo);
		Response.Status response = Response.Status.OK;
		if(mazo!=null) {
			tarjetaDAO.delete(tarjeta);
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
