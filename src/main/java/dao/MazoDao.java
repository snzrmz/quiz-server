package dao;

import java.util.List;

import javax.ejb.Local;
import entities.Mazo;
@Local
public interface MazoDao {
	
  Mazo getMazo(int idJugador, String nombreMazo);
  List<Mazo> getMazosFrom(int idJugador);
}