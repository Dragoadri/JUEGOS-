package Ajedrez;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero extends JPanel {

	public Tablero() {
		JPanel panel = new JPanel();
		JLabel etiqueta = new JLabel();

		
		etiqueta.setLayout(null);
		
	
		panel.setBackground(Color.red);
		
		etiqueta.setLocation(10, 20);
		etiqueta.setText("Hola");
		
		
		
		this.add(etiqueta);
	}

}
