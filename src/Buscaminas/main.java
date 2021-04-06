package Buscaminas;

import java.util.Scanner;

/**
 * 
 * @author Adrian Cañadas
 *
 */
public class main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("-------BUSCAMINAS-------\n\n"
				+ "Simbolos: \n"
				+ "Sin explorar           (-)\n"
				+ "Vacio                  ( )\n"
				+ "Mina proxima numero    (1-8)\n"
				+ "Mina explotada         (*)\n"
				+ "Mina sin explotar      (@)\n");
		
		System.out.println("Seleccione la dificultad:\n");
		System.out.println("(1)-Principiante");
		System.out.println("(2)-Intermedio");
		System.out.println("(3)-Avanzado");
		System.out.println("(4)-Personalizado");
		int op = in.nextInt();
		Juego j = new Juego();
		switch (op) {
		case 1:
			j = new Juego(new Tablero(9, 9, 10));
			break;
		case 2:
			j = new Juego(new Tablero(16, 16, 40));

			break;
		case 3:
			j = new Juego(new Tablero(16, 30, 99));

			break;
		case 4:

			System.out.println("--Personalizado--");
			System.out.println("Filas:");
			int filas = in.nextInt();
			System.out.println("Columnas:");
			int columnas = in.nextInt();
			System.out.println("Minas:");
			int minas = in.nextInt();
			j = new Juego(new Tablero(filas, columnas, minas));
			break;

		}
		
		
		j.inicio();

		while (!j.minaExplota()&&!j.esGanador()) {
					j.mostrarTablero();

			System.out.println("\n\n--Casilla a pulsar--\n\nIntroduzca fila:");
			int filaPide = in.nextInt();
			System.out.println("Introduzca columna");
			int columnaPide = in.nextInt();
			j.hacerVisible(filaPide, columnaPide);
		}
		j.mostrarTablero();
		System.out.println(j.esGanador()?"\nFELICIDADES!\n"
				+ "HAS GANADO":"\n\nBUM!!!\n" + "HAS EXPLOTADO UNA MINA\n");
		System.out.println("------FIN DEL JUEGO------");
	}
}
