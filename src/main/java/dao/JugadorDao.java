package dao;

import java.util.List;

import javax.ejb.Local;
import entities.Jugador;
@Local
public interface JugadorDao {
	List<Jugador> getAll();
	Jugador getOne(int idJugador);
	int create(Jugador jugador);
	void delete(Jugador jugador);
}
