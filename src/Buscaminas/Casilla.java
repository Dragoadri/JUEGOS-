package Buscaminas;
/**
 * 
 * @author Adrian Cañadas
 *
 */
public class Casilla {
	
	private int fila;
	private int columna;
	private caso contenido;
	
	public Casilla(int fila , int columna,String nombreContenido) {
		this.fila=fila;
		this.columna=columna;
		char simbolo=' ';
		boolean esMina=false;

		if (nombreContenido.equals("mina")) {
			simbolo='@';
			esMina=true;
		}else {
			simbolo=' ';
			esMina=false;
		}
		this.contenido= new caso(nombreContenido, simbolo, esMina);
	}
	
	public caso getContenido() {
		return contenido;
	}
	
}
