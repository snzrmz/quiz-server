package daoimp;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.TarjetaDao;
import entities.Tarjeta;
@RequestScoped
public class TarjetaDaoImp implements TarjetaDao {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public List<Tarjeta> getTarjetasFrom(int idJugador) {
		return entityManager.createNamedQuery("Tarjeta.getFrom", Tarjeta.class)
				.setParameter("idJugador", idJugador).getResultList();

	}
	@Override
	public List<Tarjeta> getTarjetasOfMazo(String nombreMazo, int idJugador) {
		return entityManager.createNamedQuery("Tarjeta.getOfMazo", Tarjeta.class)
				.setParameter("idJugador", idJugador)
				.setParameter("nombreMazo", nombreMazo).getResultList();
	}

}
