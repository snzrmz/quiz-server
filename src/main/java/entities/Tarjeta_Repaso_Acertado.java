package entities;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Tarjeta_Repaso_Acertado implements Serializable {

	

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private Tarjeta_Repaso_AcertadoPK traID;
	@JsonbTransient
	public Tarjeta_Repaso_AcertadoPK getTraID() {
		return traID;
	}
	public void setTraID(Tarjeta_Repaso_AcertadoPK traID) {
		this.traID = traID;
	}
	

	@MapsId("Repaso_idRepaso")
	@ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name = "Repaso_idRepaso", referencedColumnName = "idRepaso")
	private Repaso repaso;
	
	@MapsId("Tarjeta_idTarjeta")
	@ManyToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn(name = "Tarjeta_idTarjeta", referencedColumnName = "idTarjeta")
	private Tarjeta tarjeta;
	

	@JsonbProperty(value="Tarjeta_idTarjeta")
	public int getTarjetaIdTarjeta() {
		return this.traID.getTarjeta_idTarjeta();
	}
	@JsonbProperty(value="Repaso_idRepaso")
	public int getRepasoIdRepaso() {
		return this.traID.getRepaso_idRepaso();
	}
	


	public Tarjeta_Repaso_Acertado() {
	}

	public Tarjeta_Repaso_Acertado(Tarjeta_Repaso_AcertadoPK traID, Repaso repaso, Tarjeta tarjeta) {
		this.traID = traID;
		this.repaso = repaso;
		this.tarjeta = tarjeta;
	}
	public void setRepaso(Repaso repaso) {
		this.repaso = repaso;
	}
	public void setIdTarjeta(int idTarjeta) {
		this.tarjeta.setIdTarjeta(idTarjeta);
	}

	public void setIdRepaso(int idRepaso) {
		this.repaso.setIdRepaso(idRepaso);
	}
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	
	@JsonbTransient
	public Repaso getRepaso() {
		return repaso;
	}
	@JsonbTransient
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	

	@Override
	public String toString() {
		return "{\"traID\":\"" + traID + "\"}";
	}
	
}
