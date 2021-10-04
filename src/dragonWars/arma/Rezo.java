package dragonWars.arma;

public class Rezo extends Arma {

	public Rezo() {
		super(10,20, "Hechizo", "./img/armas/rezo.png");
	}

	@Override
public int usar() {
		
		return (int)(Math.random()*(this.getDanioMAX()-this.getDanioMIN()+1)+this.getDanioMIN());
		
	}

}
