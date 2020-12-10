
package enRaya;

import java.util.Scanner;

/**
 *
 * @author Adrian CaÃ±adas
 */
public class TresEnRaia {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		jugar();
	}

	public static void jugar() {
		char J1 = 'X';
		char J2 = 'O';
		char vacio = '-';

		boolean turno = true;
		char tablero[][] = new char[3][3]; // Definimos la matriz 3x3 que sera el tablero
		rellenarMatriz(tablero, vacio);// llenamos la matriz de vacios
		int fila, columna;
		boolean posValida, correcto;

		while (!finPartida(tablero, vacio)) { // mientras que la partida no haya finalizado o bien por que no quedan mas
												// huecos o un jugador ya gano
			do {

				mostrarTurnoActual(turno);// muestra de quien es el turno si del J1 o del J2
				mostrarMatriz(tablero);// muestra como esta actualmente el tablero

				correcto = false;// al principio toma como que el usuario introduce mal los datos
				fila = pedirInteger("Inroduzca la fila (0-2)"); // pide en que fila querra colocar su ficha
				columna = pedirInteger("Inroduzca la columna (0-2)");// pide en que columna querra colocar la ficha
				posValida = validarPosicion(tablero, fila, columna); // valida si la fila y columna introducida son
																		// correctas
				if (posValida) {
					if (posicionVacia(tablero, fila, columna, vacio)) {// valida si no hay alguna ficha ya puesta en esa
																		// posicion
						correcto = true;
					} else {
						System.out.println("Esa posicion ya esta tomada!!");
					}
				} else {
					System.out.println("Introduce una posicion correcta!");
				}
			} while (!correcto);// mientras que no se pueda poner la ficha por que los datos introducidos no son
								// correctos, pedira contantemente los datos al usuario de nuevo

			if (turno) {
				insesrtarEn(tablero, fila, columna, J1);
			} else {
				insesrtarEn(tablero, fila, columna, J2);
			}

			turno = !turno;// siempre devuelve el contrario
		}

		mostrarMatriz(tablero);
		mostrarGanador(tablero, J1, J2, vacio);
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

				simbolo = coincidenciaDiagonal(matriz, simboloDef);
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

	public static void insesrtarEn(char[][] matriz, int fila, int columna, char simbolo) {
		matriz[fila][columna] = simbolo;

	}

	public static void mostrarTurnoActual(boolean turno) {

		if (turno) {
			System.out.println("Turno del Jugador 1");
		} else {
			System.out.println("Turno del jugador 2");
		}

	}

	public static int pedirInteger(String mensaje) {
		int numero;
		do {
			System.out.println(mensaje);
			numero = teclado.nextInt();
		} while (numero < 0 || numero > 2);
		return numero;

	}

	public static boolean posicionVacia(char[][] matriz, int fila, int columna, char simboloDefault) {
		return matriz[fila][columna] == simboloDefault;
	}

	public static void rellenarMatriz(char[][] matriz, char simbolo) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = simbolo;

			}

		}

	}

	public static boolean validarPosicion(char[][] matriz, int fila, int columna) {
		if (fila >= 0 && fila <= matriz.length && columna >= 0 && columna <= matriz.length) {
			return true;
		}
		return false;

	}

	public static boolean matrizLlena(char[][] matriz, char simboloDef) {
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

	public static boolean finPartida(char[][] matriz, char simboloDef) {
		if (matrizLlena(matriz, simboloDef) || coincidenciaLinea(matriz, simboloDef) != simboloDef
				|| coincidenciaColumna(matriz, simboloDef) != simboloDef
				|| coincidenciaDiagonal(matriz, simboloDef) != simboloDef) {

			return true;
		}

		return false;

	}

	public static char coincidenciaLinea(char[][] matriz, char simboloDef) {
		char simbolo;
		boolean coincidencia = true;
		for (int i = 0; i < matriz.length; i++) {
			coincidencia = true;
			simbolo = matriz[i][0];
			if (simbolo != simboloDef) {// si el simbolo no esta vacio

				boolean con1 = false, con2 = false;
				if (matriz[i][1] == simbolo) {
					con1 = true;
				}
				if (matriz[i][2] == simbolo) {
					con2 = true;
				}

				if (con1 == true && con2 == true) {
					return simbolo;
				}

			}

		}
		return simboloDef;
	}

	public static char coincidenciaColumna(char[][] matriz, char simboloDef) {
		char simbolo;
		boolean coincidencia = true;
		for (int i = 0; i < matriz.length; i++) {
			coincidencia = true;
			simbolo = matriz[0][i];
			if (simbolo != simboloDef) {// si el simbolo no esta vacio

				boolean con1 = false, con2 = false;
				if (matriz[1][i] == simbolo) {
					con1 = true;
				}
				if (matriz[2][i] == simbolo) {
					con2 = true;
				}

				if (con1 == true && con2 == true) {
					return simbolo;
				}

			}

		}
		return simboloDef;
	}

	public static char coincidenciaDiagonal(char[][] matriz, char simboloDef) {
		char simbolo;
		boolean coincidencia = true;
// diagonal principal
		simbolo = matriz[0][0];
		if (simbolo != simboloDef) {// si el simbolo no esta vacio

			boolean con1 = false, con2 = false;
			if (matriz[1][1] == simbolo) {
				con1 = true;
			}
			if (matriz[2][2] == simbolo) {
				con2 = true;
			}

			if (con1 == true && con2 == true) {
				return simbolo;
			}

		}
		// diagonal inversa

		simbolo = matriz[0][2];
		if (simbolo != simboloDef) {// si el simbolo no esta vacio

			boolean con1 = false, con2 = false;
			if (matriz[1][1] == simbolo) {
				con1 = true;
			}
			if (matriz[2][0] == simbolo) {
				con2 = true;
			}

			if (con1 == true && con2 == true) {
				return simbolo;
			}

		}

		return simboloDef;
	}

	public static void mostrarMatriz(char[][] matriz) {
		System.out.print("Col |");
		for (int i = 0; i < matriz.length; i++) {// da referencia a con que numerom se representa cada columna
			System.out.print(i + "|");
		}
		System.out.println("\n");
		for (int i = 0; i < matriz.length; i++) { // las i representan las filas
			System.out.print("|" + i + "| ");// muestra para referencia del jugador con que numero se representan las
												// filas

			for (int j = 0; j < matriz[0].length; j++) { // las j representan las columnas

				System.out.print("|" + matriz[i][j]);
			}
			System.out.print("|");
			System.out.println("");
		}

	}
}
