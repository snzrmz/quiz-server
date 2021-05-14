package daoimp;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import dao.TarjetaDao;
import entities.Tarjeta;
@RequestScoped
public class TarjetaDaoImp implements TarjetaDao {
	@PersistenceContext
	private EntityManager em;
	/*@Override
	public List<Tarjeta> getAllFrom(int idJugador) {
		return em.createNamedQuery("Tarjeta.getFrom", Tarjeta.class)
				.setParameter("idJugador", idJugador).getResultList();

	}*/
	@Override
	public List<Tarjeta> getAllOfMazo(String nombreMazo, int idJugador) {
		return em.createNamedQuery("Tarjeta.getOfMazo", Tarjeta.class)
				.setParameter("idJugador", idJugador)
				.setParameter("nombreMazo", nombreMazo).getResultList();
	}
	@Override
	public Tarjeta getOne(int idTarjeta) {
		return em.createNamedQuery("Tarjeta.getOne", Tarjeta.class)
				.setParameter("idTarjeta", idTarjeta).getSingleResult();
	}
	@Override
	public int create(Tarjeta tarjeta) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(tarjeta);
		et.commit();
		return tarjeta.getIdTarjeta();
	}
	@Override
	public void update(Tarjeta tarjeta) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(tarjeta);
		et.commit();
	}
	@Override
	public void delete(Tarjeta tarjeta) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(tarjeta);
		et.commit();	
	}

}
