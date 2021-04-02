package Buscaminas;
/**
 * 
 * @author Adrian Cañadas
 *
 */
public class Juego {
	private Tablero tab;

	public Juego(Tablero tab) {
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
				}

			}
		}
	}

	public void hacerVisible(int f, int c) {

		tab.getCasillas()[f][c].getContenido().setVisible(true);
		if (tab.getCasillas()[f][c].getContenido().isEsMina()) {
			tab.getCasillas()[f][c].getContenido().setSimbolo('*');
		} else if (tab.getCasillas()[f][c].getContenido().getSimbolo() == ' ') {

			this.hacerVisibleEspaciosAbDe(f, c);
			this.hacerVisibleEspaciosArIz(f, c);
	
			this.hacerVisibleEspaciosAbDe(f, c);
			this.hacerVisibleEspaciosArIz(f, c);
		}
	}

	public void hacerVisibleEspaciosArIz(int f, int c) {
		try {
			if (!this.tab.getCasillas()[f - 1][c].getContenido().isEsMina()) {
				this.tab.getCasillas()[f - 1][c].getContenido().setVisible(true);
				if (this.tab.getCasillas()[f - 1][c].getContenido().getSimbolo() == ' '
						&& this.tab.getCasillas()[f - 1][c].getContenido().isVisible()) {
					this.hacerVisibleEspaciosArIz(f - 1, c);
				}

			}
		} catch (Exception e) {
		}
		try {
			if (!this.tab.getCasillas()[f][c - 1].getContenido().isEsMina()) {
				this.tab.getCasillas()[f][c - 1].getContenido().setVisible(true);
				if (this.tab.getCasillas()[f][c - 1].getContenido().getSimbolo() == ' '
						&& this.tab.getCasillas()[f][c - 1].getContenido().isVisible()) {
					this.hacerVisibleEspaciosArIz(f, c - 1);
				}
			}
		} catch (Exception e) {
		}
		try {
			if (!this.tab.getCasillas()[f - 1][c - 1].getContenido().isEsMina()) {
				this.tab.getCasillas()[f - 1][c - 1].getContenido().setVisible(true);
				if (this.tab.getCasillas()[f - 1][c - 1].getContenido().getSimbolo() == ' '
						&& this.tab.getCasillas()[f - 1][c - 1].getContenido().isVisible()) {
					this.hacerVisibleEspaciosArIz(f - 1, c - 1);
				}
			}
		} catch (Exception e) {
		}
		try {
			if (!this.tab.getCasillas()[f - 1][c + 1].getContenido().isEsMina()) {
				this.tab.getCasillas()[f - 1][c + 1].getContenido().setVisible(true);
				if (this.tab.getCasillas()[f - 1][c + 1].getContenido().getSimbolo() == ' '
						&& this.tab.getCasillas()[f - 1][c + 1].getContenido().isVisible()) {
					this.hacerVisibleEspaciosArIz(f - 1, c + 1);
				}
			}
		} catch (Exception e) {
		}

	}

	public void hacerVisibleEspaciosAbDe(int f, int c) {

		try {
			if (!this.tab.getCasillas()[f + 1][c].getContenido().isEsMina()) {
				this.tab.getCasillas()[f + 1][c].getContenido().setVisible(true);

				if (this.tab.getCasillas()[f + 1][c].getContenido().getSimbolo() == ' '
						&& this.tab.getCasillas()[f + 1][c].getContenido().isVisible()) {

					this.hacerVisibleEspaciosAbDe(f + 1, c);
				}

			}
		} catch (Exception e) {
		}

		try {
			if (!this.tab.getCasillas()[f][c + 1].getContenido().isEsMina()) {
				this.tab.getCasillas()[f][c + 1].getContenido().setVisible(true);
				if (this.tab.getCasillas()[f][c + 1].getContenido().getSimbolo() == ' '
						&& this.tab.getCasillas()[f][c + 1].getContenido().isVisible()) {
					this.hacerVisibleEspaciosAbDe(f, c + 1);
				}

			}
		} catch (Exception e) {
		}
		try {
			if (!this.tab.getCasillas()[f + 1][c + 1].getContenido().isEsMina()) {
				this.tab.getCasillas()[f + 1][c + 1].getContenido().setVisible(true);
				if (this.tab.getCasillas()[f + 1][c + 1].getContenido().getSimbolo() == ' '
						&& this.tab.getCasillas()[f + 1][c + 1].getContenido().isVisible()) {
					this.hacerVisibleEspaciosArIz(f + 1, c + 1);
				}
			}
		} catch (Exception e) {
		}
		try {
			if (!this.tab.getCasillas()[f + 1][c - 1].getContenido().isEsMina()) {
				this.tab.getCasillas()[f + 1][c - 1].getContenido().setVisible(true);
				if (this.tab.getCasillas()[f + 1][c - 1].getContenido().getSimbolo() == ' '
						&& this.tab.getCasillas()[f + 1][c - 1].getContenido().isVisible()) {
					this.hacerVisibleEspaciosArIz(f + 1, c - 1);
				}
			}
		} catch (Exception e) {
		}

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
