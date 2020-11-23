package Ajedrez;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Juego {
	private static int turno;

	public Juego() {
		turno = 1;

		Tablero t1 = new Tablero();
		moverPieza(1);

	}

	public void moverPieza(int turno) {
		while(turno!=3) {
		for (int f = 0; f < Tablero.tablero.length; f++) {// recorre todo el array con 64 casillas (de 0 a 63)
			for (int c = 0; c < Tablero.tablero[f].length; c++) {
				if (turno == 1 && Tablero.tablero[f][c].getPieza().getColor() == "blanco") {
					Tablero.boton[f][c].addActionListener(new BotonPulsadoListener());

				} else if (turno == 2 && Tablero.tablero[f][c].getPieza().getColor() == "negro") {
					Tablero.boton[f][c].addActionListener(new BotonPulsadoListener());
					
				}

			}
		}}

	}

	private class BotonPulsadoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(("Has pulsado el boton " + e.getActionCommand()));
			setTurno(2);
		}
	}

	public int getTurno() {
		return turno;
	}

	public static void setTurno(int turno) {
		turno = turno;
	}

}
