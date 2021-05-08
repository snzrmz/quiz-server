package services;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import daoimp.MazoDaoImp;

import entities.Mazo;

@ApplicationScoped
@Path("mazos")
public class MazoRest {
	@Inject
	private MazoDaoImp mazoDAO;

	@GET
	@Produces(APPLICATION_JSON)
	public Response getMazos() { //borrar
		List<Mazo> mazos = mazoDAO.getMazos();
		return Response.ok(mazos).build();
	}

}
