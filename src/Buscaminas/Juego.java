package Buscaminas;

import java.awt.Color;

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

	public Juego() {

	}

	public void inicio() {
		tab.rellenarTablero();
	}

	
	public boolean esGanador() {
		boolean loEs = true;
		for (int f = 0; f < tab.getCasillas().length; f++) {
			for (int c = 0; c < tab.getCasillas()[f].length; c++) {
				if (!casillaIsMina(f, c)
						&& !tab.getCasillas()[f][c].getContenido().isVisible()) {
					loEs = false;
				}
			}
		}

		return loEs;
	}
	public void hacervisibleTodasLasMinas() {
		for (int f = 0; f < tab.getCasillas().length; f++) {
			for (int c = 0; c < tab.getCasillas()[f].length; c++) {
				
				if (casillaIsMina(f, c)) {
					
					
					
					deshacerCasilla(f, c);
					
					
					colorearCasilla(f, c, Color.ORANGE);
				}
				tab.getCasillas()[f][c].getBoton().setEnabled(false);
			}
		}
		
		
		
	}

	public void hacerVisible(int f, int c) {

		deshacerCasilla(f, c);
		
		if (casillaIsMina(f, c)) {
			
			colorearCasilla(f, c, Color.RED);
			hacervisibleTodasLasMinas();
			
		} else if (tab.getCasillas()[f][c].getContenido().getSimbolo() == ' ') {

			this.hacerVisibleEspaciosAlRededor(f, c);

		}
	}

	public void liberarCasilla(int f, int c) {
		try {
			if (!casillaIsMina(f, c)
					&& !this.tab.getCasillas()[f][c].getContenido().isVisible()) {
				
				deshacerCasilla(f, c);
				colorearCasilla(f, c, Color.LIGHT_GRAY);
				
				
				if (this.tab.getCasillas()[f][c].getContenido().getSimbolo() == ' '
						&& this.tab.getCasillas()[f][c].getContenido().isVisible()) {
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
				if (casillaIsMina(f, c)
						&& tab.getCasillas()[f][c].getContenido().isVisible()) {
					
					acaba = true;
					this.hacervisibleTodasLasMinas();
				}
			}
		}
		return acaba;
	}
	public void deshacerCasilla(int f,int c) {
		tab.getCasillas()[f][c].getContenido().setVisible(true);
		tab.getCasillas()[f][c].getBoton().setText(""+
				tab.getCasillas()[f][c].getContenido().getSimbolo());
		tab.getCasillas()[f][c].getBoton().setIcon(
				tab.getCasillas()[f][c].getContenido().getImagen());
		this.tab.getCasillas()[f][c].getBoton().setEnabled(false);
		
		
	}
	public void colorearCasilla(int f,int c,Color col) {
		
		tab.getCasillas()[f][c].getBoton().setBackground(col);
	}
	public boolean casillaIsMina(int f,int c) {
		return this.tab.getCasillas()[f][c].getContenido().isEsMina();
	}
}
