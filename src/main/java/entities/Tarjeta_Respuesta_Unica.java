package entities;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Tarjeta_Respuesta_Unica implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int idTarjeta;

	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	private String valor;

	
	@OneToOne
	@PrimaryKeyJoinColumn(name = "idTarjeta", referencedColumnName = "idTarjeta")
	private Tarjeta tarjeta;

	@JsonbTransient
	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	@Override
	public String toString() {
		return "{\"valor\":\"" + valor + "\", \"tarjeta\":\"" + tarjeta + "\"}";
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tarjeta == null) ? 0 : tarjeta.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarjeta_Respuesta_Unica other = (Tarjeta_Respuesta_Unica) obj;
		if (tarjeta == null) {
			if (other.tarjeta != null)
				return false;
		} else if (!tarjeta.equals(other.tarjeta))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

}
