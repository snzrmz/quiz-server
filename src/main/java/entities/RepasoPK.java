package entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;

@Embeddable
public class RepasoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idJugador;
	private String nombreMazo;
	private LocalDate fechaHoraInicio;
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
	public LocalDate getFechaHoraInicio() {
		return fechaHoraInicio;
	}
	public void setFechaHoraInicio(LocalDate fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * 
	 */
	public RepasoPK() {
		
	}

	public RepasoPK(int idJugador, String nombreMazo, LocalDate fechaHoraInicio) {
		this.idJugador = idJugador;
		this.nombreMazo = nombreMazo;
		this.fechaHoraInicio = fechaHoraInicio;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaHoraInicio == null) ? 0 : fechaHoraInicio.hashCode());
		result = prime * result + idJugador;
		result = prime * result + ((nombreMazo == null) ? 0 : nombreMazo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RepasoPK other = (RepasoPK) obj;
		if (fechaHoraInicio == null) {
			if (other.fechaHoraInicio != null)
				return false;
		} else if (!fechaHoraInicio.equals(other.fechaHoraInicio))
			return false;
		if (idJugador != other.idJugador)
			return false;
		if (nombreMazo == null) {
			if (other.nombreMazo != null)
				return false;
		} else if (!nombreMazo.equals(other.nombreMazo))
			return false;
		return true;
	}
	
	
}
