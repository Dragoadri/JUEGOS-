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
	public static Casilla casilla[][] = new Casilla[8][8];// array con nombre tablero y con variables de tipo casilla
	public static JButton[][] boton = new JButton[8][8];

	public Tablero() {

		setTitle("Ajedrez");
		setBounds(0, 500, 600, 600);
		setVisible(true);
		crearCasillas();// crea las casillas el array
		crearPiezas();
		colocarCasillas();// crea el boton de cada casilla y su color
		getCasillas();
	}

	/**
	 * crea todas las piezas del ajedrez con sus atributos color,nombre e imagen de
	 * la pieza
	 */
	public void crearPiezas() {

	}

	/**
	 * añade una imagen de la pieza que introduzcas en la casilla que introduzcas
	 * 
	 * @param f
	 * @param c
	 * @param pieza
	 */
	public void aniadirFichaRandom(int f, int c, Pieza pieza) {

		boton[f][c].setIcon(pieza.getImagen());
	}

	/**
	 * Coloca las casillas, las colorea y ademas tambien se agregan las fichas a
	 * cada casilla
	 */
	public void colocarCasillas() {
		Container contentpane = getContentPane();
		contentpane.setLayout(new GridLayout(8, 8));

		for (int f = 0; f < casilla.length; f++) {// recorre todo el array con 64 casillas (de 0 a 63)
			for (int c = 0; c < casilla[f].length; c++) {
				String posicion = casilla[f][c].getPosicion();

				if ((f % 2 == 0 && c % 2 != 0) || (f % 2 != 0 && c % 2 == 0)) {

					contentpane.add(boton[f][c] = new JButton());
					boton[f][c].setBackground(Color.black);
					casilla[f][c].setColor("negro");

				} else {
					contentpane.add(boton[f][c] = new JButton());
					boton[f][c].setBackground(Color.white);
					casilla[f][c].setColor("blanco");
				}

				agregarFicha(f, c, posicion);
				casilla[f][c].setPosicion(Integer.toString(f) + "-" + Integer.toString(c));

			}
		}
	}

	/**
	 * Se agregan las fichas al tablero POR PRIMERA VEZ y se les asigna una
	 * posicion, el estado VIVA y se marca la casilla como OCUPADA
	 * 
	 * @param f
	 * @param c
	 * @param posicion
	 */
	public void agregarFicha(int f, int c, String posicion) {

		if (f == 1) {
			casilla[f][c].setPieza(new Pieza("negro", "peon", posicion));
		} else if (f == 6) {
			casilla[f][c].setPieza(new Pieza("blanco", "peon", posicion));
		} else if (f == 0 && (c == 0 || c == 7)) {
			casilla[f][c].setPieza(new Pieza("negro", "torre", posicion));
		} else if (f == 7 && (c == 0 || c == 7)) {
			casilla[f][c].setPieza(new Pieza("blanco", "torre", posicion));
		} else if (f == 0 && (c == 1 || c == 6)) {
			casilla[f][c].setPieza(new Pieza("negro", "caballo", posicion));
		} else if (f == 7 && (c == 1 || c == 6)) {
			casilla[f][c].setPieza(new Pieza("blanco", "caballo", posicion));
		} else if (f == 0 && (c == 2 || c == 5)) {
			casilla[f][c].setPieza(new Pieza("negro", "alfil", posicion));
		} else if (f == 7 && (c == 2 || c == 5)) {
			casilla[f][c].setPieza(new Pieza("blanco", "alfil", posicion));
		} else if (c == 3) {
			if (f == 0) {
				casilla[f][c].setPieza(new Pieza("negro", "reina", posicion));
			} else if (f == 7) {
				casilla[f][c].setPieza(new Pieza("blanco", "reina", posicion));
			}
		} else if (c == 4) {
			if (f == 0) {
				casilla[f][c].setPieza(new Pieza("negro", "rey", posicion));
			} else if (f == 7) {
				casilla[f][c].setPieza(new Pieza("blanco", "rey", posicion));
			}
		} else {
			//cuando la casilla esta vacia
		}
		boton[f][c].setIcon(casilla[f][c].getPieza().getImagen());
	}

	/**
	 * Crea las casillas y las asigna cual es la posicion de 2 maneras , metodo
	 * numerico (N-N) y metodo letras (A0)
	 */
	public void crearCasillas() {// metodo de crear Casillas en el ARRAY

		for (int f = 0; f < casilla.length; f++) {// para recorrer las filas
			for (int c = 0; c < casilla[f].length; c++) {// para recorrer las columnas

				Casilla cas = new Casilla();
				if ((f % 2 == 0 && c % 2 != 0) || (f % 2 != 0 && c % 2 == 0)) {// si de la manera N-N una de ellas es
																				// par y la otra impar
					cas.setColor("negro");// la casilla sera negra// independientemente del orden:

				} else {
					cas.setColor("blanco");
					// si no se cumple eso , es decir ambos N-N son o par o impar, la casilla
					// sera blanca

				}
				cas.setPosicion(Integer.toString(f) + "-" + Integer.toString(c));
				// aqui se escribe la posicion de
				// la casilla que sera en N-N y
				// se pasa a string
				char letra = (char) (65 + f);// usamos el ASCII ya que 64+f al principio sera A despues B, despues C...
				String nombre = Character.toString(letra) + Integer.toString(c);

				cas.setNombre(nombre);// asi para asignar las FILAS
				// aqui se unen las filas en letra
				// con su columna Por ejemplo la
				// primera sera A1 y la ultima H8

				casilla[f][c] = cas;// se añade esta casilla al ARRAy tablero y tendremos en total 64 casillas
			}
		}

	}

	/**
	 * Metodo para controlar POR CONSOLA cada casilla
	 */
	public void getCasillas() {// metodo para obtener todas las casillas creadas

		for (int f = 0; f < casilla.length; f++) {// recorre todo el array con 64 casillas (de 0 a 63)
			System.out.println();
			for (int c = 0; c < casilla[f].length; c++) {

				/*
				 * if (tablero[f][c].getColor()=="negro") { System.out.print("⬛"); }else
				 * if(tablero[f][c].getColor()=="blanco"){ System.out.print("      "); }
				 */

				// System.out.print(casilla[f][c].getPosicion()+ "|");

			}
		}
		System.out.println(casilla[7][5].getPieza().getNombrePieza() + casilla[7][5].getPieza().getPosicion());
		System.out.println(casilla[7][2].getPieza().getNombrePieza() + casilla[7][2].getPieza().getPosicion());
	}

	public static Casilla[][] getTablero() {
		return casilla;
	}

	public static JButton getBoton(int f, int c) {
		return boton[f][c];
	}

}
