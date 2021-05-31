package entities;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Tarjeta_Repaso_Fallado implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Tarjeta_Repaso_FalladoPK tarjetaFallada;

	@ManyToOne
	@PrimaryKeyJoinColumn(name = "Tarjeta_idTarjeta", referencedColumnName = "idTarjeta")
	private Tarjeta tarjeta;

	@ManyToOne
	@PrimaryKeyJoinColumn(name = "Repaso_idRepaso", referencedColumnName = "idRepaso")
	private Repaso repaso;

	@JsonbProperty(value = "Tarjeta_idTarjeta")
	public int getTarjeta_idTarjeta() {
		return tarjetaFallada.Tarjeta_idTarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	@JsonbProperty(value = "Repaso_idRepaso")
	public int getRepaso() {
		return tarjetaFallada.getidRepaso();
	}

	public void setRepaso(Repaso repaso) {
		this.repaso = repaso;
	}

}
