package entities;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@NamedQueries({
    @NamedQuery(name = "Jugador.findOne", query = "select j from Jugador j where j.idJugador = :idJugador"),
    @NamedQuery(name = "Jugador.getAll", query = "select j from Jugador j")
}
)
@XmlRootElement
public class Jugador implements Serializable {
	private static final long serialVersionUID = 1L;
	//idJugador es autogenerado por el sgbd
	@Id @GeneratedValue 
	private int idJugador;
	private String email;
	private String usuario;
	private String contrasena;
	private LocalDate fechaCreacion;

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Override
	public String toString() {
		return "{\"idJugador\":\"" + idJugador + "\", \"email\":\"" + email + "\", \"usuario\":\"" + usuario
				+ "\", \"contrasena\":\"" + contrasena + "\", \"fechaCreacion\":\"" + fechaCreacion + "\"}";
	}

	

}
