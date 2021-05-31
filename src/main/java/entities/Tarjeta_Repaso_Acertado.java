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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.xml.bind.annotation.XmlRootElement;

@Entity

@XmlRootElement
public class Tarjeta_Repaso_Acertado implements Serializable {



	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private Tarjeta_Repaso_AcertadoPK traID;


	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Repaso_idRepaso", referencedColumnName="idRepaso", updatable = false, insertable = false)
	private Repaso repaso;
	
	/*@JsonbTransient
	public Repaso getRepaso() {
		return this.repaso;
	}*/

	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Tarjeta_idTarjeta", referencedColumnName="idTarjeta", updatable = false, insertable = false)
	private Tarjeta tarjeta;
	

	@JsonbProperty(value="Tarjeta_idTarjeta")
	public int getTarjetaIdTarjeta() {
		return tarjeta.getIdTarjeta();
	}
	@JsonbProperty(value="Repaso_idRepaso")
	public int getRepasoIdRepaso() {
		return repaso.getIdRepaso();
	}



	
}
