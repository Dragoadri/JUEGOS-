package Ajedrez;

public class Pieza {
	private String color;
	private String nombrePieza;
	private String posicion;
	private boolean viva;


	

	public Pieza(String color, String nombrePieza, String posicion, boolean viva) {
		super();
		this.color = color;
		this.nombrePieza = nombrePieza;
		this.posicion = posicion;
		this.viva = viva;
	}
	

	public String getPosicion() {
		return posicion;
	}


	public void setPosicion(String posicion) {
		this.posicion = posicion;
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
