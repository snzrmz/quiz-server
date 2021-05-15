package entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@XmlRootElement
@NamedQuery( name = "Repaso.getById", query = "SELECT r FROM Repaso r WHERE r.idRepaso = :idRepaso")
public class Repaso implements Serializable {

	private static final long serialVersionUID = 1L;

	public Repaso() {
		
	}
	@Id
	private int idRepaso;
	
	private boolean fin;
	
	@ManyToOne
	@JoinColumn(name = "idJugador", referencedColumnName = "idJugador", insertable = false, updatable = false)
	private Jugador jugador;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name = "idJugador", referencedColumnName = "idJugador", insertable = false, updatable = false),
		@JoinColumn(name = "nombreMazo", referencedColumnName = "nombre", insertable = false, updatable = false) })
	private Mazo mazo;
	private LocalDate fechaHoraInicio;
	
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
	
	

}
