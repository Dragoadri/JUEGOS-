package Buscaminas;
/**
 * 
 * @author Adrian Cañadas
 *
 */
public class Tablero {
	private int filas;
	private int columnas;
	private int minas;
	private Casilla[][] casillas;

	public Tablero(int filas, int columnas, int minas) {
		this.filas = filas;
		this.columnas = columnas;
		this.minas = minas;
		this.casillas = new Casilla[filas][columnas];
	}

	public void rellenarTablero() {
		for (int i = 0; i < this.minas; i++) {
			int f = 0;
			int c = 0;
			do {
				f = (int) (Math.random() * (this.casillas.length - 1 + 1 - 1)) + 1;
				c = (int) (Math.random() * (this.casillas[0].length - 1 + 1 - 1)) + 1;

			} while (casillas[f][c] != null);
			casillas[f][c] = new Casilla(f, c, "mina");
		}

		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {

				if (casillas[i][j] == null)

				{
					int contMinas = 0;
					casillas[i][j] = new Casilla(i, j, "nada");
					try {
						if (casillas[i - 1][j].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
						
					}
					try {
						if (casillas[i + 1][j].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					try {
						if (casillas[i - 1][j - 1].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					try {
						if (casillas[i - 1][j + 1].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					try {
						if (casillas[i + 1][j - 1].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					try {
						if (casillas[i + 1][j + 1].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					try {
						if (casillas[i][j + 1].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					try {
						if (casillas[i][j - 1].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					if (contMinas != 0) {
						casillas[i][j].getContenido().setSimbolo(Integer.toString(contMinas).charAt(0));

					}

				}
			}
		}

	}

	public Casilla[][] getCasillas() {
		return casillas;
	}

}
