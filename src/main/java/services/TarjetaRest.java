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
@Path("jugadores/{id}/mazos/")
public class TarjetaRest {
	@Inject
	private TarjetaDaoImp tarjetaDAO;

	@Path("tarjetas")
	@GET
	@Produces(APPLICATION_JSON)
	public Response getAllFrom(@PathParam("id") int idJugador) {
	
		List<Tarjeta> tarjetas = tarjetaDAO.getTarjetasFrom(idJugador);
		return Response.ok(tarjetas).build();
	}
	
	@Path("/{nombreMazo}/tarjetas")
	@GET
	@Produces(APPLICATION_JSON)
	public Response getAllOfMazo(@PathParam("id") int idJugador, @PathParam("nombreMazo") String nombreMazo) {
		List<Tarjeta> tarjetas = tarjetaDAO.getTarjetasOfMazo(nombreMazo, idJugador);
		return Response.ok(tarjetas).build();
	}

}
