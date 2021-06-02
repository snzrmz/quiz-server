package dao;

import java.util.List;

import javax.ejb.Local;

import entities.Repaso;
import entities.Tarjeta_Repaso_Acertado;
@Local
public interface RepasoDao {
	List<Repaso> getAllFrom(String nombreMazo, int idJugador);
	Repaso getOne(int idRepaso);
	int create(Repaso repaso);
	

}
