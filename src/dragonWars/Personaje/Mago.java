package dragonWars.Personaje;

import dragonWars.arma.Arma;
import dragonWars.arma.Hechizo;
import dragonWars.atributo.Inteligencia;

public class Mago extends Personaje {

	public Mago(Arma arma) {
		super("Mago", "./img/personajes/mago.png", arma, 100, new Inteligencia());

	}

	@Override
	public int atacar(Personaje atacado) {
		int danioInflingido = 0;
		System.out.println(
				this.getNombre() + " ha atacado con su " + this.getArma().getNombre() + " a " + atacado.getNombre());
		if (this.getArma() instanceof Hechizo) {
			danioInflingido = (this.getAtributo().getValorAtributo() + this.getArma().usar());
			System.out.println("El mago aumenta su daño gracias al uso de su atributo! Daño a su oponete ("
					+ danioInflingido + ")");

			atacado.setVida(atacado.getVida() - danioInflingido);

		} else {
			danioInflingido = this.getArma().usar();
			System.out.println("Daño a su oponete (" + danioInflingido + ")");
			atacado.setVida(atacado.getVida() - danioInflingido);
		}
		return danioInflingido;

	}

	public void ataqueEspecial(Personaje atacado) {
		System.out.println(this.getNombre() + " ha lanzado una BOLA DE FUEFO a: " + atacado.getNombre());
		atacado.setVida(atacado.getVida() - 23);
	}

	@Override
	public void morir(Personaje muerto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		this.getFort().atacarAMonstruo(this);
		
	}

}
