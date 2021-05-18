package daoimp;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.TarjetaDao;
import entities.Tarjeta;

@RequestScoped
public class TarjetaDaoImp implements TarjetaDao {
	@PersistenceContext
	private EntityManager em;

	/*
	 * @Override public List<Tarjeta> getAllFrom(int idJugador) { return
	 * em.createNamedQuery("Tarjeta.getFrom", Tarjeta.class)
	 * .setParameter("idJugador", idJugador).getResultList();
	 * 
	 * }
	 */
	@Override
	public List<Tarjeta> getAllOfMazo(String nombreMazo, int idJugador) {
		return em.createNamedQuery("Tarjeta.getOfMazo", Tarjeta.class).setParameter("idJugador", idJugador)
				.setParameter("nombreMazo", nombreMazo).getResultList();
	}

	@Override
	public Tarjeta getOne(int idTarjeta) {
		return em.createNamedQuery("Tarjeta.getOne", Tarjeta.class).setParameter("idTarjeta", idTarjeta)
				.getSingleResult();
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

	@Override
	public List<Tarjeta> getTarjetasAcertadas(int idRepaso, int idJugador, String nombreMazo) {

		String sql = "SELECT * FROM Tarjeta t " + "WHERE idTarjeta IN "
				+ "(SELECT Tarjeta_idTarjeta FROM Tarjeta_Repaso_Acertado tra INNER JOIN Repaso r ON tra.Repaso_idRepaso = r.idRepaso WHERE Repaso_idRepaso = :idRepaso) "
				+ "AND idJugador = :idJugador AND nombreMazo = :nombreMazo";

		Query query = em.createNativeQuery(sql, Tarjeta.class);
		query.setParameter(1, idRepaso);
		query.setParameter(2, idJugador);
		query.setParameter(3, nombreMazo);

		@SuppressWarnings("unchecked")
		List<Tarjeta> resultList = (List<Tarjeta>) query.getResultList();

		return resultList;
	}

	@Override
	public List<Tarjeta> getTarjetasFalladas(int idRepaso, int idJugador, String nombreMazo) {
		String sql = "SELECT * FROM Tarjeta t " + "WHERE idTarjeta IN "
				+ "(SELECT Tarjeta_idTarjeta FROM Tarjeta_Repaso_Fallado trf INNER JOIN Repaso r ON trf.Repaso_idRepaso = r.idRepaso WHERE Repaso_idRepaso = :idRepaso) "
				+ "AND idJugador = :idJugador AND nombreMazo = :nombreMazo";

		Query query = em.createNativeQuery(sql, Tarjeta.class);
		query.setParameter(1, idRepaso);
		query.setParameter(2, idJugador);
		query.setParameter(3, nombreMazo);

		@SuppressWarnings("unchecked")
		List<Tarjeta> resultList = (List<Tarjeta>) query.getResultList();

		return resultList;
	}

	/*@Override
	public int countTarjetasInMazo(int idJugador, String nombreMazo) {
		Object obj = em.createNamedQuery("Tarjeta.countInMazo", Long.class).setParameter("idJugador", idJugador)
				.setParameter("nombreMazo", nombreMazo).getSingleResult();
		 if (obj != null) {
		        Integer result = Integer.parseInt(obj.toString());
		        return result;
		    }

		    return Integer.valueOf(0);
	}*/


}
