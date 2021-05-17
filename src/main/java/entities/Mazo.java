package entities;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbVisibility;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;


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
	
	@JsonInclude()
	@Transient
	private int contador;
	
	/*
	 * public Jugador getJugador() { return jugador; }
	 */


	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Mazo() {

	}
	
	public void setMazoPK(MazoPK mazoPK) {
		this.mazoPK = mazoPK;
	}

	public String getNombre() {
		return mazoPK.nombre;
	}

	public int getIdJugador() {
		return mazoPK.idJugador;
	}

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	
	/*
	 * @Override public String toString() { return "{\"nombre\":\"" + nombre +
	 * "\", \"jugador\":\"" + jugador.getIdJugador() + "\"}"; }
	 */

	/*
	 * public MazoPK getMazoPK() { return mazoPK; }
	 */

}
