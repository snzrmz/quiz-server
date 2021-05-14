package daoimp;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import dao.JugadorDao;
import entities.Jugador;

@RequestScoped
public class JugadorDaoImp implements JugadorDao {

	@PersistenceContext
	private EntityManager em;
	@Inject
	UserTransaction ut;

	@Override
	public Jugador getOne(int idJugador) {
		Jugador jugador;
		try {
			jugador = em.createNamedQuery("Jugador.findOne", Jugador.class)
					.setParameter("idJugador", idJugador).getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}

		return jugador;
	}

	@Override
	public int create(Jugador jugador) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(jugador);
		et.commit();
		return jugador.getIdJugador();

	}

	@Override
	public void update(Jugador jugador) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(jugador);
		et.commit();
		
	}

}
