package dao;
import java.util.List;

import javax.ejb.Local;

import entities.Tarjeta_Repaso_Acertado;
@Local
public interface TarjetaRepasoAcertadoDao {
	Tarjeta_Repaso_Acertado create(Tarjeta_Repaso_Acertado tarjetaRepasoAcertado);
	void createListOf(List<Tarjeta_Repaso_Acertado> tarjetasRepasoAcertado);
}
