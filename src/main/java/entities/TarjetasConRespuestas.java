package entities;

public class TarjetasConRespuestas {

	/*
	 * https://stackoverflow.com/a/49489179
	 */

	private int idTarjeta;
	private String tipoRespuesta;
	private int idJugador;
	private String pregunta;
	private String valor;
	private int correcta;

	public TarjetasConRespuestas(int idTarjeta, String tipoRespuesta, int idJugador, String pregunta, String valor, int correcta) {
		this.idTarjeta = idTarjeta;
		this.tipoRespuesta = tipoRespuesta;
		this.idJugador = idJugador;
		this.pregunta = pregunta;
		this.valor = valor;
		this.correcta = correcta;
	}
	public TarjetasConRespuestas() {

	}

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

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public int getCorrecta() {
		return correcta;
	}

	public void setCorrecta(int correcta) {
		this.correcta = correcta;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
