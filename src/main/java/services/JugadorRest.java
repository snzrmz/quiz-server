package services;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
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

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import daoimp.JugadorDaoImp;
import entities.Jugador;

@ApplicationScoped
@Path("/jugadores")
public class JugadorRest {
	@Inject
	private JugadorDaoImp jugadorDAO;

	@GET
	@Path("/perfil/{nombreFichero}")
	@Produces("image/*")
	public Response getFichero(@PathParam("nombreFichero") String nombreFichero) {
		File fichero = new File(
				"C:\\Users\\Luis\\payara5\\glassfish\\domains\\domain1\\config\\images\\" + nombreFichero);
		return Response.ok(fichero).header("Content-Length", fichero.length()).build();
	}

	@PUT
	@Path("/perfil/{nombreFichero}")
	@Consumes("image/*")
	public Response putFichero(File fichero, @PathParam("nombreFichero") String nombreFichero) {
		Response.Status responseStatus = Response.Status.OK;
		fichero.renameTo(
				new File("C:\\Users\\Luis\\payara5\\glassfish\\domains\\domain1\\config\\images\\" + nombreFichero));
		return Response.status(responseStatus).build();
	}

	@POST
	@Path("/perfil/")
	@Consumes("multipart/form-data")
	public Response uploadFile(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) {

		String uploadedFileLocation = 
				System.getProperty("user.dir")  
				+ File.separator 
				+ "images" 
				+ File.separator
				+ fileDetail.getFileName();

		writeToFile(uploadedInputStream, uploadedFileLocation);
		System.out.println("File uploaded to : " + uploadedFileLocation);
		return Response.status(200).entity(fileDetail.getFileName()).build();
	}

	private void writeToFile(InputStream uploadedInputStream, String uploadedFileLocation) {
		try (OutputStream out = new FileOutputStream(new File(uploadedFileLocation))) {
			int read = 0;
			
			byte[] bytes = new byte[1024];

			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

		} catch (IOException e) {
		}
	}

	@Path("/{id}")
	@GET
	@Produces(APPLICATION_JSON)
	public Response getById(@PathParam("id") int idJugador) {
		Response.Status responseStatus = Response.Status.OK;
		Jugador jugador = jugadorDAO.getOne(idJugador);
		if (jugador != null)
			return Response.ok(jugador).build();
		else
			responseStatus = Response.Status.NOT_FOUND;
		return Response.status(responseStatus).build();
	}

	@PUT
	@Consumes(APPLICATION_JSON)
	public Response putUsuario(Jugador jugador) {
		Jugador jaux = new Jugador();
		jaux = jugadorDAO.getOne(jugador.getIdJugador());
		jaux.setContrasena(jugador.getContrasena());
		jaux.setEmail(jugador.getEmail());
		jaux.setUsuario(jugador.getUsuario());
		Response.Status responseStatus = Response.Status.OK;
		jugadorDAO.update(jaux);
		return Response.status(responseStatus).build();
	}

	@POST
	@Consumes(APPLICATION_JSON)
	public Response postUsuario(@Context UriInfo uriInfo, Jugador jugador) {

		int idJugador = jugadorDAO.create(jugador);

		if (idJugador != -1) {
			UriBuilder uriBuilder = uriInfo.getRequestUriBuilder();
			URI uri = uriBuilder.path(Integer.toString(idJugador)).build();
			return Response.created(uri).build();
		} else {
			Response.Status responseStatus = Response.Status.NOT_FOUND;
			return Response.status(responseStatus).build();
		}

	}

}