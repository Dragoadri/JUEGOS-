package dragonWars;

public class Curandero extends Personaje {


	
	public Curandero(String nombre, Arma arma) {
		super(nombre, "./img/personajes/guerrero.png", arma, 100, new Sabiduria());
		
	}

	@Override
	public void atacar( Personaje atacado) {
		System.out.println(this.getNombre()+" ha atacado con su "+this.getArma().getNombre()+" a "+atacado.getNombre());
		if (this.getArma() instanceof Hechizo) {
			System.out.println("El mago aumenta su daño gracias al uso de su atributo! Daño a su oponete ("+this.getAtributo().getValorAtributo()+this.getArma().getDanio()+")");
			atacado.setVida(atacado.getVida()-(this.getAtributo().getValorAtributo()+this.getArma().getDanio()));
		
		}else {
			System.out.println("Daño a su oponete ("+this.getArma().getDanio()+")");
			atacado.setVida(atacado.getVida()-(this.getArma().getDanio()));

			
		}
		
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
