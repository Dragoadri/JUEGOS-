package dragonWars.arma;

public class Espada extends Arma {

	public Espada() {
		super(10,20, "Espada", "./img/armas/espada.png");
	}

	@Override
	public int usar() {
		
		return (int)(Math.random()*(this.getDanioMAX()-this.getDanioMIN()+1)+this.getDanioMIN());
		
	}

}
