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

import daoimp.TarjetasConRespuestasImp;
import entities.TarjetasConRespuestas;

@ApplicationScoped
@Path("jugadores/{id}/mazos/{nombreMazo}/tarjetas/respuestas")
public class TarjetasConRespuestasRest {
	
	@Inject
	private TarjetasConRespuestasImp TarjetasConRespuestasDAO;
	
	@GET
	@Produces(APPLICATION_JSON)
	public Response getAll(@PathParam("id") int idJugador, @PathParam("nombreMazo") String nombreMazo) {
		List<TarjetasConRespuestas> tarjetasConRespuesta = TarjetasConRespuestasDAO.getAll(idJugador, nombreMazo);
		return Response.ok(tarjetasConRespuesta).build();
		
	}

}
