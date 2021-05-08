package daoimp;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import dao.JugadorDao;
import entities.Jugador;

@RequestScoped
public class JugadorDaoImp implements JugadorDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<Jugador> getJugadores() {
		return entityManager.createNamedQuery("Jugador.getAll", Jugador.class).getResultList();
	}

	@Override
	public Jugador getJugadorById(int idJugador) {
		Jugador jugador;
		try {
			jugador = entityManager.createNamedQuery("Jugador.findOne", Jugador.class)
					.setParameter("idJugador", idJugador).getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}

		return jugador;
	}

}
