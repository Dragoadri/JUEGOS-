package dragonWars.Personaje;

import dragonWars.arma.Arma;
import dragonWars.atributo.Atributo;
import dragonWars.vista.Fortaleza;

public abstract class Personaje implements Runnable {
	private String nombre,urlPhoto;
	private Arma arma;
	private int vida;
	private Atributo atributo;
	private Fortaleza fort;
	
	public Personaje(String nombre, String urlPhoto, Arma arma, int vida, Atributo atributo) {
		this.nombre = nombre;
		this.urlPhoto = urlPhoto;
		this.arma = arma;
		this.vida = vida;
		this.atributo = atributo;
		
	}
	public abstract int atacar(Personaje atacado);
	public abstract void morir(Personaje muerto);
	public abstract void ataqueEspecial(Personaje atacado);
	
	
	
	
	
	public Fortaleza getFort() {
		return fort;
	}
	public void setFort(Fortaleza fort) {
		this.fort = fort;
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
	public Arma getArma() {
		return arma;
	}
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public Atributo getAtributo() {
		return atributo;
	}
	public void setAtributo(Atributo atributo) {
		this.atributo = atributo;
	}
	public void atacar() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
