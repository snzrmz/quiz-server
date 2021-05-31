package entities;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.xml.bind.annotation.XmlRootElement;

@Entity

@XmlRootElement
public class Tarjeta_Repaso_Acertado implements Serializable {

	

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private Tarjeta_Repaso_AcertadoPK traID;

	public void setTraID(Tarjeta_Repaso_AcertadoPK traID) {
		this.traID = traID;
	}
	@PrePersist
	   private void prePersiste() {
	       if (traID == null) {
	    	   Tarjeta_Repaso_AcertadoPK pk = new Tarjeta_Repaso_AcertadoPK();
	           pk.setTarjeta_IdTarjeta(getTarjetaIdTarjeta());
	           pk.setRepaso_idRepaso(repaso.getIdRepaso());
	           setTraID(pk);
	       }
	   }

	@ManyToOne
    @PrimaryKeyJoinColumn(name = "Repaso_idRepaso", referencedColumnName = "idRepaso")
	private Repaso repaso;
	
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name = "Tarjeta_idTarjeta", referencedColumnName = "idTarjeta")
	private Tarjeta tarjeta;
	

	@JsonbProperty(value="Tarjeta_idTarjeta")
	public int getTarjetaIdTarjeta() {
		return tarjeta.getIdTarjeta();
	}
	@JsonbProperty(value="Repaso_idRepaso")
	public int getRepasoIdRepaso() {
		return traID.getRepaso_idRepaso();
	}
	@Override
	public String toString() {
		return "{\"traID\":\"" + traID + "\", \"repaso\":\"" + repaso + "\", \"tarjeta\":\"" + tarjeta + "\"}";
	}
	




	
}
