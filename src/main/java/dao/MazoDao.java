package dao;

import java.util.List;

import javax.ejb.Local;

import entities.Mazo;
@Local
public interface MazoDao {
	
  Mazo getOne(int idJugador, String nombreMazo);
  List<Mazo> getAll(int idJugador);
  String create(Mazo mazo);
  void update(Mazo mazo);
  void delete(Mazo mazo);
  
}