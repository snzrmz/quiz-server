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
	public List<Mazo> getMazos() {
		return entityManager.createNamedQuery("Mazo.getAll", Mazo.class).getResultList();
	}

	@Override
	public List<Mazo> getMazosFrom(int idJugador) {
		return entityManager.createNamedQuery("Mazo.getFrom", Mazo.class).setParameter("idJugador", idJugador).getResultList();
	}

	
	


}
