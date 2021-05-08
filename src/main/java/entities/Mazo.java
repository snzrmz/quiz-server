package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@NamedQueries({
    @NamedQuery(name = "Mazo.getAll", query = "SELECT m "
    		+ "FROM Mazo m"),
    @NamedQuery(name = "Mazo.getFrom", query = "SELECT m "
    		+ "FROM Mazo m "
    		+ "WHERE jugador.idJugador = :idJugador")
})
@XmlRootElement
public class Mazo implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private String nombre;
	@ManyToOne
	//omitimos la columna referenciada al llamarse igual
    @JoinColumn(name="idJugador")
	@Id
	private Jugador jugador;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Jugador getJugador() {
		return jugador;
	}
	
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public Mazo(String nombre, Jugador jugador) {
		super();
		this.nombre = nombre;
		this.jugador = jugador;
	}
	public Mazo() {
		
	}
	/*@Override
	public String toString() {
		return "{\"nombre\":\"" + nombre + "\", \"jugador\":\"" + jugador.getIdJugador() + "\"}";
	}*/
	

}