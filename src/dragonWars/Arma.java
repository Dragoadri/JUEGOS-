package dragonWars;

public abstract class Arma {
	private int danio;
	private String nombre,urlPhoto;
	
	
	
	public Arma(int danio, String nombre, String urlPhoto) {
		this.danio = danio;
		this.nombre = nombre;
		this.urlPhoto = urlPhoto;
	}



	public abstract void usar();



	public int getDanio() {
		return danio;
	}



	public void setDanio(int danio) {
		this.danio = danio;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getUrlPhoto() {
		return urlPhoto;
	}



	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}
	
}
