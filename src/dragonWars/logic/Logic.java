package dragonWars.logic;

import java.awt.Color;

import javax.swing.JLabel;

import dragonWars.Personaje.Personaje;
import dragonWars.vista.Arena;

public class Logic {

	private Arena arena;

	public Logic(Arena arena) {
		this.arena = arena;
	}

	private int devuelveTurno() {
		return (this.arena.getP1().getVida() <= 0 || this.arena.getP2().getVida() <= 0) ? 0 : this.arena.getTurno();

	}

	public void muestraTurno() {

		switch (devuelveTurno()) {
		case 0:
			this.arena.juegoAcabado();

			break;
		case 1:
			this.arena.lblTurno1();

			break;

		case 2:
			this.arena.lblTurno2();

			break;

		}

	}
	
	public Color devuelveColorBarraVida(int vida){
		
		return vida<=20?Color.red:(vida<=40?Color.orange:(vida<=60?Color.yellow:Color.green));
		
	}
	
	public void eventoAtaqueEspecial(int t,Personaje agresor,Personaje victima) {
		
		if (this.arena.getTurno() == t && agresor.getVida() <= 40) {
			setDanioInfl( agresor.atacar(victima), t);
			
			
			int turno=this.arena.getTurno()== 1 ? 2 : 1;
			
			this.arena.setTurno(turno);
			this.arena.actualizarVida();
			
			
			
			muestraTurno();
			// Ataque
		} else if (agresor.getVida() > 40 && this.arena.getTurno()  == t) {
			this.arena.warningAtaqueEspecial();

		} else {
			this.arena.warningTurno();
		}
		
		
	}
	
public void eventoAtaqueNormal(int t,Personaje agresor,Personaje victima) {
	
	
	if (this.arena.getTurno() == t) {
		int turno=this.arena.getTurno()== 1 ? 2 : 1;
		
		this.arena.setTurno(turno);
		setDanioInfl( agresor.atacar(victima), t);
		
		this.arena.actualizarVida();
		muestraTurno();
		// Ataque
	} else {
		this.arena.warningTurno();
	}
	
}
private void setDanioInfl(int danio,int t) {
	if (t==1) {
		this.arena.setDanioInfl2(danio);
	}else if(t==2) {
		this.arena.setDanioInfl1(danio);

	}
	
}

}
