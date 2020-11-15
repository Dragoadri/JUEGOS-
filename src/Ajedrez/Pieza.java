package Ajedrez;

public class Pieza {
	private String color;
	private String nombrePieza;
	private boolean viva;

	public Pieza(String color, String nombrePieza, boolean viva) {
		this.color = color;
		this.nombrePieza = nombrePieza;
		this.viva = viva;
	}

	public String getNombrePieza() {
		return nombrePieza;
	}

	public void setNombrePieza(String nombrePieza) {
		this.nombrePieza = nombrePieza;
	}

	public boolean isViva() {
		return viva;
	}

	public void setViva(boolean viva) {
		this.viva = viva;
	}

	public String getColor() {
		return color;
	}

}
