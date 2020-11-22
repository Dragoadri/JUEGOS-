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
	public static Pieza piezas[] = new Pieza[13];
	public static JButton[][] boton = new JButton[8][8];

	public Tablero() {

		setTitle("Ajedrez");
		setBounds(0, 500, 600, 600);
		setVisible(true);
		crearCasillas();// crea las casillas el array
		crearPiezas();
		colocarCasillas();// crea el boton de cada casilla y su color
		
	}

	/**
	 * crea todas las piezas del ajedrez con sus atributos color,nombre e imagen de
	 * la pieza
	 */
	public void crearPiezas() {

		ImageIcon imgPeonNegro = new ImageIcon("./img/piezasNegras/peon.png");
		Pieza peonNegro = new Pieza("negro", "peon", imgPeonNegro);

		ImageIcon imgPeonBlanco = new ImageIcon("./img/piezasBlancas/peon.png");
		Pieza peonBlanco = new Pieza("blanca", "peon", imgPeonBlanco);

		ImageIcon imgTorreNegro = new ImageIcon("./img/piezasNegras/torre.png");
		Pieza torreNegro = new Pieza("negro", "torre", imgTorreNegro);

		ImageIcon imgTorreBlanco = new ImageIcon("./img/piezasBlancas/torre.png");
		Pieza torreBlanco = new Pieza("blanco", "torre", imgTorreBlanco);

		ImageIcon imgCaballoNegro = new ImageIcon("./img/piezasNegras/caballo.png");
		Pieza caballoNegro = new Pieza("negro", "caballo", imgCaballoNegro);

		ImageIcon imgCaballoBlanco = new ImageIcon("./img/piezasBlancas/caballo.png");
		Pieza caballoBlanco = new Pieza("blanco", "caballo", imgCaballoBlanco);

		ImageIcon imgAlfilNegro = new ImageIcon("./img/piezasNegras/alfil.png");
		Pieza alfilNegro = new Pieza("negro", "alfil", imgAlfilNegro);

		ImageIcon imgAlfilBlanco = new ImageIcon("./img/piezasBlancas/alfil.png");
		Pieza alfilBlanco = new Pieza("blanca", "alfil", imgAlfilBlanco);

		ImageIcon imgReinaNegro = new ImageIcon("./img/piezasNegras/reina.png");
		Pieza reinaNegro = new Pieza("negro", "reina", imgReinaNegro);

		ImageIcon imgReinaBlanco = new ImageIcon("./img/piezasBlancas/reina.png");
		Pieza reinaBlanco = new Pieza("blanca", "reina", imgReinaBlanco);

		ImageIcon imgReyNegro = new ImageIcon("./img/piezasNegras/rey.png");
		Pieza reyNegro = new Pieza("negro", "rey", imgReyNegro);

		ImageIcon imgReyBlanco = new ImageIcon("./img/piezasBlancas/rey.png");
		Pieza reyBlanco = new Pieza("blanca", "rey", imgReyBlanco);

		ImageIcon imgVacio = new ImageIcon("...");
		Pieza vacio = new Pieza("none", "...", null);

		for (int i = 0; i < piezas.length; i++) {
			switch (i) {

			case 0:
				piezas[i] = peonNegro;
				break;

			case 1:
				piezas[i] = peonBlanco;
				break;

			case 2:
				piezas[i] = torreNegro;
				break;
			case 3:
				piezas[i] = torreBlanco;
				break;
			case 4:
				piezas[i] = caballoNegro;
				break;
			case 5:
				piezas[i] = caballoBlanco;
				break;
			case 6:
				piezas[i] = alfilNegro;
				break;
			case 7:
				piezas[i] = alfilBlanco;
				break;
			case 8:
				piezas[i] = reinaNegro;
				break;
			case 9:
				piezas[i] = reinaBlanco;
				break;
			case 10:
				piezas[i] = reyNegro;
				break;
			case 11:
				piezas[i] = reyBlanco;
				break;
			case 12:
				piezas[i] = vacio;
				break;

			}
		}
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
			boton[f][c].setIcon(piezas[0].getImagen());
			piezas[0].setPosicion(posicion);
			piezas[0].setViva(true);
			tablero[f][c].setCasillaOcupada(true);
			tablero[f][c].setPieza(piezas[0]);
		} else if (f == 6) {
			boton[f][c].setIcon(piezas[1].getImagen());
			piezas[1].setPosicion(posicion);
			piezas[1].setViva(true);
			tablero[f][c].setCasillaOcupada(true);
			tablero[f][c].setPieza(piezas[1]);
		} else if (c == 0 || c == 7) {
			if (f == 0) {
				boton[f][c].setIcon(piezas[2].getImagen());
				piezas[2].setPosicion(posicion);
				piezas[2].setViva(true);
				tablero[f][c].setCasillaOcupada(true);
				tablero[f][c].setPieza(piezas[2]);
			} else if (f == 7) {
				boton[f][c].setIcon(piezas[3].getImagen());
				piezas[3].setPosicion(posicion);
				piezas[3].setViva(true);
				tablero[f][c].setCasillaOcupada(true);
				tablero[f][c].setPieza(piezas[3]);
			} else {

				piezas[12].setPosicion(posicion);
				piezas[12].setViva(false);
				tablero[f][c].setCasillaOcupada(false);
				tablero[f][c].setPieza(piezas[12]);
			}

		} else if (c == 1 || c == 6) {
			if (f == 0) {
				boton[f][c].setIcon(piezas[4].getImagen());
				piezas[4].setPosicion(posicion);
				piezas[4].setViva(true);
				tablero[f][c].setCasillaOcupada(true);
				tablero[f][c].setPieza(piezas[4]);
			} else if (f == 7) {
				boton[f][c].setIcon(piezas[5].getImagen());
				piezas[5].setPosicion(posicion);
				piezas[5].setViva(true);
				tablero[f][c].setCasillaOcupada(true);
				tablero[f][c].setPieza(piezas[5]);
			} else {

				piezas[12].setPosicion(posicion);
				piezas[12].setViva(false);
				tablero[f][c].setCasillaOcupada(false);
				tablero[f][c].setPieza(piezas[12]);
			}

		} else if (c == 2 || c == 5) {
			if (f == 0) {
				boton[f][c].setIcon(piezas[6].getImagen());
				piezas[6].setPosicion(posicion);
				piezas[6].setViva(true);
				tablero[f][c].setCasillaOcupada(true);
				tablero[f][c].setPieza(piezas[6]);
			} else if (f == 7) {
				boton[f][c].setIcon(piezas[7].getImagen());
				piezas[7].setPosicion(posicion);
				piezas[7].setViva(true);
				tablero[f][c].setCasillaOcupada(true);
				tablero[f][c].setPieza(piezas[7]);
			} else {

				piezas[12].setPosicion(posicion);
				piezas[12].setViva(false);
				tablero[f][c].setCasillaOcupada(false);
				tablero[f][c].setPieza(piezas[12]);
			}

		} else if (c == 3) {
			if (f == 0) {
				boton[f][c].setIcon(piezas[8].getImagen());
				piezas[8].setPosicion(posicion);
				piezas[8].setViva(true);
				tablero[f][c].setCasillaOcupada(true);
				tablero[f][c].setPieza(piezas[8]);
			} else if (f == 7) {
				boton[f][c].setIcon(piezas[9].getImagen());
				piezas[9].setPosicion(posicion);
				piezas[9].setViva(true);
				tablero[f][c].setCasillaOcupada(true);
				tablero[f][c].setPieza(piezas[9]);
			} else {

				piezas[12].setPosicion(posicion);
				piezas[12].setViva(false);
				tablero[f][c].setCasillaOcupada(false);
				tablero[f][c].setPieza(piezas[12]);
			}

		} else if (c == 4) {
			if (f == 0) {
				boton[f][c].setIcon(piezas[10].getImagen());
				piezas[10].setPosicion(posicion);
				piezas[10].setViva(true);
				tablero[f][c].setCasillaOcupada(true);
				tablero[f][c].setPieza(piezas[10]);
			} else if (f == 7) {
				boton[f][c].setIcon(piezas[11].getImagen());
				piezas[11].setPosicion(posicion);
				piezas[11].setViva(true);
				tablero[f][c].setCasillaOcupada(true);
				tablero[f][c].setPieza(piezas[11]);
			} else {

				piezas[12].setPosicion(posicion);
				piezas[12].setViva(false);
				tablero[f][c].setCasillaOcupada(false);
				tablero[f][c].setPieza(piezas[12]);
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

				//System.out.print(tablero[f][c].getNombre() + "," + tablero[f][c].getPosicion() + ","
						//+ tablero[f][c].getPieza().getNombrePieza() + "-" + tablero[f][c].getPieza().getColor());

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
