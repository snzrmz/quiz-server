package services;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.net.URI;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import daoimp.RepasoDaoImp;
import daoimp.TarjetaRepasoAcertadoDaoImp;
import daoimp.TarjetaRepasoFalladoDaoImp;
import entities.Repaso;
import entities.Tarjeta_Repaso_Acertado;
import entities.Tarjeta_Repaso_Fallado;

@ApplicationScoped
@Path("jugadores/{id}/mazos/{nombreMazo}/repasos")
public class RepasoRest {
	@Inject
	private RepasoDaoImp repasoDAO;
	@Inject
	private TarjetaRepasoAcertadoDaoImp tarjetaRepasoAcertadoDAO;
	@Inject
	private TarjetaRepasoFalladoDaoImp tarjetaRepasoFalladoDAO;

	@GET
	@Produces(APPLICATION_JSON)
	public Response getAllFrom(@PathParam("id") int idJugador, @PathParam("nombreMazo") String nombreMazo) {
		List<Repaso> repasos = repasoDAO.getAllFrom(nombreMazo, idJugador);
		// System.out.println(repasos.get(0).getTarjetaRepasoFallado().get(0).getTarjeta_IdTarjeta());
		return Response.ok(repasos).build();
	}

	@POST
	@Consumes(APPLICATION_JSON)
	public Response postRepaso(@Context UriInfo uriInfo, Repaso repaso) {
		int idRepaso = repasoDAO.create(repaso);
		System.out.println(repaso);
		if (idRepaso != -1) {
			UriBuilder uriBuilder = uriInfo.getRequestUriBuilder();
			URI uri = uriBuilder.path(Integer.toString(idRepaso)).build();
			return Response.created(uri).build();
		} else {
			Response.Status responseStatus = Response.Status.NOT_FOUND;
			return Response.status(responseStatus).build();
		}

	}
	
}