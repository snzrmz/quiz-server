package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Respuesta implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int idRespuesta;
	private String valor;
	private boolean correcta;
	@ManyToOne
	@JoinColumn(name = "idTarjeta", referencedColumnName = "idTarjeta", insertable = false, updatable = false)
	private Tarjeta_Respuesta_Multiple TarjetaRespuestaMultiple;
	
	public int getIdRespuesta() {
		return idRespuesta;
	}
	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public boolean isCorrecta() {
		return correcta;
	}
	public void setCorrecta(boolean correcta) {
		this.correcta = correcta;
	}

}
