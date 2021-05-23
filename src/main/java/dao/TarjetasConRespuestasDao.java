package dao;
import java.util.List;

import entities.TarjetasConRespuestas;
public interface TarjetasConRespuestasDao {
	List<TarjetasConRespuestas> getAll(int idJugador, String nombreMazo);

}
