package Ajedrez;

import javax.swing.ImageIcon;

public class Pieza {
	private String color;
	private String nombrePieza;
	private String posicion;
	private int fila;
	private int columna;
	private ImageIcon Imagen;
	private boolean viva;

	public Pieza(String color, String nombrePieza, String posicion,int fila,int columna) {
		super();
		this.color = color;
		this.nombrePieza = nombrePieza;
		this.posicion = posicion;
		this.fila = fila;
		this.columna =columna;
		this.viva = true;
		if (color.equals("negro")) {
			if (nombrePieza.equals("peon")) {
				this.Imagen = new ImageIcon("./img/piezasNegras/peon.png");
			} else if (nombrePieza.equals("torre")) {
				this.Imagen = new ImageIcon("./img/piezasNegras/torre.png");
			} else if (nombrePieza.equals("caballo")) {
				this.Imagen = new ImageIcon("./img/piezasNegras/caballo.png");
			} else if (nombrePieza.equals("alfil")) {
				this.Imagen = new ImageIcon("./img/piezasNegras/alfil.png");
			} else if (nombrePieza.equals("reina")) {
				this.Imagen = new ImageIcon("./img/piezasNegras/reina.png");
			} else if (nombrePieza.equals("rey")) {
				this.Imagen = new ImageIcon("./img/piezasNegras/rey.png");
			}
		} else if (color.equals("blanco")) {
			if (nombrePieza.equals("peon")) {
				this.Imagen = new ImageIcon("./img/piezasBlancas/peon.png");
			} else if (nombrePieza.equals("torre")) {
				this.Imagen = new ImageIcon("./img/piezasBlancas/torre.png");
			} else if (nombrePieza.equals("caballo")) {
				this.Imagen = new ImageIcon("./img/piezasBlancas/caballo.png");
			} else if (nombrePieza.equals("alfil")) {
				this.Imagen = new ImageIcon("./img/piezasBlancas/alfil.png");
			} else if (nombrePieza.equals("reina")) {
				this.Imagen = new ImageIcon("./img/piezasBlancas/reina.png");
			} else if (nombrePieza.equals("rey")) {
				this.Imagen = new ImageIcon("./img/piezasBlancas/rey.png");
			}
		} else {
			this.Imagen = new ImageIcon("./img/color/transparencia.png");
		}

	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
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
