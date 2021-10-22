package dragonWars.logic;

import java.awt.Color;

import dragonWars.Personaje.Personaje;
import dragonWars.vista.Arena;
import dragonWars.vista.Fortaleza;

public class Logic {

	private Arena arena;
	private Fortaleza fort;

	public Logic(Arena arena) {
		this.arena = arena;
	}
	public Logic(Fortaleza fort) {
		this.fort = fort;
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
	
}//Duplicados , crear eventos para quitar






public void eventoAtaqueNormalFort(int t,Personaje agresor,Personaje victima) {
	
	
	if (this.fort.getTurno() == t) {
		int turno=this.fort.getTurno()== 1 ? 2 : 1;
		
		this.fort.setTurno(turno);
		setDanioInflFort(agresor.atacar(victima), t);
		
		
		
		//muestraTurnoFort();
		
		// Ataque
	} else {
		this.fort.warningTurno();
	}
	
	
}
private void setDanioInflFort(int danio,int t) {
	if (t==1) {
		this.fort.setDanioInfl2(danio);
	}else if(t==2) {
		this.fort.setDanioInfl1(danio);

	}
	
}

private int devuelveTurnoFort() {
	return (this.fort.getP1().getVida() <= 0 || this.fort.getP2().getVida() <= 0) ? 0 : this.fort.getTurno();

}
public void muestraTurnoFort(Personaje p) {

	switch (devuelveTurnoFort()) {
	case 0:
		//this.fort.juegoAcabado();

		break;
	case 1:
		this.fort.lblTurno1(p);

		break;

	case 2:
		this.fort.lblTurno2(p);

		break;

	}

}

}
