package dao;

import java.util.List;

import entities.Repaso;

public interface RepasoDao {
	List<Repaso> getAllFrom(String nombreMazo, int idJugador);
	Repaso getOne(int idRepaso);
	int create(Repaso repaso);

}
