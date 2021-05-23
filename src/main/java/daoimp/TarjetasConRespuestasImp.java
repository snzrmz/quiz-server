package daoimp;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.TarjetasConRespuestasDao;
import entities.TarjetasConRespuestas;

@RequestScoped
public class TarjetasConRespuestasImp implements TarjetasConRespuestasDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<TarjetasConRespuestas> getAll(int idJugador, String nombreMazo) {
		// Se emula UNION combinando las dos listas
		String queryRespuestaUnicas = "SELECT "
				+ "new entities.TarjetasConRespuestas(t.idTarjeta, t.tipoRespuesta, t.idJugador, t.pregunta, tru.valor, (1) as correcta) "
				+ "FROM Tarjeta t INNER JOIN Tarjeta_Respuesta_Unica tru " + "ON t.idTarjeta = tru.idTarjeta "
				+ "WHERE t.idJugador = :idJugador AND t.nombreMazo = :nombreMazo ";
		List<TarjetasConRespuestas> tarjetasRespuestaUnica = em
				.createQuery(queryRespuestaUnicas, TarjetasConRespuestas.class).setParameter("idJugador", idJugador)
				.setParameter("nombreMazo", nombreMazo).getResultList();

		String queryRespuestasMultiples = "SELECT "
				+ "new entities.TarjetasConRespuestas(t.idTarjeta, t.tipoRespuesta, t.idJugador, t.pregunta, r.valor, r.correcta) "
				+ "FROM Tarjeta t INNER JOIN Tarjeta_Respuesta_Multiple trm " + "ON t.idTarjeta = trm.idTarjeta "
				+ "INNER JOIN Respuesta r ON trm.idTarjeta = r.idTarjeta "
				+ "WHERE t.idJugador = :idJugador and t.nombreMazo = :nombreMazo";
		List<TarjetasConRespuestas> tarjetasRespuestaMultiple = em
				.createQuery(queryRespuestasMultiples, TarjetasConRespuestas.class).setParameter("idJugador", idJugador)
				.setParameter("nombreMazo", nombreMazo).getResultList();

		List<TarjetasConRespuestas> listaCombinada = tarjetasRespuestaUnica;
		listaCombinada.addAll(tarjetasRespuestaMultiple);
		return listaCombinada;
	}
}
