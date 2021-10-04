package dragonWars.arma;

public class Hechizo extends Arma {

	public Hechizo() {
		super(10,20, "Hechizo", "./img/armas/hechizo.png");
	}

	@Override
public int usar() {
		
		return (int)(Math.random()*(this.getDanioMAX()-this.getDanioMIN()+1)+this.getDanioMIN());
		
	}

}
