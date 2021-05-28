package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
@Entity
@XmlRootElement
@NamedQuery( name = "Repaso.getById", query = "SELECT r FROM Repaso r WHERE r.idRepaso = :idRepaso")
public class Repaso implements Serializable {

	private static final long serialVersionUID = 1L;

	public Repaso() {
		super();
		this.tarjetaRepasoAcertado = new ArrayList<>();
		this.tarjetaRepasoFallado = new ArrayList<>();
	}
	@Id
	private int idRepaso;
	
	private boolean fin;
	
	@ManyToOne
	@JoinColumn(name = "idJugador", referencedColumnName = "idJugador", insertable = false, updatable = false)
	private Jugador jugador;
	
	private int idJugador;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "idJugador", referencedColumnName = "idJugador", insertable = false, updatable = false),
		@JoinColumn(name = "nombreMazo", referencedColumnName = "nombre", insertable = false, updatable = false) })
	private Mazo mazo;
	private LocalDate fechaHoraInicio;
	private String nombreMazo;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="repaso")
	private List<Tarjeta_Repaso_Acertado> tarjetaRepasoAcertado;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="repaso")
	private List<Tarjeta_Repaso_Fallado> tarjetaRepasoFallado;
	
	
	
	public boolean isFin() {
		return fin;
	}
	public void setFin(boolean fin) {
		this.fin = fin;
	}
	public LocalDate getFechaHoraInicio() {
		return fechaHoraInicio;
	}
	public void setFechaHoraInicio(LocalDate fechaHoraInicio) {
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

	

}
