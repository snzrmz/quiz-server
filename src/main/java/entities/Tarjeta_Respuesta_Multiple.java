package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
@Entity
public class Tarjeta_Respuesta_Multiple implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int idTarjeta;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name = "idTarjeta")
	private Tarjeta tarjeta;
	
	
}
