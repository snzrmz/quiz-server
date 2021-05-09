package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({ @NamedQuery(name = "Mazo.getById", query = "SELECT m " + "FROM Mazo m"),
		@NamedQuery(name = "Mazo.getAllFrom", query = "SELECT m " + "FROM Mazo m "
				+ "WHERE m.jugador.idJugador = :idJugador") })
@XmlRootElement
public class Mazo implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private MazoPK mazoPK;

	@ManyToOne
	@JoinColumn(name = "idJugador", referencedColumnName = "idJugador", insertable = false, updatable = false)
	private Jugador jugador;

	/*
	 * public Jugador getJugador() { return jugador; }
	 */

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Mazo() {

	}
	/*
	 * @Override public String toString() { return "{\"nombre\":\"" + nombre +
	 * "\", \"jugador\":\"" + jugador.getIdJugador() + "\"}"; }
	 */

	/*
	 * public MazoPK getMazoPK() { return mazoPK; }
	 */

	public void setMazoPK(MazoPK mazoPK) {
		this.mazoPK = mazoPK;
	}

	public String getNombre() {
		return mazoPK.nombre;
	}

	public int getIdJugador() {
		return mazoPK.idJugador;
	}

}
