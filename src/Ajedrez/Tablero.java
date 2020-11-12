package Ajedrez;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero extends JPanel   {

	public Tablero() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		
		
		JLabel etiqueta = new JLabel("hola");
		etiqueta.setLayout(null);
		etiqueta.setBounds(100, 100, 500, 500);
		etiqueta.setBackground(Color.black);
		etiqueta.setOpaque(true);
		
		
		this.add(etiqueta);
	}

}
