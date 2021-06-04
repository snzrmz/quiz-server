package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Tarjeta_Respuesta_Multiple implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int idTarjeta;
	

	

	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}


	
	
	
	
}
