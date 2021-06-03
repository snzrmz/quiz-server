package services;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.awt.PageAttributes.MediaType;
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
import daoimp.TarjetaDaoImp;
import daoimp.TarjetaRepasoAcertadoDaoImp;
import daoimp.TarjetaRepasoFalladoDaoImp;
import entities.Repaso;
import entities.Tarjeta;
import entities.Tarjeta_Repaso_Acertado;
import entities.Tarjeta_Repaso_Fallado;

@ApplicationScoped
@Path("jugadores/{id}/mazos/{nombreMazo}/repasos")
public class RepasoRest {
	@Inject
	private RepasoDaoImp repasoDAO;
	@Inject
	private TarjetaDaoImp tarjetaDAO;
	

	@GET
	@Produces(APPLICATION_JSON)
	public Response getAllFrom(@PathParam("id") int idJugador, @PathParam("nombreMazo") String nombreMazo) {
		List<Repaso> repasos = repasoDAO.getAllFrom(nombreMazo, idJugador);
		// System.out.println(repasos.get(0).getTarjetaRepasoFallado().get(0).getTarjeta_IdTarjeta());
		return Response.ok(repasos).build();
	}

	@Path("/{idRepaso}")
	@GET
	@Produces(APPLICATION_JSON)
	public Response getOne(@PathParam("idRepaso") int idRepaso) {
		Repaso repaso = repasoDAO.getOne(idRepaso);
		Tarjeta tarjeta = repaso.getTarjetaRepasoAcertado().get(0).getTarjeta();
		return Response.ok(tarjeta).build();
	}

	@POST
	@Consumes(APPLICATION_JSON)
	@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	public Response postRepaso(@Context UriInfo uriInfo, Repaso repaso) {
		Tarjeta tarjeta = null;
		for (int i = 0; i < repaso.getTarjetaRepasoAcertado().size(); i++) {
			tarjeta = tarjetaDAO.getOne(repaso.getTarjetaRepasoAcertado().get(i).getTarjetaIdTarjeta());
			repaso.getTarjetaRepasoAcertado().get(i).setTarjeta(tarjeta);
		}
		for (int i = 0; i < repaso.getTarjetaRepasoFallado().size(); i++) {
			tarjeta = tarjetaDAO.getOne(repaso.getTarjetaRepasoFallado().get(i).getTarjetaIdTarjeta());
			repaso.getTarjetaRepasoFallado().get(i).setTarjeta(tarjeta);
		}

		int idRepaso = repasoDAO.create(repaso);
		if (idRepaso != -1) {
			UriBuilder uriBuilder = uriInfo.getRequestUriBuilder();
			URI uri = uriBuilder.path(Integer.toString(idRepaso)).build();
			return Response.created(uri).build();
		}

		return Response.ok(repaso).build();

	}


}