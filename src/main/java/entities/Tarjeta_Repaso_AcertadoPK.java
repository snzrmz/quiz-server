package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;

@Embeddable
public class Tarjeta_Repaso_AcertadoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "Tarjeta_idTarjeta")
	private int Tarjeta_idTarjeta;
	
	@Column(name = "Repaso_idRepaso")
	private int Repaso_idRepaso;
	

	public Tarjeta_Repaso_AcertadoPK (int idTarjeta, int idRepaso) {
		this.Tarjeta_idTarjeta = idTarjeta;
		this.Repaso_idRepaso = idRepaso;
	}
	public Tarjeta_Repaso_AcertadoPK() {
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Repaso_idRepaso;
		result = prime * result + Tarjeta_idTarjeta;
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
		Tarjeta_Repaso_AcertadoPK other = (Tarjeta_Repaso_AcertadoPK) obj;
		if (Repaso_idRepaso != other.Repaso_idRepaso)
			return false;
		if (Tarjeta_idTarjeta != other.Tarjeta_idTarjeta)
			return false;
		return true;
	}
	public int getTarjeta_IdTarjeta() {
		return Tarjeta_idTarjeta;
	}
	public void setTarjeta_IdTarjeta(int idTarjeta) {
		this.Tarjeta_idTarjeta = idTarjeta;
	}
	
	public int getRepaso_idRepaso() {
		return Repaso_idRepaso;
	}
	public void setRepaso_idRepaso(int repaso_idRepaso) {
		Repaso_idRepaso = repaso_idRepaso;
	}
	@Override
	public String toString() {
		return "{\"Tarjeta_idTarjeta\":\"" + Tarjeta_idTarjeta + "\", \"Repaso_idRepaso\":\"" + Repaso_idRepaso + "\"}";
	}
	
	

}
