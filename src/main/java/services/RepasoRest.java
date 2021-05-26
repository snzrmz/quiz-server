package services;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

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
	private TarjetaRepasoFalladoDaoImp tarjetaReasoFalladoDAO;
	
	@GET
	@Produces(APPLICATION_JSON)
	public Response  getAllFrom(@PathParam("id") int idJugador, @PathParam("nombreMazo") String nombreMazo) {
		List<Repaso> repasos = repasoDAO.getAllFrom(nombreMazo, idJugador);
		if(repasos!=null) {
			return Response.ok(repasos).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@POST
	@Consumes(APPLICATION_JSON)
	public Response postRepaso(Repaso repaso) {
			return Response.status(repasoDAO.create(repaso)).build();
		}
	
	@Path("/{idRepaso}/tarjeta/{idTarjeta}/acertada")
	@POST
	@Consumes(APPLICATION_JSON)
	public Response postRepasoTarjetaAcertada(Tarjeta_Repaso_Acertado repasoAcertado) {
			return Response.ok(tarjetaRepasoAcertadoDAO.create(repasoAcertado)).build();
		}
	
	@Path("/{idRepaso}/tarjeta/{idTarjeta}/fallada")
	@POST
	@Consumes(APPLICATION_JSON)
	public Response postRepasoTarjetaFallada(Tarjeta_Repaso_Fallado repasoFallado) {
			return Response.ok(tarjetaReasoFalladoDAO.create(repasoFallado)).build();
		}
}