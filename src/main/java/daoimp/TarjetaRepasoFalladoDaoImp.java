package daoimp;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import dao.TarjetaRepasoFalladoDao;
import entities.Tarjeta_Repaso_Acertado;
import entities.Tarjeta_Repaso_Fallado;
@RequestScoped
public class TarjetaRepasoFalladoDaoImp  implements TarjetaRepasoFalladoDao {
	@PersistenceContext
	private EntityManager em;
	@Override
	public Tarjeta_Repaso_Fallado create(Tarjeta_Repaso_Fallado tarjetaRepasoFallado) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(tarjetaRepasoFallado);
		et.commit();
		return tarjetaRepasoFallado;
	}
	@Override
	public void createListOf(List<Tarjeta_Repaso_Fallado> tarjetasRepasoFallado) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		for (Tarjeta_Repaso_Fallado tarjeta_Repaso_Fallado : tarjetasRepasoFallado) {
			em.persist(tarjeta_Repaso_Fallado);
		}
		et.commit();
	}

}
