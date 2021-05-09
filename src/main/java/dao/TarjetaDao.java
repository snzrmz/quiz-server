package dao;
import java.util.List;

import javax.ejb.Local;

import entities.Tarjeta;
@Local
public interface TarjetaDao {
	List<Tarjeta>getTarjetasFrom(int idJugador);
	List<Tarjeta>getTarjetasOfMazo(String nombreMazo, int idJugador);

}
