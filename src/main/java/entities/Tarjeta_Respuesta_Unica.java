package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Tarjeta_Respuesta_Unica implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int idTarjeta;
	
	@OneToOne
	@PrimaryKeyJoinColumn(name = "idTarjeta")
	private Tarjeta tarjeta;
	
	private String valor;
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

}
