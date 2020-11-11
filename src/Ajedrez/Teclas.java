package Ajedrez;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Teclas extends KeyAdapter {
	public void KeyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}
}
