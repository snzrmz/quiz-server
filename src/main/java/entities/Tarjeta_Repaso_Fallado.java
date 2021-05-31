package entities;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Tarjeta_Repaso_Fallado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private Tarjeta_Repaso_FalladoPK tarjetaFallada;
	
	@ManyToOne
	@JsonbTransient
	private Tarjeta tarjeta;
	
	@ManyToOne
	@JsonbTransient
	private Repaso repaso;


	public int getTarjeta_IdTarjeta() {
		return tarjetaFallada.getidTarjeta();
	}

	public void setTarjeta(int idTarjeta) {
		this.tarjetaFallada.setidTarjeta(idTarjeta);
	}

	public int getRepaso_IdRepaso() {
		return this.tarjetaFallada.getidRepaso();
	}

	public void setRepaso(int idRepaso) {
		this.tarjetaFallada.setidRepaso(idRepaso);
	}

	
	


}
