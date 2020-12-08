package Ajedrez;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Juego {
	private static int turno;

	public Juego() {
		setTurno(1);

		Tablero t1 = new Tablero();
		moverPieza();

	}

	public void moverPieza() {

		for (int f = 0; f < Tablero.casilla.length; f++) {// recorre todo el array con 64 casillas (de 0 a 63)
			for (int c = 0; c < Tablero.casilla[f].length; c++) {
				if (getTurno() == 1 && Tablero.casilla[f][c].getPieza().getColor().equals("blanco")) {

					Tablero.boton[f][c].addActionListener(new BotonPulsadoListener(f, c));

				}

			}
		}

		for (int f = 0; f < Tablero.casilla.length; f++) {// recorre todo el array con 64 casillas (de 0 a 63)
			for (int c = 0; c < Tablero.casilla[f].length; c++) {
				if (getTurno() == 1 && Tablero.casilla[f][c].getPieza().getColor().equals("negro")) {

					Tablero.boton[f][c].addActionListener(new BotonPulsadoListener(f, c));

				}

			}
		}

	}

	private class BotonPulsadoListener implements ActionListener {
		int f;
		int c;

		public BotonPulsadoListener(int f, int c) {
			this.f = f;
			this.c = c;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Has pulsado el boton " + Tablero.casilla[f][c].getPieza().getPosicion());

			if (Tablero.casilla[f][c].getPieza().getNombrePieza().equals("peon")
					&& Tablero.casilla[f][c].getPieza().getColor().equals("negro") && getTurno() == 2) {
				movPeonNegro(f, c);
				setTurno(1);
			} else if (Tablero.casilla[f][c].getPieza().getNombrePieza().equals("peon")
					&& Tablero.casilla[f][c].getPieza().getColor().equals("blanco") && getTurno() == 1) {
				movPeonBlanco(f, c);
				setTurno(2);
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

		}
	}

	public static void movPeonNegro(int f, int c) {

		Tablero.boton[f + 1][c].setBackground(Color.blue);
	}

	public static void movPeonBlanco(int f, int c) {

		Tablero.boton[f - 1][c].setBackground(Color.blue);
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
			} else if ((c < 7 && f < 7)
					&& ((Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
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
			} else if ((c > 0 && f < 7)
					&& ((Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
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
			} else if ((c < 7 && f > 0)
					&& ((Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
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
			} else if ((c > 0 && f > 0)
					&& ((Tablero.casilla[f][c].getPieza().getColor().equals("blanco")
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
