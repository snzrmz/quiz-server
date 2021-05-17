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

import daoimp.TarjetaDaoImp;
import entities.Tarjeta;

@ApplicationScoped
@Path("jugadores/{id}/mazos/{nombreMazo}/tarjetas")
public class TarjetaRest {
	@Inject
	private TarjetaDaoImp tarjetaDAO;

	@GET
	@Produces(APPLICATION_JSON)
	public Response getAllOfMazo(@PathParam("id") int idJugador, @PathParam("nombreMazo") String nombreMazo) {
		List<Tarjeta> tarjetas = tarjetaDAO.getAllOfMazo(nombreMazo, idJugador);
		return Response.ok(tarjetas).build();
	}
	
	@Path("/{idTarjeta}")
	@GET
	@Produces
	public Response getTarjetas(@PathParam("id") int idJugador, @PathParam("nombreMazo") String nombreMazo, @PathParam("idTarjeta") int idTarjeta) {
		Tarjeta tarjeta = tarjetaDAO.getOne(idTarjeta);
		return Response.ok(tarjeta).build();
	}
}
