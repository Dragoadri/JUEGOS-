package Buscaminas;

import javax.swing.JButton;

/**
 * 
 * @author Adrian Cañadas
 *
 */
public class Casilla {
	
	private int fila;
	private int columna;
	private caso contenido;
	private JButton boton;
	
	public Casilla(int fila , int columna,String nombreContenido) {
		this.fila=fila;
		this.columna=columna;
		char simbolo=' ';
		boolean esMina=false;

		if (nombreContenido.equals("mina")) {
			simbolo='@';
			esMina=true;
		}else {
			simbolo=' ';
			esMina=false;
		}
		this.contenido= new caso(nombreContenido, simbolo, esMina);
		this.boton= new JButton(fila+"-"+columna);
		
		
	}
	public Casilla(int fila , int columna) {
		this.fila=fila;
		this.columna=columna;
		char simbolo=' ';
		boolean esMina=false;

	
		this.contenido= new caso("nada", simbolo, esMina);
		this.boton= new JButton(fila+"-"+columna);
		
		
	}
	public JButton getBoton() {
		return boton;
	}
	public caso getContenido() {
		return contenido;
	}
	
}
