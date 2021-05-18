package daoimp;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import dao.MazoDao;
import entities.Mazo;

@RequestScoped
public class MazoDaoImp implements MazoDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Mazo getOne(int idJugador, String nombreMazo) {
		return (Mazo) em.createNativeQuery("select *, (SELECT count(*) from Tarjeta t where m.idJugador = t.idJugador and m.nombre = t.nombreMazo) as cuenta"
				+ "from Mazo m");
		/*return em.createNamedQuery("Mazo.getById", Mazo.class)
				.setParameter("idJugador", idJugador)
				.setParameter("nombreMazo",nombreMazo).getSingleResult();*/
	}

	@Override
	public List<Mazo> getAll(int idJugador) {
	
		return em.createNamedQuery("Mazo.getAllFrom", Mazo.class).setParameter("idJugador", idJugador).getResultList();
	}

	@Override
	public void delete(Mazo mazo) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(mazo);
		et.commit();
		
	}

	@Override
	public String create(Mazo mazo) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(mazo);
		et.commit();
		return mazo.getNombre();
		
	}

	@Override
	public void update(Mazo mazo) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(mazo);
		et.commit();
	}

}
