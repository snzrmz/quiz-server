package daoimp;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import dao.TarjetaRepasoAcertadoDao;
import entities.Tarjeta_Repaso_Acertado;
@RequestScoped
public class TarjetaRepasoAcertadoDaoImp implements TarjetaRepasoAcertadoDao {
	@PersistenceContext
	private EntityManager em;
	@Override
	public Tarjeta_Repaso_Acertado create(Tarjeta_Repaso_Acertado tarjetaRepasoAcertado) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(tarjetaRepasoAcertado);
		et.commit();
		return tarjetaRepasoAcertado;
	}

}
