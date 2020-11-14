package Ajedrez;

public class casilla {
	private String color;
	private String posicion;
	private boolean casillaOcupada;
	private String nombre;

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
