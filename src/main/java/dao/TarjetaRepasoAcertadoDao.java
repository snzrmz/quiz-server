package dao;
import javax.ejb.Local;

import entities.Tarjeta_Repaso_Acertado;
@Local
public interface TarjetaRepasoAcertadoDao {
	Tarjeta_Repaso_Acertado create(Tarjeta_Repaso_Acertado tarjetaRepasoAcertado);
}
