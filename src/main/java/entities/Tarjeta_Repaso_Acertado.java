package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@IdClass(Tarjeta_Repaso_AcertadoPK.class)
@XmlRootElement
public class Tarjeta_Repaso_Acertado implements Serializable {



	private static final long serialVersionUID = 1L;
	@Id
	private int Tarjeta_idTarjeta;
	@Id
	private int Repaso_idRepaso;
	


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Repaso_idRepaso", referencedColumnName="idRepaso", insertable = false, updatable = false)
	private Repaso repaso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Tarjeta_idTarjeta", referencedColumnName="idTarjeta", insertable = false, updatable = false)
	private Tarjeta tarjeta;
	
	
	
	public int getRepaso_idRepaso() {
		return Repaso_idRepaso;
	}

	public void setRepaso_idRepaso(int repaso_idRepaso) {
		Repaso_idRepaso = repaso_idRepaso;
	}
	
	public int getTarjeta_idTarjeta() {
		return Tarjeta_idTarjeta;
	}

	public void setTarjeta_idTarjeta(int tarjeta_idTarjeta) {
		Tarjeta_idTarjeta = tarjeta_idTarjeta;
	}

	public void setRepaso(Repaso repaso) {
		this.repaso = repaso;
	}


	
}
