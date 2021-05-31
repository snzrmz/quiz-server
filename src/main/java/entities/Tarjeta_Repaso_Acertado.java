package entities;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.CascadeType;
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
@IdClass(Tarjeta_Repaso_AcertadoPK.class)
@XmlRootElement
public class Tarjeta_Repaso_Acertado implements Serializable {



	private static final long serialVersionUID = 1L;
	@Id
	private int Tarjeta_idTarjeta;
	@Id
	private int Repaso_idRepaso;
	


	@ManyToOne(cascade = CascadeType.PERSIST)
	@PrimaryKeyJoinColumn(name = "Repaso_idRepaso", referencedColumnName="idRepaso")
	private Repaso repaso;
	
	/*@JsonbTransient
	public Repaso getRepaso() {
		return this.repaso;
	}*/

	@ManyToOne(cascade = CascadeType.PERSIST)
	@PrimaryKeyJoinColumn(name = "Tarjeta_idTarjeta", referencedColumnName="idTarjeta")
	private Tarjeta tarjeta;
	
	

	public Tarjeta_Repaso_Acertado() {
		// TODO Auto-generated constructor stub
	}

	public Tarjeta_Repaso_Acertado(int tarjeta_idTarjeta) {
		Tarjeta_idTarjeta = tarjeta_idTarjeta;
	}



	@JsonbProperty(value = "Repaso_idRepaso")
	public int getRepaso_idRepaso() {
		return Repaso_idRepaso;
	}

	public void setRepaso_idRepaso(int repaso_idRepaso) {
		Repaso_idRepaso = repaso_idRepaso;
	}
	@JsonbProperty(value = "Tarjeta_idTarjeta")
	public int getTarjeta_idTarjeta() {
		return Tarjeta_idTarjeta;
	}



	public void setTarjeta_idTarjeta(int tarjeta_idTarjeta) {
		Tarjeta_idTarjeta = tarjeta_idTarjeta;
	}

	@Override
	public String toString() {
		return "{\"Tarjeta_idTarjeta\":\"" + Tarjeta_idTarjeta + "\", \"Repaso_idRepaso\":\"" + Repaso_idRepaso + "\"}";
	}

	


	
}
