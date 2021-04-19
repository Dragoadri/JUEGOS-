package Buscaminas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

public class Dificultad {

	private JFrame frame;
	private JTextField txtAlto;
	private JTextField txtAncho;
	private JTextField txtNumMinas;
	private JRadioButton principiante;
	private JRadioButton intermedio;
	private JRadioButton avanzado;
	private JRadioButton personalizado;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dificultad window = new Dificultad();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Dificultad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public void comenzarPartida(int alto,int ancho,int minas) {
		Scanner in = new Scanner(System.in);

		Juego j = new Juego(new Tablero(alto,ancho,minas));
		j.inicio();

		TabGraf tab = new TabGraf();
		tab.setVisible(true);
		
		
		
		
		while (!j.minaExplota()&&!j.esGanador()) {
					j.mostrarTablero();

			System.out.println("\n\n--Casilla a pulsar--\n\nIntroduzca fila:");
			int filaPide = in.nextInt();
			System.out.println("Introduzca columna");
			int columnaPide = in.nextInt();
			j.hacerVisible(filaPide, columnaPide);
		}
		j.mostrarTablero();
		System.out.println(j.esGanador()?"\nFELICIDADES!\n"
				+ "HAS GANADO":"\n\nBUM!!!\n" + "HAS EXPLOTADO UNA MINA\n");
		System.out.println("------FIN DEL JUEGO------");
	}

	public void disableTxt() {
		txtAlto.setEnabled(false);
		txtAncho.setEnabled(false);
		txtNumMinas.setEnabled(false);
	}

	private void initialize() {
		frame = new JFrame("Menu del juego BUSCAMINAS");
		frame.setBounds(100, 100, 525, 449);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// RadioButtons
		principiante = new JRadioButton("Principiante ");
		buttonGroup.add(principiante);
		principiante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (principiante.isSelected()) {
					disableTxt();
				}

			}
		});
		principiante.setSelected(true);
		principiante.setBounds(25, 99, 141, 23);
		frame.getContentPane().add(principiante);

		intermedio = new JRadioButton("Intermedio");
		buttonGroup.add(intermedio);
		intermedio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (intermedio.isSelected()) {
					disableTxt();
				}
			}
		});
		intermedio.setBounds(25, 196, 141, 23);
		frame.getContentPane().add(intermedio);

		avanzado = new JRadioButton("Avanzado");
		buttonGroup.add(avanzado);
		avanzado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (avanzado.isSelected()) {
					disableTxt();
				}

			}
		});
		avanzado.setBounds(25, 287, 141, 23);
		frame.getContentPane().add(avanzado);

		personalizado = new JRadioButton("Personalizado");
		buttonGroup.add(personalizado);
		personalizado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (personalizado.isSelected()) {
					txtAlto.setEnabled(true);
					txtAncho.setEnabled(true);
					txtNumMinas.setEnabled(true);
				}
			}
		});
		personalizado.setBounds(233, 99, 141, 23);
		frame.getContentPane().add(personalizado);

		// Labels

		JLabel lblNewLabel = new JLabel("DIFICULTAD BUSCAMINAS: ");
		lblNewLabel.setBounds(51, 11, 303, 76);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("10 Minas");
		lblNewLabel_1.setBounds(51, 134, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Cuadricula de 9x9 mosaicos");
		lblNewLabel_2.setBounds(51, 162, 185, 16);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_1_1 = new JLabel("40 Minas");
		lblNewLabel_1_1.setBounds(51, 231, 61, 16);
		frame.getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_2_1 = new JLabel("Cuadricula de 16x16 mosaicos");
		lblNewLabel_2_1.setBounds(51, 259, 199, 16);
		frame.getContentPane().add(lblNewLabel_2_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("99 Minas");
		lblNewLabel_1_1_1.setBounds(51, 322, 61, 16);
		frame.getContentPane().add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Cuadricula de 16x30 mosaicos");
		lblNewLabel_2_1_1.setBounds(51, 353, 199, 16);
		frame.getContentPane().add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_3 = new JLabel("Alto (9-24):");
		lblNewLabel_3.setForeground(Color.GRAY);
		lblNewLabel_3.setBounds(259, 162, 81, 16);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Ancho (9-30):");
		lblNewLabel_3_1.setForeground(Color.GRAY);
		lblNewLabel_3_1.setBounds(259, 199, 88, 16);
		frame.getContentPane().add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("Minas (10-668):");
		lblNewLabel_3_2.setForeground(Color.GRAY);
		lblNewLabel_3_2.setBounds(259, 236, 107, 16);
		frame.getContentPane().add(lblNewLabel_3_2);

		JLabel lblNewLabel_4 = new JLabel("Buena suerte!");
		lblNewLabel_4.setBounds(266, 353, 88, 16);
		frame.getContentPane().add(lblNewLabel_4);

		// Area de texto

		txtAlto = new JTextField();
		txtAlto.setEnabled(false);
		txtAlto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (personalizado.isSelected()) {
					txtAlto.setEditable(true);
				}
			}
		});
		txtAlto.setBounds(355, 157, 130, 26);
		frame.getContentPane().add(txtAlto);
		txtAlto.setColumns(10);

		txtAncho = new JTextField();
		txtAncho.setEnabled(false);
		txtAncho.setColumns(10);
		txtAncho.setBounds(355, 194, 130, 26);
		frame.getContentPane().add(txtAncho);

		txtNumMinas = new JTextField();
		txtNumMinas.setEnabled(false);
		txtNumMinas.setColumns(10);
		txtNumMinas.setBounds(355, 231, 130, 26);
		frame.getContentPane().add(txtNumMinas);

		// Botones

		JButton btnNewButton = new JButton("Comenzar!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comenzarPartida(finalAlto(),finalAncho(),finalMinas());
				
				
			}
		});
		btnNewButton.setBounds(358, 348, 117, 29);
		frame.getContentPane().add(btnNewButton);
 // Metodos
		
		
		
	}
	public int finalAlto() {
			int alto = 0;
			if (principiante.isSelected()) {
				alto = 9;
			} else if (intermedio.isSelected()) {
				alto = 16;
			} else if (avanzado.isSelected()) {
				alto = 16;
			} else if (personalizado.isSelected()) {
				alto = Integer.parseInt(txtAlto.getText());
			}
			return alto;
		}
	public int finalAncho() {
		int ancho = 0;
		if (principiante.isSelected()) {
			ancho = 9;
		} else if (intermedio.isSelected()) {
			ancho = 16;
		} else if (avanzado.isSelected()) {
			ancho = 30;
		} else if (personalizado.isSelected()) {
			ancho = Integer.parseInt(txtAncho.getText());
		}
		return ancho;
	}
	public int finalMinas() {
		int minas = 0;
		if (principiante.isSelected()) {
			minas = 10;
		} else if (intermedio.isSelected()) {
			minas = 40;
		} else if (avanzado.isSelected()) {
			minas = 99;
		} else if (personalizado.isSelected()) {
			minas = Integer.parseInt(txtNumMinas.getText());
		}
		return minas;
	}
}