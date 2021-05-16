package entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@NamedQueries({
    @NamedQuery(name = "Jugador.findOne", query = "SELECT j FROM Jugador j WHERE j.idJugador = :idJugador"),
    @NamedQuery(name = "Jugador.findOneByEmail", query = "SELECT j FROM Jugador j WHERE j.email = :email")
}
)
@XmlRootElement
public class Jugador implements Serializable {



	private static final long serialVersionUID = 1L;
	//idJugador es autogenerado por el sgbd
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idJugador;
	private String email;
	private String usuario;
	private String contrasena;
	@JsonbDateFormat(value = "yyyy-MM-dd")
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
	
	public Jugador(int idJugador, String email, String usuario, String contrasena, @JsonbProperty("fechaCreacion") LocalDate fechaCreacion) {
		this.idJugador = idJugador;
		this.email = email;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.fechaCreacion = fechaCreacion;
		
	}
	public Jugador() {
		
	}
	@Override
	public String toString() {
		return "{\"idJugador\":\"" + idJugador + "\", \"email\":\"" + email + "\", \"usuario\":\"" + usuario
				+ "\", \"contrasena\":\"" + contrasena + "\", \"fechaCreacion\":\"" + fechaCreacion + "\"}";
	}

	

}
