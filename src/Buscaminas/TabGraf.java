package Buscaminas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabGraf extends JFrame {

	private JPanel contentPane;
	private JButton [][]boton;
	private Casilla [][]casilla;


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
		boton= new JButton[filas][columnas];
		casilla= new Casilla[filas][columnas];

		ponerBotones();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		
	}

	public void chivatoBoton() {
		
		
	}
	
	public void ponerBotones() {
		for (int f = 0; f < boton.length; f++) {
			for (int c = 0; c < boton[0].length; c++) {
				casilla[f][c]=new Casilla(f, c);
				
				contentPane.add(casilla[f][c].getBoton());
				
				
				
				
				
				
				
				boton[f][c].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					System.out.println("Funciona");
						
						
						
					}
				});
			}
		}

	}
}
