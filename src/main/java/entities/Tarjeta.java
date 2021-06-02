package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;

import org.hibernate.annotations.Formula;

@Entity
@NamedQueries({ @NamedQuery(name = "Tarjeta.getOne", query = "SELECT t FROM Tarjeta t WHERE t.idTarjeta = :idTarjeta"),
		@NamedQuery(name = "Tarjeta.getOfMazo", query = "SELECT t FROM Tarjeta t "
				+ "WHERE t.idJugador = :idJugador AND t.nombreMazo = :nombreMazo") })
public class Tarjeta implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTarjeta;
	private String tipoRespuesta;
	private int idJugador;
	private String nombreMazo;
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "idJugador", referencedColumnName = "idJugador", insertable = false, updatable = false),
			@JoinColumn(name = "nombreMazo", referencedColumnName = "nombre", insertable = false, updatable = false) })
	private Mazo mazo;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumns({
			@JoinColumn(name = "idTarjeta", referencedColumnName = "idTarjeta", insertable = false, updatable = false) })
	private List<Respuesta> respuestas;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumns({
			@JoinColumn(name = "idTarjeta", referencedColumnName = "idTarjeta", insertable = false, updatable = false) })
	private Tarjeta_Respuesta_Unica respuesta;
	
	@OneToMany(mappedBy ="tarjeta")
	private List<Tarjeta_Repaso_Acertado> acertado;
	
	@OneToMany(mappedBy ="tarjeta")
	private List<Tarjeta_Repaso_Fallado> fallado;

	private String pregunta;
	private String recursoRuta;

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

	/*
	 * public Mazo getMazo() { return mazo; }
	 * 
	 * public void setMazo(Mazo mazo) { this.mazo = mazo; }
	 */

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getRecursoRuta() {
		return recursoRuta;
	}

	public void setRecursoRuta(String recurso) {
		this.recursoRuta = recurso;
	}

	public Tarjeta_Respuesta_Unica getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Tarjeta_Respuesta_Unica respuesta) {
		this.respuesta = respuesta;
	}

	public List<Respuesta> getRespuestas() {
		if (this.getTipoRespuesta().equals("MULTIPLE")) {
			return respuestas;
		} else {
			return null;
		}

	}

	public void setRespuestasMultiples(List<Respuesta> respuestas) {
		if (this.getTipoRespuesta().equals("MULTIPLE")) {
			this.respuestas = new ArrayList<>();
		}
		this.respuestas = respuestas;
	}

	@Override
	public String toString() {
		return "{\"idTarjeta\":\"" + idTarjeta + "\", \"tipoRespuesta\":\"" + tipoRespuesta + "\", \"idJugador\":\""
				+ idJugador + "\", \"nombreMazo\":\"" + nombreMazo + "\", \"mazo\":\"" + mazo + "\"}";
	}


}
