

package Buscaminas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private Juego j;
	
	public Casilla(int fila , int columna,caso contenido,Juego j) {
		this.fila=fila;
		this.columna=columna;
		this.setContenido(contenido);
		this.j=j;
		this.boton= new JButton();
		//Color verde
		this.boton.setBackground(new Color(40, 139, 48));
		this.boton.setFont(new Font("arial", Font.PLAIN, 20));
	}
	
	
	public void setContenido(caso contenido) {
		this.contenido = contenido;
	}


	public void actualizarBot() {
		this.getContenido().setVisible(true);
		this.boton.setText(""+this.contenido.getSimbolo());
	}

	public JButton getBoton() {
		return boton;
	}
	public caso getContenido() {
		return contenido;
	}
	public int getFila() {
		return fila;
	}
	public int getColumna() {
		return columna;
	}


	public Juego getJ() {
		return j;
	}
	
}



