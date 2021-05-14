package dao;
import java.util.List;

import javax.ejb.Local;

import entities.Tarjeta;
@Local
public interface TarjetaDao {
	/*List<Tarjeta>getAllFrom(int idJugador);*/
	List<Tarjeta>getAllOfMazo(String nombreMazo, int idJugador);
	Tarjeta getOne(int idTarjeta);
	int create(Tarjeta tarjeta);
	void update(Tarjeta tarjeta);
	void delete(Tarjeta tarjeta);
}
