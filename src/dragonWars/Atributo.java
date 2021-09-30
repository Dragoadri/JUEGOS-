package dragonWars;

public abstract class Atributo {
	private String nombreAtributo,urlPhoto;
	private int valorAtributo;
	
	
	
	public Atributo(String nombreAtributo, String urlPhoto, int valorAtributo) {
		this.nombreAtributo = nombreAtributo;
		this.urlPhoto = urlPhoto;
		this.valorAtributo = valorAtributo;
	}
	public String getUrlPhoto() {
		return urlPhoto;
	}
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}
	public String getNombreAtributo() {
		return nombreAtributo;
	}
	public void setNombreAtributo(String nombreAtributo) {
		this.nombreAtributo = nombreAtributo;
	}
	public int getValorAtributo() {
		return valorAtributo;
	}
	public void setValorAtributo(int valorAtributo) {
		this.valorAtributo = valorAtributo;
	}
	
	
}
