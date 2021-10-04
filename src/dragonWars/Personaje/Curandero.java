package dragonWars.Personaje;

import dragonWars.arma.Arma;
import dragonWars.arma.Hechizo;
import dragonWars.atributo.Sabiduria;

public class Curandero extends Personaje {


	
	public Curandero(Arma arma) {
		super("Cuarandero", "./img/personajes/curandero.png", arma, 100, new Sabiduria());
		
	}

	@Override
	public int atacar( Personaje atacado) {
		int danioInflingido = 0;
		System.out.println(this.getNombre()+" ha atacado con su "+this.getArma().getNombre()+" a "+atacado.getNombre());
		if (this.getArma() instanceof Hechizo) {
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
	
	public void ataqueEspecial(Personaje atacado){
		System.out.println("El curandero ha usado recuperacion, ha ganado 20HP");
		this.setVida(this.getVida()+20);
	}

	@Override
	public void morir(Personaje muerto) {
		// TODO Auto-generated method stub
		
	}


}
