package daoimp;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.UserTransaction;

import dao.JugadorDao;
import entities.Jugador;

@RequestScoped
public class JugadorDaoImp implements JugadorDao {

	@PersistenceContext
	private EntityManager entityManager;
	@Inject
	UserTransaction ut;

	@Override
	public Jugador getOne(int idJugador) {
		Jugador jugador;
		try {
			jugador = entityManager.createNamedQuery("Jugador.findOne", Jugador.class)
					.setParameter("idJugador", idJugador).getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}

		return jugador;
	}

	@Override
	public List<Jugador> getAll() {
		return entityManager.createNamedQuery("Jugador.getAll", Jugador.class).getResultList();
	}

	@Override
	public int create(Jugador jugador) {
		EntityTransaction et = entityManager.getTransaction();
		et.begin();
		entityManager.persist(jugador);
		et.commit();
		return jugador.getIdJugador();

	}

	@Override
	public void delete(Jugador jugador) {
		// TODO Auto-generated method stub

	}

}
