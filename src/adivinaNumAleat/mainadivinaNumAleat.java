package adivinaNumAleat;

import java.util.Scanner;

public class mainadivinaNumAleat {

	public static void main(String[] args) {
		int introducido, aleatorio, menor = 1, mayor = 100;
		Scanner teclado = new Scanner(System.in);
		System.out.println("JUEGO ADIVINA EL NUMERO ALEATORIO ENTRE 1 Y 100");
		System.out.print("Introduce un numero al azar entre 1 y 100 ->");

		introducido = teclado.nextInt();
		aleatorio = (int)( Math.random()*100);
		
		while (introducido != aleatorio) {
			while (introducido < 1 || introducido > 100) {
				System.out.println("Numero introducido fuera de Rango, vuelva a introducir->");
				introducido = teclado.nextInt();
			}
			if (introducido > aleatorio) {
				mayor = introducido;
				System.out.println("Tu numero es MAYOR que el numero aleatorio por lo tanto el rango se reduce a"
						+ mayor + "-" + 0);

			} else if (introducido < aleatorio) {
				menor = introducido;
				System.out.println("Tu numero es MENOR que el numero aleatorio por lo tanto el rango se reduce a" + 100
						+ "-" + menor);
			}
			System.out.print("Introduce un numero al azar entre " + menor + " y " + mayor + " ->");
			introducido = teclado.nextInt();
		}
		System.out.println("Felicidades, has acertado el numero es (" + aleatorio + ")");
	}

}
