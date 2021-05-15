package daoimp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import dao.RepasoDao;
import entities.Repaso;

public class RepasoDaoImp implements RepasoDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Repaso> getAllFrom(String nombreMazo, int idJugador) {
		return em.createQuery("SELECT * "
				+ "FROM Repaso "
				+ "WHERE nombreMazo = :nombreMazo"
				+ " AND idJugador = :idJugador", Repaso.class).
				setParameter(1, nombreMazo).
				setParameter(2, idJugador).getResultList();
		
	}

	@Override
	public int create(Repaso repaso) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(repaso);
		et.commit();
		return repaso.getIdRepaso();
		
	}

	@Override
	public Repaso getOne(int idRepaso) {
		return em.createNamedQuery("Repaso.getById", Repaso.class)
				.setParameter("idRepaso", idRepaso)
				.getSingleResult();
	}
	
	
}