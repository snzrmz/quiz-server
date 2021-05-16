package dao;

import javax.ejb.Local;
import entities.Jugador;
@Local
public interface JugadorDao {

	Jugador getOne(int idJugador);
	Jugador getOneByEmail(String email);
	int create(Jugador jugador);
	void update(Jugador jugador);
}
