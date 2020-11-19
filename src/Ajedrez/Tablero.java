package Ajedrez;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Tablero extends JFrame {
	/**
	 * Lisatado de las casillas que componen el tablero
	 */
	Casilla tablero[][] = new Casilla[8][8];// array con nombre tablero y con variables de tipo casilla
	Pieza pieza;
	JButton boton;
	// 8x8= 64 lugares en el array

	public Tablero() {

		setTitle("Ajedrez");
		setBounds(0, 500, 600, 600);
		setVisible(true);
		

		Container contentpane = getContentPane();
		contentpane.setLayout(new GridLayout(8, 8));

		agregarCasillas();
		for (int f = 0; f < tablero.length; f++) {// recorre todo el array con 64 casillas (de 0 a 63)
			for (int c = 0; c < tablero[f].length; c++) {
				String posicion = tablero[f][c].getNombre();

				if ((f % 2 == 0 && c % 2 != 0) || (f % 2 != 0 && c % 2 == 0)) {

					contentpane.add(boton = new JButton());
					boton.setBackground(Color.black);

				} else {
					contentpane.add(boton = new JButton());
					boton.setBackground(Color.white);
				}

				agregarFicha(f, c,posicion);

			}
		}
	}

	
	public void agregarFicha(int f, int c ,String posicion) {
		if (f == 1) {
			ImageIcon peonNegro = new ImageIcon("./img/piezasNegras/peon.png");
			
			boton.setIcon(peonNegro);
			pieza = new Pieza("negro", "peon",posicion, true);
			tablero[f][c].setCasillaOcupada(true);
		} else if (f == 6) {
			ImageIcon peonBlanco = new ImageIcon("./img/piezasBlancas/peon.png");
			boton.setIcon(peonBlanco);
			pieza = new Pieza("blanca", "peon",posicion, true);
			tablero[f][c].setCasillaOcupada(true);
		} else if (c == 0 || c == 7) {
			if (f == 0) {
				ImageIcon torreNegro = new ImageIcon("./img/piezasNegras/torre.png");
				boton.setIcon(torreNegro);
				pieza = new Pieza("negro", "torre",posicion, true);
				tablero[f][c].setCasillaOcupada(true);
			} else if (f == 7) {
				ImageIcon torreBlanco = new ImageIcon("./img/piezasBlancas/torre.png");
				boton.setIcon(torreBlanco);
				pieza = new Pieza("blanco", "torre",posicion, true);
				tablero[f][c].setCasillaOcupada(true);
			}
		} else if (c == 1 || c == 6) {
			if (f == 0) {
				ImageIcon caballoNegro = new ImageIcon("./img/piezasNegras/caballo.png");
				boton.setIcon(caballoNegro);
				pieza = new Pieza("negro", "caballo",posicion, true);
				tablero[f][c].setCasillaOcupada(true);
			} else if (f == 7) {
				ImageIcon caballoBlanco = new ImageIcon("./img/piezasBlancas/caballo.png");
				boton.setIcon(caballoBlanco);
				pieza = new Pieza("blanco", "caballo",posicion, true);
				tablero[f][c].setCasillaOcupada(true);
			}
		} else if (c == 2 || c == 5) {
			if (f == 0) {
				ImageIcon alfilNegro = new ImageIcon("./img/piezasNegras/alfil.png");
				boton.setIcon(alfilNegro);
				pieza = new Pieza("negro", "alfil",posicion, true);
				tablero[f][c].setCasillaOcupada(true);
			} else if (f == 7) {
				ImageIcon alfilBlanco = new ImageIcon("./img/piezasBlancas/alfil.png");
				boton.setIcon(alfilBlanco);
				pieza = new Pieza("blanca", "alfil",posicion, true);
				tablero[f][c].setCasillaOcupada(true);
			}
		} else if (c == 3) {
			if (f == 0) {
				ImageIcon reinaNegro = new ImageIcon("./img/piezasNegras/reina.png");
				boton.setIcon(reinaNegro);
				pieza = new Pieza("negro", "reina",posicion, true);
				tablero[f][c].setCasillaOcupada(true);
			} else if (f == 7) {
				ImageIcon reinaBlanco = new ImageIcon("./img/piezasBlancas/reina.png");
				boton.setIcon(reinaBlanco);
				pieza = new Pieza("blanca", "reina",posicion, true);
				tablero[f][c].setCasillaOcupada(true);
			}
		} else if (c == 4) {
			if (f == 0) {
				ImageIcon reyNegro = new ImageIcon("./img/piezasNegras/rey.png");
				boton.setIcon(reyNegro);
				pieza = new Pieza("negro", "rey",posicion, true);
				tablero[f][c].setCasillaOcupada(true);
			} else if (f == 7) {
				ImageIcon reyBlanco = new ImageIcon("./img/piezasBlancas/rey.png");
				boton.setIcon(reyBlanco);
				pieza = new Pieza("blanca", "rey",posicion, true);
				tablero[f][c].setCasillaOcupada(true);
			}
		}

	}

	public void agregarCasillas() {// metodo de añadir Casillas al ARRAY

		for (int f = 0; f < tablero.length; f++) {// para recorrer las filas
			for (int c = 0; c < tablero[f].length; c++) {// para recorrer las columnas
				Casilla casilla = new Casilla();// por cada iteracion se crea una nueva casilla donde:

				if ((f % 2 == 0 && c % 2 != 0) || (f % 2 != 0 && c % 2 == 0)) {// si de la manera N-N una de ellas es
																				// par y la otra impar
																				// independientemente del orden:
					casilla.setColor("negro");// la casilla sera negra
					
				} else {
					casilla.setColor("blanco");// si no se cumple eso , es decir ambos N-N son o par o impar, la casilla
												// sera blanca

				}
				casilla.setPosicion(Integer.toString(f) + "-" + Integer.toString(c));// aqui se escribe la posicion de
																						// la casilla que sera en N-N y
																						// se pasa a string
				char letra = (char) (65 + f);// usamos el ASCII ya que 64+f al principio sera A despues B, despues C...
												// asi para asignar las FILAS
				casilla.setNombre(Character.toString(letra) + Integer.toString(c));// aqui se unen las filas en letra
																					// con su columna Por ejemplo la
																					// primera sera A1 y la ultima H8

				tablero[f][c] = casilla;// se añade esta casilla al ARRAy tablero y tendremos en total 64 casillas
			}
		}

	}

	public void getCasillas() {// metodo para obtener todas las casillas creadas

		for (int f = 0; f < tablero.length; f++) {// recorre todo el array con 64 casillas (de 0 a 63)
			System.out.println();
			for (int c = 0; c < tablero[f].length; c++) {

				/*
				 * if (tablero[f][c].getColor()=="negro") { System.out.print("⬛"); }else
				 * if(tablero[f][c].getColor()=="blanco"){ System.out.print("      "); }
				 */

				System.out.print(tablero[f][c].getNombre() + "-" + tablero[f][c].getColor() + " | ");
			}
		}
	}

}
