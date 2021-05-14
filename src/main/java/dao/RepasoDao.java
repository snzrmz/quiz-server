package dao;
import java.util.List;

import entities.Repaso;
public interface RepasoDao {
List<Repaso>getAllFrom(String nombreMazo, int idJugador);

}
