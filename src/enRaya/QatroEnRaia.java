
package enRaya;

import java.util.Scanner;

/**
 *
 * @author Adrian CaÃ±adas
 */
public class QatroEnRaia {

	
	public static void main(String[] args) {
		jugar();
	}

	public static void jugar() {
		char J1 = 'X';
		char J2 = 'O';
		char vacio = '-';

		boolean turno = true;
		char tablero[][] = new char[6][7]; // Definimos la matriz 3x3 que sera el tablero
		rellenarMatriz(tablero, vacio);// llenamos la matriz de vacios
		int fila, columna = 0;
		boolean posValida, correcto;

		// -------------------------- while (!finPartida(tablero, vacio)) { // mientras
		// que la partida no haya finalizado o bien por que no quedan mas huecos o un
		// jugador ya gano
		while (!finPartida(tablero, vacio)) {
			do {

				mostrarTurnoActual(turno);// muestra de quien es el turno si del J1 o del J2
				mostrarMatriz(tablero, columna);// muestra como esta actualmente el tablero

				correcto = false;// al principio toma como que el usuario introduce mal los datos

				columna = pedirInteger("Inroduzca la columna: ");// pide en que columna querra colocar la ficha
				posValida = validarPosicion(tablero, columna); // valida si la fila y columna introducida son correctas
				if (posValida) {
					if (columnaConHueco(tablero, columna, vacio)) {// valida si no hay alguna ficha ya puesta en esa
																	// posicion
						correcto = true;
					} else {
						System.out.println("Esa columna ya esta llena!!");
					}
				} else {
					System.out.println("Introduce una columna correcta!");
				}
			} while (!correcto);// mientras que no se pueda poner la ficha por que los datos introducidos no son
								// correctos, pedira contantemente los datos al usuario de nuevo

			if (turno) {
				insesrtarEn(tablero, columna, J1, vacio);

			} else {
				insesrtarEn(tablero, columna, J2, vacio);
			}

			turno = !turno;// siempre devuelve el contrario
		}
		// ------------------------------------------------------------------------------}

		mostrarMatriz(tablero, 0);
		mostrarGanador(tablero, J1, J2, vacio);
	}

	public static void rellenarMatriz(char matriz[][], char simboloDef) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = simboloDef;
			}
		}

	}

	public static void mostrarMatriz(char matriz[][], int indexIndi) {
		System.out.print("     |");

		for (int i = 0; i <= matriz.length; i++) {
			System.out.print(i + "|");
		}

		System.out.println("");
		System.out.print("      ");
		// indicador
		String[] indicaador = new String[matriz.length + 1];
		for (int i = 0; i <= matriz.length; i++) {
			indicaador[i] = "  ";
			if (i == indexIndi) {
				indicaador[i] = "!";
			}

			System.out.print(indicaador[i]);
		}

		for (int i = 0; i < matriz.length; i++) {
			System.out.println("");
			System.out.print("|" + i + "|  |");
			for (int j = 0; j < matriz[0].length; j++) {

				System.out.print(matriz[i][j] + "|");
			}
		}
		System.out.println("");
	}

	public static int pedirInteger(String mensaje) {
		Scanner teclado = new Scanner(System.in);
		int numero;
		System.out.println("");
		System.out.println(mensaje);
		numero = teclado.nextInt();
		return numero;

	}

	public static void insesrtarEn(char[][] matriz, int columna, char simbolo, char simboloDefault) {
		boolean puesto = false;

		for (int i = matriz.length - 1; (i > -1) && puesto == false; i--) { // un for tiene estas instancias (varuable
																			// en la que inicia, condicion que se debe
																			// cumplir para que el bucle se ejecute;
																			// iterador)
			if (matriz[i][columna] == simboloDefault) {
				matriz[i][columna] = simbolo;
				puesto = true;

			}
		}

	}

	public static void mostrarGanador(char[][] matriz, char J1, char J2, char simboloDef) {
		char simbolo = coincidenciaLinea(matriz, simboloDef);
		if (simbolo != simboloDef) {
			if (simbolo == J1) {
				System.out.println("El ganador es el Jugador 1 por linea");
			} else if (simbolo == J2) {
				System.out.println("El ganador es el Jugador 2 por linea");
			}

		} else {
			simbolo = coincidenciaColumna(matriz, simboloDef);
			if (simbolo != simboloDef) {
				if (simbolo == J1) {
					System.out.println("El ganador es el Jugador 1 por columna");
				} else if (simbolo == J2) {
					System.out.println("El ganador es el Jugador 2 por columna");
				}
			} else {

				simbolo = coincidenciaDiagonal1(matriz, simboloDef);
				if (simbolo != simboloDef) {
					if (simbolo == J1) {

						System.out.println("El ganador es el Jugador 1 por diagonal");
					} else if (simbolo == J2) {
						System.out.println("El ganador es el Jugador 2 por diagonal");
					}
				}
				simbolo = coincidenciaDiagonal2(matriz, simboloDef);
				if (simbolo != simboloDef) {
					if (simbolo == J1) {
						System.out.println("El ganador es el Jugador 1 por diagonal");
					} else if (simbolo == J2) {
						System.out.println("El ganador es el Jugador 2 por diagonal");
					}
				}
			}

		}

	}

	private static boolean finPartida(char[][] matriz, char simboloDef) {
		return matrizLlena(matriz, simboloDef) || coincidenciaLinea(matriz, simboloDef) != simboloDef
				|| coincidenciaColumna(matriz, simboloDef) != simboloDef
				|| coincidenciaDiagonal1(matriz, simboloDef) != simboloDef
				|| coincidenciaDiagonal2(matriz, simboloDef) != simboloDef;

	}

	private static boolean matrizLlena(char[][] matriz, char simboloDef) {
		boolean llena = true;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				if (matriz[i][j] == simboloDef) {
					llena = false;
				}
			}
		}

		return llena;
	}

	public static void mostrarTurnoActual(boolean turno) {

		if (turno) {
			System.out.println("Turno del Jugador 1 \n");
		} else {
			System.out.println("Turno del jugador 2 \n");
		}

	}

	public static boolean columnaConHueco(char[][] matriz, int columna, char simboloDefault) {
		boolean columnaConHueco = false;

		for (int i = 0; i < matriz.length; i++) {
			if (matriz[i][columna] == simboloDefault) {
				columnaConHueco = true;
			}
		}

		return columnaConHueco;
	}

	public static boolean validarPosicion(char[][] matriz, int columna) {
		if (columna >= 0 && columna <= matriz.length) {
			return true;
		}
		return false;

	}

	private static char coincidenciaLinea(char[][] matriz, char simboloDef) {
		boolean coincidencia = false;
		for (int i = 0; i < matriz.length && !coincidencia; i++) {
			for (int j = 0; j <= 3; j++) {
				if (matriz[i][j] != simboloDef) {
					if (matriz[i][j] == matriz[i][j + 1] && matriz[i][j] == matriz[i][j + 2]
							&& matriz[i][j] == matriz[i][j + 3]) {
						coincidencia = true;

						return matriz[i][j];
					}

				}
			}
		}

		return simboloDef;
	}

	private static char coincidenciaColumna(char[][] matriz, char simboloDef) {
		boolean coincidencia = false;
		for (int i = 0; i < matriz.length && !coincidencia; i++) {
			for (int j = 0; j <= 2; j++) {
				if (matriz[j][i] != simboloDef) {
					if (matriz[j][i] == matriz[j + 1][i] && matriz[j][i] == matriz[j + 2][i]
							&& matriz[j][i] == matriz[j + 3][i]) {
						coincidencia = true;
						return matriz[j][i];
					}

				}
			}
		}

		return simboloDef;
	}

	private static char coincidenciaDiagonal1(char[][] matriz, char simboloDef) {
		boolean coincidencia = false;
		for (int i = 0; i <= 2 && !coincidencia; i++) {
			for (int j = 0; j <= 3; j++) {
				if (matriz[i][j] != simboloDef) {
					if (matriz[i][j] == matriz[i + 1][j + 1] && matriz[i][j] == matriz[i + 2][j + 2]
							&& matriz[i][j] == matriz[i + 3][j + 3]) {
						coincidencia = true;

						return matriz[i][j];
					}

				}
			}
		}

		return simboloDef;
	}

	private static char coincidenciaDiagonal2(char[][] matriz, char simboloDef) {
		boolean coincidencia = false;
		for (int i = 0; i <= 2 && !coincidencia; i++) {
			for (int j = 0; j <= 3; j++) {
				if (matriz[i][j] != simboloDef) {
					if (matriz[i][j] == matriz[i + 1][j - 1] && matriz[i][j] == matriz[i + 2][j - 2]
							&& matriz[i][j] == matriz[i + 3][j - 3]) {
						coincidencia = true;

						return matriz[i][j];
					}

				}
			}
		}

		return simboloDef;
	}
}
