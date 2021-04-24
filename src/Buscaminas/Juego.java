package Buscaminas;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

/**
 * 
 * @author Adrian Cañadas
 *
 */
public class Juego {
	private TabGraf tab;

	public Juego(TabGraf tab) {
		this.tab = tab;
	}

	public void inicio() {
		tab.rellenarTablero();
	}

	public boolean esGanador() {
		boolean loEs = true;
		for (int f = 0; f < tab.getCasillas().length && loEs; f++) {
			for (int c = 0; c < tab.getCasillas()[f].length && loEs; c++) {

				loEs = (!casillaIsMina(f, c) && !casillaIsVisble(f, c) ? false : true);
			}
		}
		return loEs;
	}

	public void hacervisibleTodasLasMinas() {
		for (int f = 0; f < tab.getCasillas().length; f++) {
			for (int c = 0; c < tab.getCasillas()[f].length; c++) {
				if (casillaIsMina(f, c)) {
					deshacerCasilla(f, c);
					colorearCasilla(f, c, new Color(209, 145, 7));// naranja
				}
			}
		}
	}

	public void hacerVisible(int f, int c) {
		numDeColores(f, c);
		deshacerCasilla(f, c);
		colorearCasilla(f, c, Color.LIGHT_GRAY);// gris

		if (casillaIsMina(f, c)) {
			hacervisibleTodasLasMinas();
			colorearCasilla(f, c, Color.RED);

		} else if (casillaIsEspacioVacio(f, c)) {
			this.hacerVisibleEspaciosAlRededor(f, c);

		}
	}

	public void liberarCasilla(int f, int c) {
		try {
			if (!casillaIsMina(f, c) && !casillaIsVisble(f, c)) {

				deshacerCasilla(f, c);
				colorearCasilla(f, c, Color.LIGHT_GRAY);
				numDeColores(f, c);

				if (casillaIsEspacioVacio(f, c)) {// && casillaIsVisble(f, c)
					this.hacerVisibleEspaciosAlRededor(f, c);
				}

			}
		} catch (Exception e) {
		}
	}

	public void hacerVisibleEspaciosAlRededor(int f, int c) {

		// Arriba
		this.liberarCasilla(f - 1, c);
		// Abajo
		this.liberarCasilla(f + 1, c);
		// Derecha
		this.liberarCasilla(f, c + 1);
		// Izquierda
		this.liberarCasilla(f, c - 1);
		// Arriba Izquierda
		this.liberarCasilla(f - 1, c - 1);
		// Arriba Derecha
		this.liberarCasilla(f - 1, c + 1);
		// Abajo Derecha
		this.liberarCasilla(f + 1, c + 1);
		// Abajo Izquierda
		this.liberarCasilla(f + 1, c - 1);
	}

	public boolean minaExplota() {
		boolean acaba = false;
		for (int f = 0; f < tab.getCasillas().length; f++) {
			for (int c = 0; c < tab.getCasillas()[f].length && !acaba; c++) {

				acaba = (casillaIsMina(f, c) && casillaIsVisble(f, c));
			}
		}
		return acaba;
	}

	public void deshacerCasilla(int f, int c) {

		tab.getCasillas()[f][c].getContenido().setVisible(true);
		if (!casillaIsMina(f, c)) {
			tab.getCasillas()[f][c].getBoton().setText("" + tab.getCasillas()[f][c].getContenido().getSimbolo());
		}
		tab.getCasillas()[f][c].getBoton().setIcon(tab.getCasillas()[f][c].getContenido().getImagen());
		// this.tab.getCasillas()[f][c].getBoton().setEnabled(false);

	}

	public void colorearCasilla(int f, int c, Color col) {

		tab.getCasillas()[f][c].getBoton().setBackground(col);
	}

	public boolean casillaIsMina(int f, int c) {
		return this.tab.getCasillas()[f][c].getContenido().isEsMina();
	}

	public void numDeColores(int f, int c) {
		switch (tab.getCasillas()[f][c].getContenido().getSimbolo()) {
		case '1':
			tab.getCasillas()[f][c].getBoton().setForeground(new Color(0, 0, 255));
			break;
		case '2':
			tab.getCasillas()[f][c].getBoton().setForeground(new Color(0, 123, 0));
			break;
		case '3':
			tab.getCasillas()[f][c].getBoton().setForeground(Color.RED);
			break;
		case '4':
			tab.getCasillas()[f][c].getBoton().setForeground(new Color(92, 0, 116));
			break;
		}

	}

	public boolean casillaIsVisble(int f, int c) {
		return tab.getCasillas()[f][c].getContenido().isVisible();
	}

	public boolean casillaIsEspacioVacio(int f, int c) {
		return this.tab.getCasillas()[f][c].getContenido().getSimbolo() == ' ';
	}
}
