package daoimp;

import java.util.List;

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
	@Override
	public void createListOf(List<Tarjeta_Repaso_Acertado> tarjetasRepasoAcertado) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		for (Tarjeta_Repaso_Acertado tarjeta_Repaso_Acertado : tarjetasRepasoAcertado) {
			em.persist(tarjeta_Repaso_Acertado);
		}
		et.commit();
	}

}
