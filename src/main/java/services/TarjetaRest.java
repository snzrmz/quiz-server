package services;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.net.URI;
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
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import daoimp.MazoDaoImp;
import daoimp.RespuestaDaoImp;
import daoimp.TarjetaDaoImp;
import daoimp.TarjetaRespuestaMultipleDaoImp;
import daoimp.TarjetaRespuestaUnicaDaoImp;
import entities.Mazo;
import entities.Respuesta;
import entities.Tarjeta;
import entities.Tarjeta_Respuesta_Multiple;
import entities.Tarjeta_Respuesta_Unica;

@ApplicationScoped
@Path("jugadores/{id}/mazos/{nombreMazo}/tarjetas")
public class TarjetaRest {
	@Inject
	private TarjetaDaoImp tarjetaDAO;
	@Inject
	private MazoDaoImp mazoDAO;
	@Inject
	private TarjetaRespuestaUnicaDaoImp truDAO;
	@Inject
	private TarjetaRespuestaMultipleDaoImp trmDAO;
	@Inject
	private RespuestaDaoImp respuestaDAO;

	@GET
	@Produces(APPLICATION_JSON)
	public Response getAllOfMazo(@PathParam("id") int idJugador, @PathParam("nombreMazo") String nombreMazo) {
		List<Tarjeta> tarjetas = tarjetaDAO.getAllOfMazo(nombreMazo, idJugador);
		if (tarjetas != null) {
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
		if (tarjeta != null) {
			return Response.ok(tarjeta).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@POST
	@Consumes(APPLICATION_JSON)
	public Response postTarjeta(@Context UriInfo uriInfo, Tarjeta tarjeta) {

		int idTarjeta = tarjetaDAO.create(tarjeta);

		if (idTarjeta != -1) {
			UriBuilder uriBuilder = uriInfo.getRequestUriBuilder();
			URI uri = uriBuilder.path(Integer.toString(idTarjeta)).build();
			return Response.created(uri).build();
		} else {
			Response.Status responseStatus = Response.Status.NOT_FOUND;
			return Response.status(responseStatus).build();
		}

	}

	@Path("unica")
	@POST
	@Consumes(APPLICATION_JSON)
	public Response postTarjetaUnica(Tarjeta_Respuesta_Unica tru) {
		truDAO.create(tru);
		return Response.status(Response.Status.OK).build();

	}
	
	@Path("multiple")
	@POST
	@Consumes(APPLICATION_JSON)
	public Response postTarjetaMultiple(Tarjeta_Respuesta_Multiple trm) {
		trmDAO.create(trm);
		return Response.status(Response.Status.OK).build();

	}
	
	@Path("multiple/respuestas")
	@POST
	@Consumes(APPLICATION_JSON)
	public Response postRespuesta(List<Respuesta> respuestas) {
		respuestas.forEach(respuesta ->{
			System.out.println(respuesta.toString());
			respuestaDAO.create(respuesta);
		});
		return Response.ok().build();

	}

	@PUT
	@Consumes(APPLICATION_JSON)
	public Response putTarjeta(@PathParam("id") int idJugador, @PathParam("nombreMazo") String nombreMazo,
			Tarjeta tarjeta) {
		Mazo mazo = mazoDAO.getOne(idJugador, nombreMazo);
		Response.Status response = Response.Status.OK;
		if (mazo != null) {
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
	public Response deleteTarjeta(@PathParam("id") int idJugador, @PathParam("nombreMazo") String nombreMazo,
			Tarjeta tarjeta) {
		Mazo mazo = mazoDAO.getOne(idJugador, nombreMazo);
		Response.Status response = Response.Status.OK;
		if (mazo != null) {
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
