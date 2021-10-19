package dragonWars.Personaje;

import dragonWars.arma.Arco;
import dragonWars.arma.Arma;
import dragonWars.arma.Espada;
import dragonWars.atributo.Fuerza;

public class Guerrero extends Personaje {


	
	public Guerrero( Arma arma) {
		super("Guerrero", "./img/personajes/guerrero.png", arma, 100, new Fuerza());
		
	}

	@Override
	public int atacar( Personaje atacado) {
		int danioInflingido=0;
		System.out.println(this.getNombre()+" ha atacado con su "+this.getArma().getNombre()+" a "+atacado.getNombre());
		if (this.getArma() instanceof Espada || this.getArma() instanceof Arco) {
			danioInflingido = (this.getAtributo().getValorAtributo() + this.getArma().usar());

			System.out.println("El mago aumenta su daño gracias al uso de su atributo! Daño a su oponete ("+danioInflingido+")");
			atacado.setVida(atacado.getVida()-danioInflingido);
		
		}else {
			danioInflingido=this.getArma().usar();
			System.out.println("Daño a su oponete ("+danioInflingido+")");
			atacado.setVida(atacado.getVida()-danioInflingido);

			
		}
		return danioInflingido;
		
	}
	
	


	@Override
	public void morir(Personaje muerto) {

		
	}

	@Override
	public void ataqueEspecial(Personaje atacado) {
		// TODO Auto-generated method stub
			System.out.println(this.getNombre()+" ha lanzado un ATAQUE BRUTO a: "+atacado.getNombre());
		atacado.setVida(atacado.getVida()-23);
	}

	@Override
	public void run() {
		
		this.getFort().atacarAMonstruo(this);
		
	}


	
}
