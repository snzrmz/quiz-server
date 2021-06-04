package dao;

import javax.ejb.Local;

import entities.Respuesta;
@Local
public interface RespuestaDao {
	public void create(Respuesta respuesta);

}
