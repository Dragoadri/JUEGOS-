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
		for (int i = 0; i < tab.getCasillas().length; i++) {
			for (int j = 0; j < tab.getCasillas()[i].length; j++) {
				if (!tab.getCasillas()[i][j].getContenido().isEsMina()
						&& !tab.getCasillas()[i][j].getContenido().isVisible()) {
					loEs = false;
				}
			}
		}

		return loEs;
	}

	public void hacervisibleTodasLasMinas() {
		for (int i = 0; i < tab.getCasillas().length; i++) {
			for (int j = 0; j < tab.getCasillas()[i].length; j++) {
				
				if (tab.getCasillas()[i][j].getContenido().isEsMina()) {
					
					tab.getCasillas()[i][j].getContenido().setVisible(true);
					tab.getCasillas()[i][j].getBoton().setIcon(
							tab.getCasillas()[i][j].getContenido().getImagen());
					tab.getCasillas()[i][j].getBoton().setBackground(Color.ORANGE);

					
				}
				tab.getCasillas()[i][j].getBoton().setEnabled(false);
				

			}
		}
		
		
		
	}

	public void hacerVisible(int f, int c) {

		deshacerCasilla(f, c);
		
		if (tab.getCasillas()[f][c].getContenido().isEsMina()) {
			
			tab.getCasillas()[f][c].getBoton().setBackground(Color.RED);
			hacervisibleTodasLasMinas();
			
		} else if (tab.getCasillas()[f][c].getContenido().getSimbolo() == ' ') {

			this.hacerVisibleEspaciosAlRededor(f, c);

		}
	}

	public void liberarCasilla(int f, int c) {
		try {
			if (!this.tab.getCasillas()[f][c].getContenido().isEsMina()
					&& !this.tab.getCasillas()[f][c].getContenido().isVisible()) {
				
				deshacerCasilla(f, c);
				tab.getCasillas()[f][c].getBoton().setBackground(Color.LIGHT_GRAY);
				
				
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
		for (int i = 0; i < tab.getCasillas().length; i++) {
			for (int j = 0; j < tab.getCasillas()[i].length && !acaba; j++) {
				if (tab.getCasillas()[i][j].getContenido().isEsMina()
						&& tab.getCasillas()[i][j].getContenido().isVisible()) {
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
		this.tab.getCasillas()[f][c].getBoton().setEnabled(false);
		
		
	}
	
}
