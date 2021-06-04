package daoimp;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import dao.TarjetaRespuestaUnicaDao;
import entities.Tarjeta_Respuesta_Unica;
@RequestScoped
public class TarjetaRespuestaUnicaDaoImp implements TarjetaRespuestaUnicaDao{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Tarjeta_Respuesta_Unica create(Tarjeta_Respuesta_Unica tru) {
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(tru);
		et.commit();
		return tru;
	}
	

}
