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
	private int correcta;
	/*@ManyToOne
	@JoinColumn(name = "idTarjeta", referencedColumnName = "idTarjeta", insertable = false, updatable = false)
	private Tarjeta_Respuesta_Multiple TarjetaRespuestaMultiple;*/
	
	private int idTarjeta;
	
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
	public int correcta() {
		return correcta;
	}
	public void correcta(int correcta) {
		this.correcta = correcta;
	}
	/*public Tarjeta_Respuesta_Multiple getTarjetaRespuestaMultiple() {
		return TarjetaRespuestaMultiple;
	}
	
	public void setTarjetaRespuestaMultiple(Tarjeta_Respuesta_Multiple tarjetaRespuestaMultiple) {
		TarjetaRespuestaMultiple = tarjetaRespuestaMultiple;
	}*/
	public int getIdTarjeta() {
		return idTarjeta;
	}
	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

}
