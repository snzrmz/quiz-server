package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement
public class Repaso implements Serializable {

	private static final long serialVersionUID = 1L;

	public Repaso() {
		
	}
	@EmbeddedId
	private RepasoPK repasoPK;
	
	private boolean fin;
	@ManyToOne
	@JoinColumn(name = "idJugador", referencedColumnName = "idJugador", insertable = false, updatable = false)
	private Jugador jugador;
	@JoinColumns({
		@JoinColumn(name = "idJugador", referencedColumnName = "idJugador", insertable = false, updatable = false),
		@JoinColumn(name = "nombreMazo", referencedColumnName = "nombre", insertable = false, updatable = false) })
	private Mazo mazo;
	public boolean isFin() {
		return fin;
	}
	public void setFin(boolean fin) {
		this.fin = fin;
	}
	
	

}
