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
	public static Casilla tablero[][] = new Casilla[8][8];// array con nombre tablero y con variables de tipo casilla
	public static Pieza piezas[] = new Pieza[33];
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

		peonesNegros();

		torresNegros();

		caballosNegros();

		alfilesNegros();

		reinaNegro();

		reyNegro();

		peonesBlancos();

		torresBlancos();

		caballosBlancos();

		alfilesBlancos();

		reinaBlanco();

		reyBlanco();

		piezas[32] = new Pieza("...", "...", "...", null, false);

	}

	public void reyBlanco() {
		ImageIcon imgReyBlanco = new ImageIcon("./img/piezasBlancas/rey.png");
		piezas[31] = new Pieza("blanco", "rey", "7-4", imgReyBlanco, true);

	}

	public void reinaBlanco() {
		ImageIcon imgReinaBlanco = new ImageIcon("./img/piezasBlancas/reina.png");
		piezas[30] = new Pieza("blanco", "reina", "7-3", imgReinaBlanco, true);
	}

	public void alfilesBlancos() {
		for (int i = 28; i < 30; i++) {
			String posicion;
			if (i == 28) {
				posicion = "7-2";
			} else {
				posicion = "7-5";
			}
			ImageIcon imgAlfilBlanco = new ImageIcon("./img/piezasBlancas/alfil.png");
			piezas[i] = new Pieza("blanco", "alfil", posicion, imgAlfilBlanco, true);

		}
	}

	public void caballosBlancos() {
		for (int i = 26; i < 28; i++) {
			String posicion;
			if (i == 26) {
				posicion = "7-1";
			} else {
				posicion = "7-6";
			}
			ImageIcon imgCaballoBlanco = new ImageIcon("./img/piezasBlancas/caballo.png");
			piezas[i] = new Pieza("blanco", "caballo", posicion, imgCaballoBlanco, true);

		}
	}

	public void torresBlancos() {
		for (int i = 24; i < 26;i++) {
			String posicion = "7-0";
			if (i == 25) {
				posicion = "7-7";
			}
			ImageIcon imgTorreBlanco = new ImageIcon("./img/piezasBlancas/torre.png");
			piezas[i] = new Pieza("blanco", "torre", posicion, imgTorreBlanco, true);
			
			
		}
	}

	public void peonesBlancos() {
		for (int i = 16; i < 24; i++) {

			String posicion = "6-" + Integer.toString(i - 16);
			ImageIcon imgPeonBlanco = new ImageIcon("./img/piezasBlancas/peon.png");
			piezas[i] = new Pieza("blanco", "peon", posicion, imgPeonBlanco, true);

		}

	}

	public void peonesNegros() {
		for (int i = 0; i < 8; i++) {

			String posicion = "1-" + Integer.toString(i);
			ImageIcon imgPeonNegro = new ImageIcon("./img/piezasNegras/peon.png");
			piezas[i] = new Pieza("negro", "peon", posicion, imgPeonNegro, true);

		}

	}

	public void torresNegros() {
		for (int i = 8; i < 10; i++) {
			String posicion;
			if (i == 9) {
				posicion = "0-0";
			} else {
				posicion = "0-7";
			}
			ImageIcon imgTorreNegro = new ImageIcon("./img/piezasNegras/torre.png");
			piezas[i] = new Pieza("negro", "torre", posicion, imgTorreNegro, true);
		}
	}

	public void caballosNegros() {
		for (int i = 10; i < 12; i++) {
			String posicion;
			if (i == 10) {
				posicion = "0-1";
			} else {
				posicion = "0-6";
			}
			ImageIcon imgCaballoNegro = new ImageIcon("./img/piezasNegras/caballo.png");
			piezas[i] = new Pieza("negro", "caballo", posicion, imgCaballoNegro, true);

		}
	}

	public void alfilesNegros() {
		for (int i = 12; i < 14; i++) {
			String posicion;
			if (i == 12) {
				posicion = "0-2";
			} else {
				posicion = "0-5";
			}
			ImageIcon imgAlfilNegro = new ImageIcon("./img/piezasNegras/alfil.png");
			piezas[i] = new Pieza("negro", "alfil", posicion, imgAlfilNegro, true);

		}
	}

	public void reinaNegro() {
		ImageIcon imgReinaNegro = new ImageIcon("./img/piezasNegras/reina.png");
		piezas[14] = new Pieza("negro", "reina", "0-3", imgReinaNegro, true);
	}

	public void reyNegro() {
		ImageIcon imgReyNegro = new ImageIcon("./img/piezasNegras/rey.png");
		piezas[15] = new Pieza("negro", "rey", "0-3", imgReyNegro, true);
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

		for (int f = 0; f < tablero.length; f++) {// recorre todo el array con 64 casillas (de 0 a 63)
			for (int c = 0; c < tablero[f].length; c++) {
				String posicion = tablero[f][c].getNombre();

				if ((f % 2 == 0 && c % 2 != 0) || (f % 2 != 0 && c % 2 == 0)) {

					contentpane.add(boton[f][c] = new JButton());
					boton[f][c].setBackground(Color.black);
					tablero[f][c].setColor("negro");

				} else {
					contentpane.add(boton[f][c] = new JButton());
					boton[f][c].setBackground(Color.white);
					tablero[f][c].setColor("blanco");
				}

				agregarFicha(f, c, posicion);
				tablero[f][c].setPosicion(Integer.toString(f) + "-" + Integer.toString(c));

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
			for (int i = 0; i < 8; i++) {

				boton[f][c].setIcon(piezas[i].getImagen());
				tablero[f][c].setCasillaOcupada(true);
				tablero[f][c].setPieza(piezas[i]);
			}
		} else if (f == 6) {
			for (int i = 16; i < 24; i++) {
				boton[f][c].setIcon(piezas[i].getImagen());
				tablero[f][c].setCasillaOcupada(true);
				tablero[f][c].setPieza(piezas[i]);
			}
		} else if (c == 0 || c == 7) {
			if (f == 0) {

				for (int i = 8; i < 10; i++) {
					boton[f][c].setIcon(piezas[i].getImagen());

					tablero[f][c].setCasillaOcupada(true);
					tablero[f][c].setPieza(piezas[i]);
				}
			} else if (f == 7) {
				for (int i = 24; i < 26; i++) {
					boton[f][c].setIcon(piezas[i].getImagen());

					tablero[f][c].setCasillaOcupada(true);
					tablero[f][c].setPieza(piezas[i]);
				}
			} else {

				tablero[f][c].setCasillaOcupada(false);
				tablero[f][c].setPieza(piezas[32]);
			}

		} else if (c == 1 || c == 6) {
			if (f == 0) {
				for (int i = 10; i < 12; i++) {
					boton[f][c].setIcon(piezas[i].getImagen());
					tablero[f][c].setCasillaOcupada(true);
					tablero[f][c].setPieza(piezas[i]);
				}
			} else if (f == 7) {
				for (int i = 26; i < 28; i++) {
					boton[f][c].setIcon(piezas[i].getImagen());

					tablero[f][c].setCasillaOcupada(true);
					tablero[f][c].setPieza(piezas[i]);
				}
			} else {

				tablero[f][c].setCasillaOcupada(false);
				tablero[f][c].setPieza(piezas[32]);
			}

		} else if (c == 2 || c == 5) {
			if (f == 0) {
				for (int i = 12; i < 14; i++) {
					boton[f][c].setIcon(piezas[i].getImagen());

					tablero[f][c].setCasillaOcupada(true);
					tablero[f][c].setPieza(piezas[i]);
				}
			} else if (f == 7) {
				for (int i = 28; i < 30; i++) {
					boton[f][c].setIcon(piezas[i].getImagen());

					tablero[f][c].setCasillaOcupada(true);
					tablero[f][c].setPieza(piezas[i]);
				}
			} else {

				tablero[f][c].setCasillaOcupada(false);
				tablero[f][c].setPieza(piezas[32]);
			}

		} else if (c == 3) {
			if (f == 0) {
				boton[f][c].setIcon(piezas[14].getImagen());
				tablero[f][c].setCasillaOcupada(true);
				tablero[f][c].setPieza(piezas[14]);
			} else if (f == 7) {
				boton[f][c].setIcon(piezas[30].getImagen());

				tablero[f][c].setCasillaOcupada(true);
				tablero[f][c].setPieza(piezas[30]);
			} else {

				tablero[f][c].setCasillaOcupada(false);
				tablero[f][c].setPieza(piezas[32]);
			}

		} else if (c == 4) {
			if (f == 0) {
				boton[f][c].setIcon(piezas[15].getImagen());

				tablero[f][c].setCasillaOcupada(true);
				tablero[f][c].setPieza(piezas[15]);
			} else if (f == 7) {
				boton[f][c].setIcon(piezas[31].getImagen());

				tablero[f][c].setCasillaOcupada(true);
				tablero[f][c].setPieza(piezas[31]);
			} else {

				tablero[f][c].setCasillaOcupada(false);
				tablero[f][c].setPieza(piezas[32]);
			}

		}

	}

	/**
	 * Crea las casillas y las asigna cual es la posicion de 2 maneras , metodo
	 * numerico (N-N) y metodo letras (A0)
	 */
	public void crearCasillas() {// metodo de crear Casillas en el ARRAY

		for (int f = 0; f < tablero.length; f++) {// para recorrer las filas
			for (int c = 0; c < tablero[f].length; c++) {// para recorrer las columnas

				Casilla casilla = new Casilla();
				if ((f % 2 == 0 && c % 2 != 0) || (f % 2 != 0 && c % 2 == 0)) {// si de la manera N-N una de ellas es
																				// par y la otra impar
					casilla.setColor("negro");// la casilla sera negra// independientemente del orden:

				} else {
					casilla.setColor("blanco");
					// si no se cumple eso , es decir ambos N-N son o par o impar, la casilla
					// sera blanca

				}
				casilla.setPosicion(Integer.toString(f) + "-" + Integer.toString(c));
				// aqui se escribe la posicion de
				// la casilla que sera en N-N y
				// se pasa a string
				char letra = (char) (65 + f);// usamos el ASCII ya que 64+f al principio sera A despues B, despues C...
				String nombre = Character.toString(letra) + Integer.toString(c);

				casilla.setNombre(nombre);// asi para asignar las FILAS
				// aqui se unen las filas en letra
				// con su columna Por ejemplo la
				// primera sera A1 y la ultima H8

				tablero[f][c] = casilla;// se añade esta casilla al ARRAy tablero y tendremos en total 64 casillas
			}
		}

	}

	/**
	 * Metodo para controlar POR CONSOLA cada casilla
	 */
	public void getCasillas() {// metodo para obtener todas las casillas creadas

		for (int f = 0; f < tablero.length; f++) {// recorre todo el array con 64 casillas (de 0 a 63)
			System.out.println();
			for (int c = 0; c < tablero[f].length; c++) {

				/*
				 * if (tablero[f][c].getColor()=="negro") { System.out.print("⬛"); }else
				 * if(tablero[f][c].getColor()=="blanco"){ System.out.print("      "); }
				 */

				System.out.print(tablero[f][c].getPieza().getPosicion()+ "|");

			}
		}

	}

	public static Casilla[][] getTablero() {
		return tablero;
	}

	public static Pieza[] getPiezas() {
		return piezas;
	}

	public static JButton getBoton(int f, int c) {
		return boton[f][c];
	}

}
