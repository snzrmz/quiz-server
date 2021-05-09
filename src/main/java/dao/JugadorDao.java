package dao;

import java.util.List;

import javax.ejb.Local;
import entities.Jugador;
@Local
public interface JugadorDao {
	List<Jugador> getJugadores();
	Jugador getJugadorById(int idJugador);
	/*void crearJugador(Jugador jugador);
	void eliminarJugador(Jugador jugador);*/
}
