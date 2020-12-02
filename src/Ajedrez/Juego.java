package Ajedrez;

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
				if (Tablero.casilla[f][c].getPieza().getNombrePieza().equals("...")) {
					Tablero.boton[f][c].addActionListener(new BotonPulsadoListener());
					System.out.println(Tablero.casilla[f][c].getPieza().getPosicion());
				} 
				

			}
		}

	}

	private class BotonPulsadoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			System.out.println("Has pulsado el boton");
		}
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno0) {
		turno = turno0;
	}

}
