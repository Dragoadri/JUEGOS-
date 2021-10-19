package dragonWars.Personaje;

import dragonWars.arma.Arma;
import dragonWars.arma.Hechizo;
import dragonWars.atributo.Atributo;

public class Monstruo extends Personaje {

	public Monstruo() {
		super("Monstruo", "wfwfe", null, 300, null);

	
	
	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int atacar(Personaje atacado) {
		int danio=35;
		System.out.println("---------------------------------------------------");
		System.out.println(this.getNombre()+ " ha atacado a "+atacado.getNombre());
		atacado.setVida(atacado.getVida() - danio);
		System.out.println("Vida del "+atacado.getNombre()+": ("+atacado.getVida()+")");
		System.out.println("Vida del "+this.getNombre()+": ("+this.getVida()+")");
		System.out.println("---------------------------------------------------");
		
		
		return danio;
	}

	@Override
	public void morir(Personaje muerto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ataqueEspecial(Personaje atacado) {
		// TODO Auto-generated method stub
		
	}

}
