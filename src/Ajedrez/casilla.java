package Ajedrez;

public class casilla {
	private String color;// color de la casilla
	private String posicion;// posicion de manera N-N
	private boolean casillaOcupada;// para ver si la casilla tiene pieza o no encima
	private String nombre;// posicion de manera LetraNumero ejemplo: A1, G5...

	public casilla() {

	}

	public String getNombre() {
		return nombre;
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
