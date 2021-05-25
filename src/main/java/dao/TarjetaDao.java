package dao;
import java.util.List;

import javax.ejb.Local;

import entities.Tarjeta;
@Local
public interface TarjetaDao {
	/*List<Tarjeta>getAllFrom(int idJugador);*/
	List<Tarjeta>getAllOfMazo(String nombreMazo, int idJugador);
	Tarjeta getOne(int idTarjeta);
	List<Tarjeta> getTarjetasAcertadas(int idRepaso, int idJugador, String nombreMazo);
	List<Tarjeta> getTarjetasFalladas(int idRepaso, int idJugador, String nombreMazo);
	/*int countTarjetasInMazo(int idJugador, String nombreMazo);*/
	Tarjeta create(Tarjeta tarjeta);
	void update(Tarjeta tarjeta);
	void delete(Tarjeta tarjeta);
}
