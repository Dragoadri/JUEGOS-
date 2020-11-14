package Ajedrez;

import java.util.ArrayList;

public class Tablero {
	/**
	 * Lisatado de las casillas que componen el tablero
	 */
	casilla tablero[][] = new casilla[8][8];// array con nombre tablero y con variables de tipo casilla
	
	// 8x8= 64 lugares en el array

	public void agregarCasillas() {// metodo de añadir Casillas al ARRAY

		for (int f = 0; f < tablero.length; f++) {// para recorrer las filas
			for (int c = 0; c < tablero[f].length; c++) {// para recorrer las columnas
				casilla Casilla = new casilla();// por cada iteracion se crea una nueva casilla donde:

				if ((f % 2 == 0 && c % 2 != 0) || (f % 2 != 0 && c % 2 == 0)) {// si de la manera N-N una de ellas es par y la otra impar independientemente del orden:
					Casilla.setColor("negro");// la casilla sera negra
				} else {
					Casilla.setColor("blanco");// si no se cumple eso , es decir ambos N-N son o par o impar, la casilla sera blanca

				}
				Casilla.setPosicion(Integer.toString(f) + "-" + Integer.toString(c));// aqui se escribe la posicion de la casilla que sera en N-N y se pasa a string
				char letra = (char) (65 + f);// usamos el ASCII ya que 64+f al principio sera A despues B, despues C... asi para asignar las FILAS
				Casilla.setNombre(Character.toString(letra) + Integer.toString(c));// aqui se unen las filas en letra con su columna Por ejemplo la primera sera A1 y la ultima H8

				tablero[f][c]=Casilla;// se añade esta casilla al ARRAy tablero y tendremos en total 64 casillas 
			}
		}

	}

	public void getCasillas() {// metodo para obtener todas las casillas creadas 

		for (int f = 0; f < tablero.length; f++) {// recorre todo el array con 64 casillas (de 0 a 63)
			 System.out.println();
			for (int c = 0; c < tablero[f].length; c++) {
			
			 
				
			System.out.print(tablero[f][c].getNombre() + "-" + tablero[f][c].getColor()+" | ");
			}
		}
	}

}
