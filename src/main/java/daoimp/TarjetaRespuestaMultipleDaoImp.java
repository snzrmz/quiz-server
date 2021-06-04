package daoimp;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import dao.TarjetaRespuestaMultipleDao;
import entities.Tarjeta_Respuesta_Multiple;

@RequestScoped
public class TarjetaRespuestaMultipleDaoImp implements TarjetaRespuestaMultipleDao {
	@PersistenceContext
	private EntityManager em;
	@Override
	public Tarjeta_Respuesta_Multiple create(Tarjeta_Respuesta_Multiple trm) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(trm);
		et.commit();
		return trm;
	}

}
