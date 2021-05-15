package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.xml.bind.annotation.XmlRootElement;

@Embeddable
@XmlRootElement
public class Tarjeta_Repaso_FalladoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int idTarjeta;
	protected int idRepaso;

	public Tarjeta_Repaso_FalladoPK() {
	}
	

	public Tarjeta_Repaso_FalladoPK(int idTarjeta, int idRepaso) {
		this.idTarjeta = idTarjeta;
		this.idRepaso = idRepaso;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRepaso;
		result = prime * result + idTarjeta;
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
		if (idRepaso != other.idRepaso)
			return false;
		if (idTarjeta != other.idTarjeta)
			return false;
		return true;
	}
	
	
}
