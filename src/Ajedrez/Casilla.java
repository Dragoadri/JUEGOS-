package Ajedrez;
/**
 * 
 * @author Adrian Cañadas
 *
 */
public class Casilla {
	private String color;// color de la casilla
	private String posicion;// posicion de manera N-N
	private boolean casillaOcupada;// para ver si la casilla tiene pieza o no encima
	private String nombre;// posicion de manera LetraNumero ejemplo: A1, G5...
	private Pieza pieza;// la pieza que habra en la casilla en el caso en el que la hubiese

	public Casilla() {

	}
	
	

	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	/**
	 * Nombre de las casillas en modo A0, E4...
	 * @return
	 */
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * Posicion de casillas de forma numerica N-N
	 * @return
	 */
	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public boolean isCasillaOcupada() {
		return casillaOcupada;
	}

	public void setCasillaOcupada(boolean casillaOcupada) {
		this.casillaOcupada = casillaOcupada;
	}

}
