package Buscaminas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class TabGraf extends JFrame {

	private JPanel contentPane;
	private JButton [][]casillas;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public TabGraf(int filas,int columnas,int minas) {
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(filas, columnas));
		casillas= new JButton[filas][columnas];
		ponerBotones(filas,columnas);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		
	}

	
	
	public void ponerBotones(int filas,int columnas) {
		for (int f = 0; f < casillas.length; f++) {
			for (int c = 0; c < casillas[0].length; c++) {
				contentPane.add(casillas[f][c]=new JButton(f + "-" + c));
			}
		}

	}
}
