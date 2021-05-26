package daoimp;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import dao.TarjetaRepasoFalladoDao;
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

}
