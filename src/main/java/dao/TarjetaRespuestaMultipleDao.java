package dao;

import javax.ejb.Local;

import entities.Tarjeta_Respuesta_Multiple;
@Local
public interface TarjetaRespuestaMultipleDao {
	Tarjeta_Respuesta_Multiple create(Tarjeta_Respuesta_Multiple trm);
}
