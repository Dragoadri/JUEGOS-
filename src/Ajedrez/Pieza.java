package Ajedrez;

import javax.swing.ImageIcon;

public class Pieza {
	private String color;
	private String nombrePieza;
	private String posicion;
	private ImageIcon Imagen;
	private boolean viva;

	public Pieza(String color, String nombrePieza, ImageIcon imagen) {
		
		this.color = color;
		this.nombrePieza = nombrePieza;

		Imagen = imagen;

	}

	public ImageIcon getImagen() {
		return Imagen;
	}

	public void setImagen(ImageIcon imagen) {
		Imagen = imagen;
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
