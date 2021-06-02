package entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
@Entity
@XmlRootElement
@NamedQuery( name = "Repaso.getById", query = "SELECT r FROM Repaso r WHERE r.idRepaso = :idRepaso")
public class Repaso implements Serializable {

	private static final long serialVersionUID = 1L;

	public Repaso() {
		
	}
	
	
	public Repaso(int idRepaso, boolean fin, int idJugador, LocalDateTime fechaHoraInicio, String nombreMazo,
			List<Tarjeta_Repaso_Acertado> tarjetaRepasoAcertado, List<Tarjeta_Repaso_Fallado> tarjetaRepasoFallado) {
		this.idRepaso = idRepaso;
		this.fin = fin;
		this.idJugador = idJugador;
		this.fechaHoraInicio = fechaHoraInicio;
		this.nombreMazo = nombreMazo;
		this.tarjetaRepasoAcertado = tarjetaRepasoAcertado;
		this.tarjetaRepasoFallado = tarjetaRepasoFallado;
	}


	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRepaso;
	
	@Override
	public String toString() {
		return "{\"idRepaso\":\"" + idRepaso + "\", \"fin\":\"" + fin + "\", \"idJugador\":\"" + idJugador
				+ "\", \"fechaHoraInicio\":\"" + fechaHoraInicio + "\", \"nombreMazo\":\"" + nombreMazo
				+ "\", \"tarjetaRepasoAcertado\":\"" + tarjetaRepasoAcertado + "\", \"tarjetaRepasoFallado\":\""
				+ tarjetaRepasoFallado + "\"}";
	}
	private boolean fin;
	
	
	private int idJugador;
	
	
	@Column(name = "fechaHoraInicio", columnDefinition = "DATETIME" )
	private LocalDateTime fechaHoraInicio;
	private String nombreMazo;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy="repaso")
	private List<Tarjeta_Repaso_Acertado> tarjetaRepasoAcertado = new ArrayList<>();

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade = CascadeType.ALL, mappedBy="repaso")
	private List<Tarjeta_Repaso_Fallado> tarjetaRepasoFallado = new ArrayList<>();
	
	public boolean isFin() {
		return fin;
	}
	public void setFin(boolean fin) {
		this.fin = fin;
	}
	public LocalDateTime getFechaHoraInicio() {
		return fechaHoraInicio;
	}
	public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
		this.fechaHoraInicio = fechaHoraInicio;
	}
	public int getIdRepaso() {
		return idRepaso;
	}
	public void setIdRepaso(int idRepaso) {
		this.idRepaso = idRepaso;
	}
	public String getNombreMazo() {
		return nombreMazo;
	}
	public void setNombreMazo(String nombreMazo) {
		this.nombreMazo = nombreMazo;
	}
	public int getIdJugador() {
		return idJugador;
	}
	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}
	public List<Tarjeta_Repaso_Acertado> getTarjetaRepasoAcertado() {
		return tarjetaRepasoAcertado;
	}
	public void setTarjetaRepasoAcertado(List<Tarjeta_Repaso_Acertado> tarjetaRepasoAcertado) {
		this.tarjetaRepasoAcertado = tarjetaRepasoAcertado;
	}
	public List<Tarjeta_Repaso_Fallado> getTarjetaRepasoFallado() {
		return tarjetaRepasoFallado;
	}
	public void setTarjetaRepasoFallado(List<Tarjeta_Repaso_Fallado> tarjetaRepasoFallado) {
		this.tarjetaRepasoFallado = tarjetaRepasoFallado;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaHoraInicio == null) ? 0 : fechaHoraInicio.hashCode());
		result = prime * result + (fin ? 1231 : 1237);
		result = prime * result + idJugador;
		result = prime * result + idRepaso;
		result = prime * result + ((nombreMazo == null) ? 0 : nombreMazo.hashCode());
		result = prime * result + ((tarjetaRepasoAcertado == null) ? 0 : tarjetaRepasoAcertado.hashCode());
		result = prime * result + ((tarjetaRepasoFallado == null) ? 0 : tarjetaRepasoFallado.hashCode());
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
		Repaso other = (Repaso) obj;
		if (fechaHoraInicio == null) {
			if (other.fechaHoraInicio != null)
				return false;
		} else if (!fechaHoraInicio.equals(other.fechaHoraInicio))
			return false;
		if (fin != other.fin)
			return false;
		if (idJugador != other.idJugador)
			return false;
		if (idRepaso != other.idRepaso)
			return false;
		if (nombreMazo == null) {
			if (other.nombreMazo != null)
				return false;
		} else if (!nombreMazo.equals(other.nombreMazo))
			return false;
		if (tarjetaRepasoAcertado == null) {
			if (other.tarjetaRepasoAcertado != null)
				return false;
		} else if (!tarjetaRepasoAcertado.equals(other.tarjetaRepasoAcertado))
			return false;
		if (tarjetaRepasoFallado == null) {
			if (other.tarjetaRepasoFallado != null)
				return false;
		} else if (!tarjetaRepasoFallado.equals(other.tarjetaRepasoFallado))
			return false;
		return true;
	}

	

}
