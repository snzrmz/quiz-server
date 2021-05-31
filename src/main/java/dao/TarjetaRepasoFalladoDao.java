package dao;
import java.util.List;

import javax.ejb.Local;

import entities.Tarjeta_Repaso_Fallado;
@Local
public interface TarjetaRepasoFalladoDao {
	Tarjeta_Repaso_Fallado create(Tarjeta_Repaso_Fallado tarjetaRepasoFallado);
	void createListOf(List<Tarjeta_Repaso_Fallado> tarjetasRepasoFallado);
}
