package Buscaminas;

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

	public void mostrarTablero() {
		System.out.print("\n\n------TABLERO------\n\n     ");

		for (int i = 0; i < tab.getCasillas().length; i++) {
			System.out.print("\n|");
			for (int j = 0; j < tab.getCasillas()[i].length; j++) {
				if (tab.getCasillas()[i][j].getContenido().isVisible()) {
					System.out.print(tab.getCasillas()[i][j].getContenido().getSimbolo() + "|");
				} else {
					System.out.print("-|");
				}
			}
		}

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
					tab.getCasillas()[i][j].getBoton().setText(""+
					tab.getCasillas()[i][j].getContenido().getSimbolo());
				}

			}
		}
	}

	public void hacerVisible(int f, int c) {

		tab.getCasillas()[f][c].getContenido().setVisible(true);
		tab.getCasillas()[f][c].getBoton().setText(""+
				tab.getCasillas()[f][c].getContenido().getSimbolo());
		
		if (tab.getCasillas()[f][c].getContenido().isEsMina()) {
			tab.getCasillas()[f][c].getContenido().setSimbolo('*');
			hacervisibleTodasLasMinas();
			
		} else if (tab.getCasillas()[f][c].getContenido().getSimbolo() == ' ') {

			this.hacerVisibleEspaciosAlRededor(f, c);

		}
	}

	public void liberarCasilla(int f, int c) {
		try {
			if (!this.tab.getCasillas()[f][c].getContenido().isEsMina()
					&& !this.tab.getCasillas()[f][c].getContenido().isVisible()) {
				
				this.tab.getCasillas()[f][c].getContenido().setVisible(true);
				this.tab.getCasillas()[f][c].getBoton().setText(""+
				this.tab.getCasillas()[f][c].getContenido().getSimbolo());
				this.tab.getCasillas()[f][c].getBoton().setEnabled(false);
				
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
}
