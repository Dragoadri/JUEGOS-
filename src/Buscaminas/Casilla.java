

package Buscaminas;

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
	
	
	

	public Casilla(int fila , int columna,caso contenido) {
		this.fila=fila;
		this.columna=columna;
		this.setContenido(contenido);
		this.boton= new JButton(fila+"-"+columna);
		this.boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(getContenido().getSimbolo());
			}
		});
		
	}
	
	
	public void setContenido(caso contenido) {
		this.contenido = contenido;
	}


	public void actualizarBot() {
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
	
}



