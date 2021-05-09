package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class MazoPK implements Serializable {
	private static final long serialVersionUID = 1L;

	protected int idJugador;
	protected String nombre;

	public MazoPK() {
	}

	public MazoPK(int idJugador, String nombre) {
		this.idJugador = idJugador;
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idJugador;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		MazoPK other = (MazoPK) obj;
		if (idJugador != other.idJugador)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}