package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Tarjeta_Repaso_Fallado implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private Tarjeta_Repaso_FalladoPK TRFPK;
	
	@ManyToOne
	@JoinColumn(name="idTarjeta", referencedColumnName = "idTarjeta", insertable = false, updatable = false)
	private Tarjeta tarjeta;
	
	@ManyToOne
	@JoinColumn(name="idRepaso", referencedColumnName = "idRepaso", insertable = false, updatable = false)
	private Repaso repaso;
	


}
