package Buscaminas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabGraf extends JFrame {

	private JPanel contentPane;
	private Casilla [][]casilla;
	private int filas;
	private int columnas;
	private int minas;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public TabGraf(int filas,int columnas,int minas) {
		this.filas=filas;
		this.columnas=columnas;
		this.minas=minas;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(filas, columnas));
		casilla= new Casilla[filas][columnas];
		ponerBotones();
		rellenarTablero();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		colocar();
		
	}
	
	public void ponerBotones() {
		for (int f = 0; f < casilla.length; f++) {
			for (int c = 0; c < casilla[0].length; c++) {
				casilla[f][c]=new Casilla(f, c,new caso("nada", 'n', false));
				//contentPane.add(casilla[f][c].getBoton());
			}
		}
	}
public void colocar() {
	for (int f = 0; f < casilla.length; f++) {
		for (int c = 0; c < casilla[0].length; c++) {
			contentPane.add(casilla[f][c].getBoton());
		}}
	
}
	public void rellenarTablero() {
		for (int i = 0; i < this.minas; i++) {
			int f = 0;
			int c = 0;
			do {
				f = (int) (Math.random() * (this.casilla.length - 1 + 1 - 1)) + 1;
				c = (int) (Math.random() * (this.casilla[0].length - 1 + 1 - 1)) + 1;

			} while (casilla[f][c].getContenido().isEsMina());
			casilla[f][c].setContenido(new caso("mina", '@', true));
			contentPane.add(casilla[f][c].getBoton());

		}

		for (int i = 0; i < casilla.length; i++) {
			for (int j = 0; j < casilla[i].length; j++) {

				if (casilla[i][j].getContenido().getNombre().equals("nada"))

				{
					int contMinas = 0;
					contentPane.add(casilla[i][j].getBoton());
					try {
						if (casilla[i - 1][j].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
						
					}
					try {
						if (casilla[i + 1][j].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					try {
						if (casilla[i - 1][j - 1].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					try {
						if (casilla[i - 1][j + 1].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					try {
						if (casilla[i + 1][j - 1].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					try {
						if (casilla[i + 1][j + 1].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					try {
						if (casilla[i][j + 1].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					try {
						if (casilla[i][j - 1].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					if (contMinas != 0) {
						//casilla[i][j].getContenido().setSimbolo(Integer.toString(contMinas).charAt(0));
						casilla[i][j].setContenido(new caso("numero", Integer.toString(contMinas).charAt(0), false));
						
					}

				}
				this.casilla[i][j].actualizarBot();
			}
		}

	}
	public Casilla[][] getCasilla() {
		return casilla;
	}
	
	
}
