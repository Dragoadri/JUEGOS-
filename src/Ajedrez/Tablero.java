package Ajedrez;

import java.util.ArrayList;

public class Tablero {
	/**
	 * Lisatado de las casillas que componen el tablero
	 */
	ArrayList<casilla> tablero = new ArrayList<casilla>();
	private int totalColumnas = 8;
	private int totalFilas = 8;
	// 8x8= 64 lugares en el array

	public void agregarCasillas() {

		for (int f = 1; f <= totalFilas; f++) {
			for (int c = 1; c <= totalColumnas; c++) {
				casilla Casilla = new casilla();

				if ((f % 2 == 0 && c % 2 != 0) || (f % 2 != 0 && c % 2 == 0)) {
					Casilla.setColor("negro");
				} else {
					Casilla.setColor("blanco");

				}
				Casilla.setPosicion(Integer.toString(f) + "-" + Integer.toString(c));
				char letra = (char) (64 + f);
				Casilla.setNombre(Character.toString(letra) + Integer.toString(c));

				tablero.add(Casilla);
			}
		}

	}

	public void getCasillas() {

		for (int c = 0; c < tablero.size(); c++) {
			//System.out.println(c);
			if (c % 8 == 0 && c>1) {
				System.out.println();
			}
			System.out.print(tablero.get(c).getNombre() + "-" + tablero.get(c).getColor()+" | ");
			
		}
	}

}
