package daoimp;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import dao.RespuestaDao;
import entities.Respuesta;
@RequestScoped
public class RespuestaDaoImp implements RespuestaDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void create(Respuesta respuesta) {
		
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(respuesta);
		et.commit();
		
	}

}
