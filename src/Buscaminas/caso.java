package Buscaminas;

import javax.swing.ImageIcon;

/**
 * 
 * @author Adrian Cañadas
 *
 */
public class caso {
	private String nombre;
	private char simbolo;
	private boolean esMina;
	private boolean visible;
	private ImageIcon Imagen;


	public caso(String nombre, char simbolo, boolean esMina) {
		this.nombre = nombre;
		this.simbolo = simbolo;
		this.esMina = esMina;
		this.visible=false;
		if (esMina) {
			this.Imagen=new ImageIcon("./img/mina/mina.png");
			
		}
	}

	public String getNombre() {
		return nombre;
	}

	public char getSimbolo() {
		return simbolo;
	}

	public boolean isEsMina() {
		return esMina;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}

	public ImageIcon getImagen() {
		return Imagen;
	}

	
}
