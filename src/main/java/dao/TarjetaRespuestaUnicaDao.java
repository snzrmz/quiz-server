package dao;

import javax.ejb.Local;

import entities.Tarjeta_Respuesta_Unica;
@Local
public interface TarjetaRespuestaUnicaDao {
	Tarjeta_Respuesta_Unica create(Tarjeta_Respuesta_Unica tru);

}
