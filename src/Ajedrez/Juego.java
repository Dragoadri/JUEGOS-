package Ajedrez;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Juego {
	private int turno;

	public Juego() {
		setTurno(1);

		Tablero t1 = new Tablero();
		moverPieza();

	}

	public void moverPieza() {

		for (int f = 0; f < Tablero.casilla.length; f++) {// recorre todo el array con 64 casillas (de 0 a 63)
			for (int c = 0; c < Tablero.casilla[f].length; c++) {
				if (Tablero.casilla[f][c].getPieza().getNombrePieza().equals("alfil")) {

					Tablero.boton[f][c].addActionListener(new BotonPulsadoListener(f, c));

					System.out.println(Tablero.casilla[f][c].getPieza().getPosicion());
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

			for (int i = 0; i <Tablero.casilla[f].length; i++) {
				Tablero.boton[f+i][c-i].setBackground(Color.blue);
				
			}
			
			
			/*
			 * Peon Negro Tablero.boton[f+1][c].setBackground(Color.blue);
			 * 
			 * Peon blanco Tablero.boton[f-1][c].setBackground(Color.blue);
			 * 
			 * Torres
			 * 
			 * for (int i = 0; i < Tablero.casilla[f].length -
			 * Tablero.casilla[f][c].getPieza().getColumna(); i++) { Tablero.boton[f][c +
			 * i].setBackground(Color.blue);
			 * 
			 * } for (int i = 0; i <= Tablero.casilla[f][c].getPieza().getColumna(); i++) {
			 * Tablero.boton[f][c - i].setBackground(Color.blue);
			 * 
			 * } for (int i = 0; i < Tablero.casilla[f].length -
			 * Tablero.casilla[f][c].getPieza().getFila(); i++) { Tablero.boton[f +
			 * i][c].setBackground(Color.blue);
			 * 
			 * } for (int i = 0; i <= Tablero.casilla[f][c].getPieza().getFila(); i++) {
			 * Tablero.boton[f - i][c].setBackground(Color.blue);
			 * 
			 * }
			 * 
			 * Caballo
			 * 
			 * if (c > 0 && f < 6) { Tablero.boton[f + 2][c - 1].setBackground(Color.blue);
			 * 
			 * } if (c > 0 && f > 1) { Tablero.boton[f - 2][c -
			 * 1].setBackground(Color.blue);
			 * 
			 * } if (c < 7 && f < 6) { Tablero.boton[f + 2][c +
			 * 1].setBackground(Color.blue);
			 * 
			 * } if (c < 7 && f > 1) { Tablero.boton[f - 2][c +
			 * 1].setBackground(Color.blue);
			 * 
			 * } if (c < 6 && f < 7) { Tablero.boton[f + 1][c +
			 * 2].setBackground(Color.blue);
			 * 
			 * } if (c > 1 && f < 7) { Tablero.boton[f + 1][c -
			 * 2].setBackground(Color.blue);
			 * 
			 * } if (c > 1 && f > 0) { Tablero.boton[f - 1][c -
			 * 2].setBackground(Color.blue);
			 * 
			 * } if (c < 6 && f > 0) { Tablero.boton[f - 1][c +
			 * 2].setBackground(Color.blue);
			 * 
			 * }
			 * 
			 * Alfil Tablero.boton[f+i][c+i].setBackground(Color.blue);
			 */

		}
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno0) {
		turno = turno0;
	}

}
