package Ajedrez;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Juego {
	private static int turno = 1;

	public Juego() {

		Tablero t1 = new Tablero();
		moverPieza();

	}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	// SOLUCIONADO
	public void moverPieza() {
		escucharFichasTurno();
	}

	private class aDondePuedoMoverFicha implements ActionListener {// Muestra donde se puede mover la ficha y puedes
																	// pulsar el boton azul para mover la ficha a dicho
																	// sitio
		int f;
		int c;
		int fBoton;
		int cBoton;

		public aDondePuedoMoverFicha(int f, int c) {
			this.f = f;
			this.c = c;
		}

		public aDondePuedoMoverFicha(int f, int c, int fBoton, int cBoton) {
			super();
			this.f = f;
			this.c = c;
			this.fBoton = fBoton;
			this.cBoton = cBoton;
		}

		public void actionPerformed(ActionEvent e) {
			System.out.println("Has pulsado el boton " + Tablero.casilla[f][c].getPieza().getPosicion());

			if (Tablero.casilla[f][c].getPieza().getNombrePieza().equals("peon")
					&& Tablero.casilla[f][c].getPieza().getColor().equals("negro") && getTurno() == 2) {

				movPeonNegro(f, c, Tablero.casilla[f][c].getPieza());

			} else if (Tablero.casilla[f][c].getPieza().getNombrePieza().equals("peon")
					&& Tablero.casilla[f][c].getPieza().getColor().equals("blanco") && getTurno() == 1) {

				movPeonBlanco(f, c, Tablero.casilla[f][c].getPieza());

			} else if (Tablero.casilla[f][c].getPieza().getNombrePieza().equals("torre")) {
				movTorre(f, c);
			} else if (Tablero.casilla[f][c].getPieza().getNombrePieza().equals("caballo")) {
				movCaballo(f, c);
			} else if (Tablero.casilla[f][c].getPieza().getNombrePieza().equals("alfil")) {
				movAlfil(f, c);
			} else if (Tablero.casilla[f][c].getPieza().getNombrePieza().equals("reina")) {
				movReina(f, c);
			} else if (Tablero.casilla[f][c].getPieza().getNombrePieza().equals("rey")) {
				movRey(f, c);
			}

			// Cambiar ficha de posicion a una que esta VACIA
			else if (Tablero.casilla[f][c].getPieza().getNombrePieza().equals("...")
					&& Tablero.boton[f][c].getBackground().equals(Color.blue)) {

				// mover
				Pieza p1 = Tablero.casilla[fBoton][cBoton].getPieza();// pieza que Quieres mover
				Pieza p2 = Tablero.casilla[f][c].getPieza();// casilla Vacia

				intercambiarFichasConPiezaNull(f, c, fBoton, cBoton, p1, p2);
				casillasEnBlancoYNegro();
				/*
				 * Tablero.boton[f][c].setBackground(Color.green);// A la casilla a la que
				 * quieres mover Tablero.boton[fBoton][cBoton].setBackground(Color.green);// la
				 * casilla donde esta la pieza que quieres
				 * 
				 * Tablero.casilla[f][c].setPieza(Tablero.casilla[fBoton][cBoton].getPieza());
				 * Tablero.casilla[f][c].getPieza().setFila(f);
				 * Tablero.casilla[f][c].getPieza().setColumna(c);
				 * Tablero.boton[f][c].setIcon(Tablero.casilla[fBoton][cBoton].getPieza().
				 * getImagen());
				 */

			}

		}
	}

	private class comerBoton implements ActionListener {
		// Posicion de la ficha que queremos comer
		int f;
		int c;
		// Posicion de la ficha que va a comer Y SE VA A SUSTITUIR POR UNA CASILLA VACIA
		int fBoton;
		int cBoton;

		public comerBoton(int f, int c, int fBoton, int cBoton) {
			super();
			// Posicion de la ficha que queremos comer
			this.f = f;
			this.c = c;
			// Posicion de la ficha que va a comer Y SE VA A SUSTITUIR POR UNA CASILLA VACIA
			this.fBoton = fBoton;
			this.cBoton = cBoton;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			if (Tablero.casilla[fBoton][cBoton].getPieza().getColor().equals("blanco")
					&& Tablero.casilla[f][c].getPieza().getColor().equals("negro")
					&& Tablero.boton[f][c].getBackground().equals(Color.red)) {

				System.out.println("Has pulsado el boton " + Tablero.casilla[f][c].getPieza().getPosicion());

				Pieza p1 = getPieza( fBoton, cBoton);// pieza que va a comer
				Pieza p2 = getPieza( f, c);// Pieza que va ase comida

				comerFicha(f, c, fBoton, cBoton, p1, p2);
				casillasEnBlancoYNegro();
			}
		}
	}

	public void intercambiarFichasConPiezaNull(int f, int c, int fBoton, int cBoton, Pieza p1, Pieza p2) {
		// A la casilla donde se quiere mover la ficha

		ponerFichaEnCasilla(f, c, p1);

		// La casilla donde estaba la ficha donde habra que poner un vacio o Ficha null
		ponerFichaEnCasilla(fBoton, cBoton, p2);

		escucharFichasTurno();
	}

	public void comerFicha(int f, int c, int fBoton, int cBoton, Pieza p1, Pieza p2) {

		System.out.println(p1.getPosicion() + "-" + p1.getNombrePieza());// la ficha que come
		System.out.println(p2.getPosicion() + "-" + p2.getNombrePieza());// la ficha que es comida

		System.out.println(f + "-" + c);// ficha que se van a comer
		System.out.println(fBoton + "-" + cBoton);// ficha que come

		ponerFichaEnCasilla(f, c, p1);

		p2 = new Pieza("...", "...", fBoton, cBoton);

		ponerFichaEnCasilla(fBoton, cBoton, p2);

		// problema cuando llega a un peon sin moverse , el intercambio se produce con
		// la torre 0-0 negra
		// ***************************************************************************************************
		escucharFichasTurno();
		
	}

	public void movPeonNegro(int f, int c, Pieza peonNegro) {// falta poner cuando puede comer el peon

		Pieza p = Tablero.casilla[f][c].getPieza();

		Tablero.boton[f + 1][c].setBackground(Color.blue);
		Tablero.boton[f + 2][c].setBackground(Color.blue);
		Tablero.boton[f + 1][c].addActionListener(new aDondePuedoMoverFicha(f + 1, c, f, c));
		Tablero.boton[f + 2][c].addActionListener(new aDondePuedoMoverFicha(f + 2, c, f, c));
		cambiarTurno();
	}

	public void movPeonBlanco(int f, int c, Pieza peonBlanco) {//// falta poner cuando puede comer el peon
		if (f==0) {
			cambiarTurno();
		}
		
		if ((f > 0) && (Tablero.casilla[f - 1][c].getPieza().getNombrePieza().equals("..."))) {

			Tablero.boton[f - 1][c].setBackground(Color.blue);
			Tablero.boton[f - 2][c].setBackground(Color.blue);
			Tablero.boton[f - 1][c].addActionListener(new aDondePuedoMoverFicha(f - 1, c, f, c));
			Tablero.boton[f - 2][c].addActionListener(new aDondePuedoMoverFicha(f - 2, c, f, c));
			cambiarTurno();
		}
		// Parte de comer
		// CAMBIAR!**************************************************************************************************************************
		if ((c > 0 && f > 0) && (Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
				&& Tablero.casilla[f - 1][c - 1].getPieza().getColor().equals("negro"))) {

			Tablero.boton[f - 1][c - 1].setBackground(Color.red);

			Tablero.boton[f - 1][c - 1].addActionListener(new comerBoton(f - 1, c - 1, f, c));// ESTE

		}
		if ((c < 7 && f > 0) && (Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
				&& Tablero.casilla[f - 1][c + 1].getPieza().getColor().equals("negro"))) {
			Tablero.boton[f - 1][c + 1].setBackground(Color.red);
			Tablero.boton[f - 1][c + 1].addActionListener(new comerBoton(f - 1, c + 1, f, c));// ESTE

		}

	}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	
	public Pieza getPieza(int f,int c) {
		return Tablero.casilla[f][c].getPieza();
	}
	
	
	public void escucharFichasTurno() {

		for (int f = 0; f < Tablero.casilla.length; f++) {// recorre todo el array con 64 casillas (de 0 a 63)
			for (int c = 0; c < Tablero.casilla[f].length; c++) {
				if ((getTurno() == 1) && Tablero.casilla[f][c].getPieza().getColor().equals("blanco")) {

					Tablero.boton[f][c].addActionListener(new aDondePuedoMoverFicha(f, c));

				} else if ((getTurno() == 2) && Tablero.casilla[f][c].getPieza().getColor().equals("negro")) {
					Tablero.boton[f][c].addActionListener(new aDondePuedoMoverFicha(f, c));
				}

			}
		}

	}

	public void ponerFichaEnCasilla(int f, int c, Pieza P) {

		Tablero.casilla[f][c].setPieza(P);
		Tablero.casilla[f][c].getPieza().setFila(f);
		Tablero.casilla[f][c].getPieza().setColumna(c);
		Tablero.casilla[f][c].getPieza().setPosicion(f, c);
		Tablero.boton[f][c].setIcon(P.getImagen());

	}

	public void cambiarTurno() {
		if (getTurno() == 1) {
			setTurno(2);
		} else {
			setTurno(1);
		}
	}

	public void casillasEnBlancoYNegro() {
		for (int i = 0; i < Tablero.casilla.length; i++) {
			for (int j = 0; j < Tablero.casilla[i].length; j++) {
				if ((i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0)) {
					Tablero.boton[i][j].setBackground(Color.black);
				} else {
					Tablero.boton[i][j].setBackground(Color.white);
				}
			}
		}
	}

	public static void movTorre(int f, int c) {

		for (int i = 1; i < Tablero.casilla[f].length - Tablero.casilla[f][c].getPieza().getColumna(); i++) {
			if (Tablero.casilla[f][c + i].getPieza().getNombrePieza().equals("...")) {

				Tablero.boton[f][c + i].setBackground(Color.blue);
			} else if (Tablero.casilla[f][c].getPieza().getColor()
					.equals(Tablero.casilla[f][c + i].getPieza().getColor())) {

				i = 7;
			} else if ((Tablero.casilla[f][c].getPieza().getColor().equals("negro")
					&& Tablero.casilla[f][c + i].getPieza().getColor().equals("blanco"))
					|| (Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
							&& Tablero.casilla[f][c + i].getPieza().getColor().equals("negro"))) {
				Tablero.boton[f][c + i].setBackground(Color.red);
				i = 7;
			}
		}
		for (int i = 1; i <= Tablero.casilla[f][c].getPieza().getColumna(); i++) {
			if (Tablero.casilla[f][c - i].getPieza().getNombrePieza().equals("...")) {

				Tablero.boton[f][c - i].setBackground(Color.blue);
			} else if (Tablero.casilla[f][c].getPieza().getColor()
					.equals(Tablero.casilla[f][c - i].getPieza().getColor())) {

				i = 7;
			} else if ((Tablero.casilla[f][c].getPieza().getColor().equals("negro")
					&& Tablero.casilla[f][c - i].getPieza().getColor().equals("blanco"))
					|| (Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
							&& Tablero.casilla[f][c - i].getPieza().getColor().equals("negro"))) {
				Tablero.boton[f][c - i].setBackground(Color.red);
				i = 7;
			}
		}
		for (int i = 1; i < Tablero.casilla[f].length - Tablero.casilla[f][c].getPieza().getFila(); i++) {
			if (Tablero.casilla[f + i][c].getPieza().getNombrePieza().equals("...")) {

				Tablero.boton[f + i][c].setBackground(Color.blue);
			} else if (Tablero.casilla[f][c].getPieza().getColor()
					.equals(Tablero.casilla[f + i][c].getPieza().getColor())) {

				i = 7;
			} else if ((Tablero.casilla[f][c].getPieza().getColor().equals("negro")
					&& Tablero.casilla[f + i][c].getPieza().getColor().equals("blanco"))
					|| (Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
							&& Tablero.casilla[f + i][c].getPieza().getColor().equals("negro"))) {
				Tablero.boton[f + i][c].setBackground(Color.red);
				i = 7;
			}
		}
		for (int i = 1; i <= Tablero.casilla[f][c].getPieza().getFila(); i++) {
			if (Tablero.casilla[f - i][c].getPieza().getNombrePieza().equals("...")) {

				Tablero.boton[f - i][c].setBackground(Color.blue);
			} else if (Tablero.casilla[f][c].getPieza().getColor()
					.equals(Tablero.casilla[f - i][c].getPieza().getColor())) {

				i = 7;
			} else if ((Tablero.casilla[f][c].getPieza().getColor().equals("negro")
					&& Tablero.casilla[f - i][c].getPieza().getColor().equals("blanco"))
					|| (Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
							&& Tablero.casilla[f - i][c].getPieza().getColor().equals("negro"))) {
				Tablero.boton[f - i][c].setBackground(Color.red);
				i = 7;
			}
		}
	}

	public static void movCaballo(int f, int c) {

		if (c > 0 && f < 6 && Tablero.casilla[f + 2][c - 1].getPieza().getNombrePieza().equals("...")) {
			Tablero.boton[f + 2][c - 1].setBackground(Color.blue);

		} else if ((c > 0 && f < 6) && (Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
				&& Tablero.casilla[f + 2][c - 1].getPieza().getColor().equals("negro")
				|| Tablero.casilla[f][c].getPieza().getColor().equals("negro")
						&& Tablero.casilla[f + 2][c - 1].getPieza().getColor().equals("blanco"))) {
			Tablero.boton[f + 2][c - 1].setBackground(Color.red);
		}
		if (c > 0 && f > 1 && Tablero.casilla[f - 2][c - 1].getPieza().getNombrePieza().equals("...")) {
			Tablero.boton[f - 2][c - 1].setBackground(Color.blue);

		} else if ((c > 0 && f > 1) && (Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
				&& Tablero.casilla[f - 2][c - 1].getPieza().getColor().equals("negro")
				|| Tablero.casilla[f][c].getPieza().getColor().equals("negro")
						&& Tablero.casilla[f - 2][c - 1].getPieza().getColor().equals("blanco"))) {
			Tablero.boton[f - 2][c - 1].setBackground(Color.red);
		}

		if (c < 7 && f < 6 && Tablero.casilla[f + 2][c + 1].getPieza().getNombrePieza().equals("...")) {
			Tablero.boton[f + 2][c + 1].setBackground(Color.blue);

		} else if ((c < 7 && f < 6) && (Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
				&& Tablero.casilla[f + 2][c + 1].getPieza().getColor().equals("negro")
				|| Tablero.casilla[f][c].getPieza().getColor().equals("negro")
						&& Tablero.casilla[f + 2][c + 1].getPieza().getColor().equals("blanco"))) {
			Tablero.boton[f + 2][c + 1].setBackground(Color.red);
		}
		if (c < 7 && f > 1 && Tablero.casilla[f - 2][c + 1].getPieza().getNombrePieza().equals("...")) {
			Tablero.boton[f - 2][c + 1].setBackground(Color.blue);

		} else if ((c < 7 && f > 1) && (Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
				&& Tablero.casilla[f - 2][c + 1].getPieza().getColor().equals("negro")
				|| Tablero.casilla[f][c].getPieza().getColor().equals("negro")
						&& Tablero.casilla[f - 2][c + 1].getPieza().getColor().equals("blanco"))) {
			Tablero.boton[f - 2][c + 1].setBackground(Color.red);
		}
		if (c < 6 && f < 7 && Tablero.casilla[f + 1][c + 2].getPieza().getNombrePieza().equals("...")) {
			Tablero.boton[f + 1][c + 2].setBackground(Color.blue);

		} else if ((c < 6 && f < 7) && (Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
				&& Tablero.casilla[f + 1][c + 2].getPieza().getColor().equals("negro")
				|| Tablero.casilla[f][c].getPieza().getColor().equals("negro")
						&& Tablero.casilla[f + 1][c + 2].getPieza().getColor().equals("blanco"))) {
			Tablero.boton[f + 1][c + 2].setBackground(Color.red);
		}
		if (c > 1 && f < 7 && Tablero.casilla[f + 1][c - 2].getPieza().getNombrePieza().equals("...")) {
			Tablero.boton[f + 1][c - 2].setBackground(Color.blue);

		} else if ((c > 1 && f < 7) && (Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
				&& Tablero.casilla[f + 1][c - 2].getPieza().getColor().equals("negro")
				|| Tablero.casilla[f][c].getPieza().getColor().equals("negro")
						&& Tablero.casilla[f + 1][c - 2].getPieza().getColor().equals("blanco"))) {
			Tablero.boton[f + 1][c - 2].setBackground(Color.red);
		}
		if (c > 1 && f > 0 && Tablero.casilla[f - 1][c - 2].getPieza().getNombrePieza().equals("...")) {
			Tablero.boton[f - 1][c - 2].setBackground(Color.blue);

		} else if ((c > 1 && f > 0) && (Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
				&& Tablero.casilla[f - 1][c - 2].getPieza().getColor().equals("negro")
				|| Tablero.casilla[f][c].getPieza().getColor().equals("negro")
						&& Tablero.casilla[f - 1][c - 2].getPieza().getColor().equals("blanco"))) {
			Tablero.boton[f - 1][c - 2].setBackground(Color.red);
		}
		if (c < 6 && f > 0 && Tablero.casilla[f - 1][c + 2].getPieza().getNombrePieza().equals("...")) {
			Tablero.boton[f - 1][c + 2].setBackground(Color.blue);

		} else if ((c < 6 && f > 0) && (Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
				&& Tablero.casilla[f - 1][c + 2].getPieza().getColor().equals("negro")
				|| Tablero.casilla[f][c].getPieza().getColor().equals("negro")
						&& Tablero.casilla[f - 1][c + 2].getPieza().getColor().equals("blanco"))) {
			Tablero.boton[f - 1][c + 2].setBackground(Color.red);
		}
	}

	public static void movAlfil(int f, int c) {

		for (int i = 1; i < Tablero.casilla[f].length; i++) {
			if ((c < 7 && f < 7) && (Tablero.casilla[f + i][c + i].getPieza().getColumna() > 7
					|| Tablero.casilla[f + i][c + i].getPieza().getFila() > 7)) {
				Tablero.boton[f + i][c + i].setBackground(Color.blue);
				i = Tablero.casilla[f].length;

			} else if ((c < 7 && f < 7) && (Tablero.casilla[f + i][c + i].getPieza().getNombrePieza().equals("..."))) {
				Tablero.boton[f + i][c + i].setBackground(Color.blue);
			} else if ((c < 7 && f < 7) && ((Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
					&& Tablero.casilla[f + i][c + i].getPieza().getColor().equals("negro"))
					|| (Tablero.casilla[f][c].getPieza().getColor().equals("negro")
							&& Tablero.casilla[f + i][c + i].getPieza().getColor().equals("blanco")))) {
				Tablero.boton[f + i][c + i].setBackground(Color.red);
				i = Tablero.casilla[f].length;
			} else {
				i = Tablero.casilla[f].length;
			}

		}
		for (int i = 1; i < Tablero.casilla[f].length; i++) {
			if ((c > 0 && f < 7) && (Tablero.casilla[f + i][c - i].getPieza().getColumna() < 0
					|| Tablero.casilla[f + i][c - i].getPieza().getFila() > 7)) {
				i = Tablero.casilla[f].length;
			} else if ((c > 0 && f < 7) && (Tablero.casilla[f + i][c - i].getPieza().getNombrePieza().equals("..."))) {
				Tablero.boton[f + i][c - i].setBackground(Color.blue);
			} else if ((c > 0 && f < 7) && ((Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
					&& Tablero.casilla[f + i][c - i].getPieza().getColor().equals("negro"))
					|| (Tablero.casilla[f][c].getPieza().getColor().equals("negro")
							&& Tablero.casilla[f + i][c - i].getPieza().getColor().equals("blanco")))) {
				Tablero.boton[f + i][c - i].setBackground(Color.red);
				i = Tablero.casilla[f].length;
			} else {
				i = Tablero.casilla[f].length;
			}

		}
		for (int i = 1; i < Tablero.casilla[f].length; i++) {
			if ((c < 7 && f > 0) && (Tablero.casilla[f - i][c + i].getPieza().getColumna() > 7
					|| Tablero.casilla[f - i][c + i].getPieza().getFila() < 0)) {
				i = Tablero.casilla[f].length;
			} else if ((c < 7 && f > 0) && (Tablero.casilla[f - i][c + i].getPieza().getNombrePieza().equals("..."))) {
				Tablero.boton[f - i][c + i].setBackground(Color.blue);
			} else if ((c < 7 && f > 0) && ((Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
					&& Tablero.casilla[f - i][c + i].getPieza().getColor().equals("negro"))
					|| (Tablero.casilla[f][c].getPieza().getColor().equals("negro")
							&& Tablero.casilla[f - i][c + i].getPieza().getColor().equals("blanco")))) {
				Tablero.boton[f - i][c + i].setBackground(Color.red);
				i = Tablero.casilla[f].length;
			} else {

				i = Tablero.casilla[f].length;
			}

		}
		for (int i = 1; i < Tablero.casilla[f].length; i++) {
			if ((c > 0 && f > 0) && (Tablero.casilla[f - i][c - i].getPieza().getColumna() < 0
					|| Tablero.casilla[f - i][c - i].getPieza().getFila() < 0)) {
				i = Tablero.casilla[f].length;
			} else if ((c > 0 && f > 0) && (Tablero.casilla[f - i][c - i].getPieza().getNombrePieza().equals("..."))) {
				Tablero.boton[f - i][c - i].setBackground(Color.blue);
			} else if ((c > 0 && f > 0) && ((Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
					&& Tablero.casilla[f - i][c - i].getPieza().getColor().equals("negro"))
					|| (Tablero.casilla[f][c].getPieza().getColor().equals("negro")
							&& Tablero.casilla[f - i][c - i].getPieza().getColor().equals("blanco")))) {
				Tablero.boton[f - i][c - i].setBackground(Color.red);
				i = Tablero.casilla[f].length;
			} else {
				i = Tablero.casilla[f].length;
			}

		}

	}

	public static void movReina(int f, int c) {

		movTorre(f, c);
		movAlfil(f, c);

	}

	public static void movRey(int f, int c) {

		if (f < 7 && Tablero.casilla[f + 1][c].getPieza().getNombrePieza().equals("...")) {
			Tablero.boton[f + 1][c].setBackground(Color.blue);
		} else if ((f < 7) && ((Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
				&& Tablero.casilla[f + 1][c].getPieza().getColor().equals("negro"))
				|| (Tablero.casilla[f][c].getPieza().getColor().equals("negro")
						&& Tablero.casilla[f + 1][c].getPieza().getColor().equals("blanco")))) {
			Tablero.boton[f + 1][c].setBackground(Color.red);
		}
		if (f > 0 && Tablero.casilla[f - 1][c].getPieza().getNombrePieza().equals("...")) {
			Tablero.boton[f - 1][c].setBackground(Color.blue);
		} else if ((f > 0) && ((Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
				&& Tablero.casilla[f - 1][c].getPieza().getColor().equals("negro"))
				|| (Tablero.casilla[f][c].getPieza().getColor().equals("negro")
						&& Tablero.casilla[f - 1][c].getPieza().getColor().equals("blanco")))) {
			Tablero.boton[f - 1][c].setBackground(Color.red);
		}
		if (c < 7 && Tablero.casilla[f][c + 1].getPieza().getNombrePieza().equals("...")) {
			Tablero.boton[f][c + 1].setBackground(Color.blue);
		} else if ((c < 7) && ((Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
				&& Tablero.casilla[f][c + 1].getPieza().getColor().equals("negro"))
				|| (Tablero.casilla[f][c].getPieza().getColor().equals("negro")
						&& Tablero.casilla[f][c + 1].getPieza().getColor().equals("blanco")))) {
			Tablero.boton[f][c + 1].setBackground(Color.red);
		}
		if (c > 0 && Tablero.casilla[f][c - 1].getPieza().getNombrePieza().equals("...")) {
			Tablero.boton[f][c - 1].setBackground(Color.blue);
		} else if ((c > 0) && ((Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
				&& Tablero.casilla[f][c - 1].getPieza().getColor().equals("negro"))
				|| (Tablero.casilla[f][c].getPieza().getColor().equals("negro")
						&& Tablero.casilla[f][c - 1].getPieza().getColor().equals("blanco")))) {
			Tablero.boton[f][c - 1].setBackground(Color.red);
		}
		if (c != 0 && f != 0 && Tablero.casilla[f - 1][c - 1].getPieza().getNombrePieza().equals("...")) {
			Tablero.boton[f - 1][c - 1].setBackground(Color.blue);
		} else if ((c != 0 && f != 0) && ((Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
				&& Tablero.casilla[f - 1][c - 1].getPieza().getColor().equals("negro"))
				|| (Tablero.casilla[f][c].getPieza().getColor().equals("negro")
						&& Tablero.casilla[f - 1][c - 1].getPieza().getColor().equals("blanco")))) {
			Tablero.boton[f - 1][c - 1].setBackground(Color.red);
		}
		if (c != 7 && f != 0 && Tablero.casilla[f - 1][c + 1].getPieza().getNombrePieza().equals("...")) {
			Tablero.boton[f - 1][c + 1].setBackground(Color.blue);
		} else if ((c != 7 && f != 0) && ((Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
				&& Tablero.casilla[f - 1][c + 1].getPieza().getColor().equals("negro"))
				|| (Tablero.casilla[f][c].getPieza().getColor().equals("negro")
						&& Tablero.casilla[f - 1][c + 1].getPieza().getColor().equals("blanco")))) {
			Tablero.boton[f - 1][c + 1].setBackground(Color.red);
		}
		if (c != 7 && f != 7 && Tablero.casilla[f + 1][c + 1].getPieza().getNombrePieza().equals("...")) {
			Tablero.boton[f + 1][c + 1].setBackground(Color.blue);
		} else if ((c != 7 && f != 7) && ((Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
				&& Tablero.casilla[f + 1][c + 1].getPieza().getColor().equals("negro"))
				|| (Tablero.casilla[f][c].getPieza().getColor().equals("negro")
						&& Tablero.casilla[f + 1][c + 1].getPieza().getColor().equals("blanco")))) {
			Tablero.boton[f + 1][c + 1].setBackground(Color.red);
		}
		if (c != 0 && f != 7 && Tablero.casilla[f + 1][c - 1].getPieza().getNombrePieza().equals("...")) {
			Tablero.boton[f + 1][c - 1].setBackground(Color.blue);
		} else if ((c != 0 && f != 7) && ((Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
				&& Tablero.casilla[f + 1][c - 1].getPieza().getColor().equals("negro"))
				|| (Tablero.casilla[f][c].getPieza().getColor().equals("negro")
						&& Tablero.casilla[f + 1][c - 1].getPieza().getColor().equals("blanco")))) {
			Tablero.boton[f + 1][c - 1].setBackground(Color.red);
		}
	}

	public static int getTurno() {
		return turno;
	}

	public static void setTurno(int turno0) {
		turno = turno0;
	}

}
