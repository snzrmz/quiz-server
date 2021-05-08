package dao;

import java.util.List;

import javax.ejb.Remote;
import entities.Mazo;
@Remote
public interface MazoDao {
	
  List<Mazo> getMazos();//borrar
  List<Mazo> getMazosFrom(int idJugador);
}