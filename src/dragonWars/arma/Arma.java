package dragonWars.arma;

public abstract class Arma {
	private int danioMAX,danioMIN;
	private String nombre,urlPhoto;
	
	
	
	public Arma(int danioMIN,int danioMAX, String nombre, String urlPhoto) {
		this.danioMIN = danioMIN;
		this.danioMAX = danioMAX;
		this.nombre = nombre;
		this.urlPhoto = urlPhoto;
	}



	public abstract int usar();


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



	public int getDanioMAX() {
		return danioMAX;
	}



	public void setDanioMAX(int danioMAX) {
		this.danioMAX = danioMAX;
	}



	public int getDanioMIN() {
		return danioMIN;
	}



	public void setDanioMIN(int danioMIN) {
		this.danioMIN = danioMIN;
	}
	
	
	
}
