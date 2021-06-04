package daoimp;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import dao.RepasoDao;
import entities.Repaso;
import entities.Tarjeta_Repaso_Acertado;
import entities.Tarjeta_Repaso_Fallado;

@RequestScoped
public class RepasoDaoImp implements RepasoDao {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Repaso> getAllFrom(String nombreMazo, int idJugador) {
		return em.createQuery("SELECT r FROM Repaso r WHERE r.nombreMazo = :nombreMazo AND r.idJugador = :idJugador", Repaso.class).
				setParameter("nombreMazo", nombreMazo).
				setParameter("idJugador", idJugador).getResultList();
		
	}

	@Override
	public int create(Repaso repaso) {
		EntityTransaction et = em.getTransaction();
		et.begin();
	
		for(Tarjeta_Repaso_Acertado tra : repaso.getTarjetaRepasoAcertado()) {
			tra.setRepaso(repaso);
		}
		
		for(Tarjeta_Repaso_Fallado trf : repaso.getTarjetaRepasoFallado()) {
			trf.setRepaso(repaso);
		}
		
		em.merge(repaso);
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
