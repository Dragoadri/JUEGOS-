package Ajedrez;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Juego {
	private char turno;

	public Juego() {
		this.turno = '1';
		
		Tablero t1 = new Tablero();
		moverPieza('1');

	}

	public void moverPieza(char turno) {
		for (int f = 0; f < Tablero.tablero.length; f++) {// recorre todo el array con 64 casillas (de 0 a 63)
			for (int c = 0; c < Tablero.tablero[f].length; c++) {
				if (this.turno == '1'&& Tablero.tablero[f][c].getPieza()!=null) {
					Tablero.boton[f][c].addActionListener(new BotonPulsadoListener());
				}
				

			}
		}

	}

	private class BotonPulsadoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(("Has pulsado el botón " + e.getActionCommand()));
		}
	}

	public char getTurno() {
		return turno;
	}

	public void setTurno(char turno) {
		this.turno = turno;
	}

}
