package Buscaminas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TabGraf extends JFrame {

	private JPanel contentPane;
	private JButton[][] casilla ;

	
	/**
	 * Create the frame.
	 */
	public TabGraf(int alto,int ancho) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(alto,ancho));
		setContentPane(contentPane);
		
		this.casilla=new JButton[alto][ancho];
		
		
		
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				contentPane.add(casilla[i][j] = new JButton());
			}
		}
	}

}
