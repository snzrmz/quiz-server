package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "Tarjeta.getFrom", query = "SELECT t FROM Tarjeta t " + "WHERE t.idJugador = :idJugador"),
		@NamedQuery(name = "Tarjeta.getOfMazo", query = "SELECT t FROM Tarjeta t "
				+ "WHERE t.idJugador = :idJugador AND t.nombreMazo = :nombreMazo") })
public class Tarjeta implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int idTarjeta;
	private String tipoRespuesta;
	private int idJugador;
	private String nombreMazo;
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "idJugador", referencedColumnName = "idJugador", insertable = false, updatable = false),
			@JoinColumn(name = "nombreMazo", referencedColumnName = "nombre", insertable = false, updatable = false) })
	private Mazo mazo;

	private String pregunta;

	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public String getTipoRespuesta() {
		return tipoRespuesta;
	}

	public void setTipoRespuesta(String tipoRespuesta) {
		this.tipoRespuesta = tipoRespuesta;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public String getNombreMazo() {
		return nombreMazo;
	}

	public void setNombreMazo(String nombreMazo) {
		this.nombreMazo = nombreMazo;
	}

	/*public Mazo getMazo() {
		return mazo;
	}

	public void setMazo(Mazo mazo) {
		this.mazo = mazo;
	}*/

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

}
