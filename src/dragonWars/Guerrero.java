package dragonWars;

public class Guerrero extends Personaje {


	
	public Guerrero(String nombre, Arma arma) {
		super(nombre, "./img/personajes/guerrero.png", arma, 100, new Fuerza());
		
	}

	@Override
	public void atacar( Personaje atacado) {
		System.out.println(this.getNombre()+" ha atacado con su "+this.getArma().getNombre()+" a "+atacado.getNombre());
		if (this.getArma() instanceof Espada || this.getArma() instanceof Arco) {
			System.out.println("El mago aumenta su daño gracias al uso de su atributo! Daño a su oponete ("+this.getAtributo().getValorAtributo()+this.getArma().getDanio()+")");
			atacado.setVida(atacado.getVida()-(this.getAtributo().getValorAtributo()+this.getArma().getDanio()));
		
		}else {
			System.out.println("Daño a su oponete ("+this.getArma().getDanio()+")");
			atacado.setVida(atacado.getVida()-(this.getArma().getDanio()));

			
		}
		
	}
	


	@Override
	public void morir(Personaje muerto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ataqueEspecial(Personaje atacado) {
		// TODO Auto-generated method stub
			System.out.println(this.getNombre()+" ha lanzado un ATAQUE BRUTO a: "+atacado.getNombre());
		atacado.setVida(atacado.getVida()-23);
	}


	
}
