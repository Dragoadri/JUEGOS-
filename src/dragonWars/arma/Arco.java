package dragonWars.arma;

public class Arco extends Arma {

	public Arco() {
		super(10,20, "Arco", "./img/armas/arco.png");
	}

	@Override
public int usar() {
		
		return (int)(Math.random()*(this.getDanioMAX()-this.getDanioMIN()+1)+this.getDanioMIN());
		
	}

}
