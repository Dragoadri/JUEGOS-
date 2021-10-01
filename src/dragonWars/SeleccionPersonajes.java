package dragonWars;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.GridLayout;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

public class SeleccionPersonajes extends JFrame {

	private JTextField txtAlto;
	private JTextField txtAncho;
	private JTextField txtNumMinas;
	private JLabel titlePage, personaje1, personaje2,p1Lbl,p2Lbl,armaImg1,armaImg2;
	private JPanel contentPane;
	private ButtonGroup Jugador1, Jugador2;
	private JRadioButton guerrero1, mago1, curandero1, guerrero2, mago2, curandero2;
	private JComboBox arma1,arma2;

	public SeleccionPersonajes() {

		initialize();
		this.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public void comenzarPartida(int alto, int ancho, int minas) {

	}

	public void changeImage(JRadioButton radio, JLabel personaje) {

		personaje.setIcon(new ImageIcon("./img/personajes/" + radio.getText() + ".png"));

	}

	private void initialize() {
		setTitle("Dragon Wars");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// localizacion pantalla
		setBounds(200, 100, 1000, 600);
		setLocationRelativeTo(null);// centra la ventana en el medio

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.white);
		setContentPane(contentPane);
		contentPane.setLayout(null);

// RadioButons groups
		this.Jugador1 = new ButtonGroup();
		this.Jugador2 = new ButtonGroup();
		// Imagenes
		personaje1 = new JLabel("");
		setPhotoConfig(personaje1, 120, 0, 500, 500, "./img/personajes/interrogacion.png");
		personaje2 = new JLabel("");
		setPhotoConfig(personaje2, 580, 0, 500, 500, "./img/personajes/interrogacion.png");
		
		//Imagen personajes
		personaje1 = new JLabel("");
		setPhotoConfig(personaje1, 120, 0, 500, 500, "./img/personajes/interrogacion.png");
		personaje2 = new JLabel("");
		setPhotoConfig(personaje2, 580, 0, 500, 500, "./img/personajes/interrogacion.png");
		//Imagen Arma
		
		
		armaImg1 = new JLabel("");
		setPhotoConfig(armaImg1, 200, 400, 100, 120, "./img/armas/espada.png");
		
		armaImg2 = new JLabel("");
		setPhotoConfig(armaImg2, 680, 400, 100, 120, "./img/armas/espada.png");
		
		
		// RadioButtons
		// Jugador 1
		int x1 = 0, y = 50, x2 = 580;

		guerrero1 = new JRadioButton("guerrero");
		initializeRadiobuttons(guerrero1, Jugador1, 25 + x1, 99 + y, 80, 23,personaje1);
		contentPane.add(guerrero1);
		mago1 = new JRadioButton("mago");
		initializeRadiobuttons(mago1, Jugador1, 25 + x1, 196 + y, 80, 23,personaje1);
		curandero1 = new JRadioButton("curandero");
		initializeRadiobuttons(curandero1, Jugador1, 25 + x1, 287 + y, 90, 23,personaje1);

		// Jugador 2
		guerrero2 = new JRadioButton("guerrero");
		initializeRadiobuttons(guerrero2, Jugador2, 300 + x2, 99 + y, 141, 23,personaje2);
		contentPane.add(guerrero2);
		mago2 = new JRadioButton("mago");
		initializeRadiobuttons(mago2, Jugador2, 300 + x2, 196 + y, 141, 23,personaje2);
		curandero2 = new JRadioButton("curandero");
		initializeRadiobuttons(curandero2, Jugador2, 300 + x2, 287 + y, 141, 23,personaje2);

		//Labels
		titlePage = new JLabel("DRAGON WARS:");
		titlePage.setBounds(370, 0, 303, 76);
		setlabelStyle(titlePage, 30, "FONTS/Normal.ttf", Color.black);
		
		p1Lbl = new JLabel("Personaje 1");
		p1Lbl.setBounds(200, 11, 303, 76);
		setlabelStyle(p1Lbl, 20, "FONTS/Normal.ttf", Color.red);
		
		p2Lbl = new JLabel("Personaje 2");
		p2Lbl.setBounds(650, 11, 303, 76);
		setlabelStyle(p2Lbl, 20, "FONTS/Normal.ttf", Color.red);
		
		
		
		// Combobox
		
		arma1= new JComboBox();
		setComboBox(arma1, 30);
		
		arma1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Jugador 1 escoge: "+arma1.getSelectedItem().toString());
			}
		});
		
		arma2= new JComboBox();
		setComboBox(arma2, 820);

		arma2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Jugador 2 escoge: "+arma2.getSelectedItem().toString());
			}
		});

		// Botones

		JButton btnNewButton = new JButton("COMENZAR PELEA!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// COMENZAR PASRTIDA

			}
		});
		btnNewButton.setBounds(400, 500, 200, 29);
		getContentPane().add(btnNewButton);
		// Metodos

		// ESTILO LABEL

	}

	private void setlabelStyle(JLabel label, float size, String fontPath, Color color) {
		try {
			Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(size);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			// register the font
			ge.registerFont(customFont);
			label.setFont(customFont);
			label.setForeground(color);
			contentPane.add(label);

		} catch (IOException | FontFormatException e) {
			// Handle exception
		}
	}

	public void initializeRadiobuttons(JRadioButton radio, ButtonGroup group, int x, int y, int width, int height,
			JLabel personaje) {

		group.add(radio);
		radio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radio.isSelected()) {
					changeImage(radio, personaje);
				}

			}
		});

		radio.setBackground(Color.white);
		radio.setBounds(x, y, width, height);
		contentPane.add(radio);

	}

	private void setPhotoConfig(JLabel icon, int x, int y, int width, int height, String IconUrl) {
		icon.setBounds(x, y, width, height);
		icon.setIcon(new ImageIcon(IconUrl));
		contentPane.add(icon);

	}
	public void setComboBox(JComboBox comboBox,int x) {

		comboBox.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		comboBox.setBounds(x, 450, 130, 20);
		comboBox.addItem("espada");
		comboBox.addItem("arco");
		comboBox.addItem("hechizo");
		comboBox.addItem("rezo");		
		contentPane.add(comboBox);

	}

}