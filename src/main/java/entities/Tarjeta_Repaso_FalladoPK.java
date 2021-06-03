package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Tarjeta_Repaso_FalladoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "Tarjeta_idTarjeta")
	private int Tarjeta_idTarjeta;
	
	@Column(name = "Repaso_idRepaso")
	private int Repaso_idRepaso;
	

	public Tarjeta_Repaso_FalladoPK (int idTarjeta, int idRepaso) {
		this.Tarjeta_idTarjeta = idTarjeta;
		this.Repaso_idRepaso = idRepaso;
	}
	public Tarjeta_Repaso_FalladoPK() {
		
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
		Tarjeta_Repaso_FalladoPK other = (Tarjeta_Repaso_FalladoPK) obj;
		if (Repaso_idRepaso != other.Repaso_idRepaso)
			return false;
		if (Tarjeta_idTarjeta != other.Tarjeta_idTarjeta)
			return false;
		return true;
	}

	public int getTarjeta_idTarjeta() {
		return Tarjeta_idTarjeta;
	}
	public void setTarjeta_idTarjeta(int idTarjeta) {
		this.Tarjeta_idTarjeta = idTarjeta;
	}
	
	public int getRepaso_idRepaso() {
		return Repaso_idRepaso;
	}
	public void setRepaso_idRepaso(int Repaso_idRepaso) {
		this.Repaso_idRepaso = Repaso_idRepaso;
	}
	@Override
	public String toString() {
		return "{\"Tarjeta_idTarjeta\":\"" + Tarjeta_idTarjeta + "\", \"Repaso_idRepaso\":\"" + Repaso_idRepaso + "\"}";
	}
}
