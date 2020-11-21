package Ajedrez;

public class Juego {
	private char turno;

	public Juego() {
		this.turno='1';
		
		
		
		
		/**
		 *
		 */
		Tablero t1= new Tablero();
		
		
		
	}

	public char getTurno() {
		return turno;
	}

	public void setTurno(char turno) {
		this.turno = turno;
	}
	
	
}
