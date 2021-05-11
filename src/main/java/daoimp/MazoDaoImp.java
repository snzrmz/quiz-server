package daoimp;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.MazoDao;
import entities.Mazo;

@RequestScoped
public class MazoDaoImp implements MazoDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Mazo getOne(int idJugador, String nombreMazo) {
		return entityManager.createNamedQuery("Mazo.getById", Mazo.class)
				.setParameter("idJugador", idJugador)
				.setParameter("nombreMazo",nombreMazo).getSingleResult();
	}

	@Override
	public List<Mazo> getAll(int idJugador) {
		return entityManager.createNamedQuery("Mazo.getAllFrom", Mazo.class).setParameter("idJugador", idJugador).getResultList();
	}

}
