package dao;

import javax.ejb.Local;
import entities.Jugador;
@Local
public interface JugadorDao {

	Jugador getOne(int idJugador);
	int create(Jugador jugador);
	void update(Jugador jugador);
}
