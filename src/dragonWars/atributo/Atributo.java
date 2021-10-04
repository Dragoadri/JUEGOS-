package dragonWars.atributo;

public abstract class Atributo {
	private String nombreAtributo, urlPhoto;
	private int valorMAXAtributo, valorMINAtributo;

	public Atributo(String nombreAtributo, String urlPhoto, int valorMAXAtributo, int valorMINAtributo) {
		super();
		this.nombreAtributo = nombreAtributo;
		this.urlPhoto = urlPhoto;
		this.valorMAXAtributo = valorMAXAtributo;
		this.valorMINAtributo = valorMINAtributo;
	}

	public int getValorAtributo() {

		return (int) (Math.random() * (this.getValorMAXAtributo() - this.getValorMINAtributo() + 1)
				+ this.getValorMINAtributo());
	};

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

	public int getValorMAXAtributo() {
		return valorMAXAtributo;
	}

	public void setValorMAXAtributo(int valorMAXAtributo) {
		this.valorMAXAtributo = valorMAXAtributo;
	}

	public int getValorMINAtributo() {
		return valorMINAtributo;
	}

	public void setValorMINAtributo(int valorMINAtributo) {
		this.valorMINAtributo = valorMINAtributo;
	}

}
