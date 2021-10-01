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

	private JLabel titlePage, personaje1, personaje2, p1Lbl, p2Lbl, armaImg1, armaImg2, versusLbl;
	private JPanel contentPane;
	private ButtonGroup Jugador1, Jugador2;
	private JRadioButton guerrero1, mago1, curandero1, guerrero2, mago2, curandero2;
	private JButton ComienzoPelea;
	private JComboBox arma1, arma2;

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

		System.out.println(radio.getName());

		personaje.setIcon(new ImageIcon("./img/personajes/" + radio.getText().toLowerCase() + ".png"));

	}

	private void initialize() {
		// Configuraciones basicas
		basicCaracteristics();
		
		// Configuracion JPanel
		contentPaneConfiguration();

		// RadioButons groups
		buttonGroupsInitialize();
		
		// Imagenes
		lblImageSeters();

		// RadioButtons
		radioButtonsSetters();
		
		// Labels
		textLabelSetters();

		// Combobox
		comboBoxSetters();

		// Botones
		buttonsSetters();

	}

	private void buttonsSetters() {
		ComienzoPelea = new JButton("COMENZAR PELEA!");
		ComienzoPelea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// COMENZAR PARTIDA

			}
		});
		ComienzoPelea.setBounds(400, 500, 200, 29);
		getContentPane().add(ComienzoPelea);
	}

	private void comboBoxSetters() {
		arma1 = new JComboBox();
		setComboBox(arma1, 30);

		arma1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Jugador 1 escoge: " + arma1.getSelectedItem().toString());
				armaImg1.setIcon(new ImageIcon("./img/armas/" + arma1.getSelectedItem() + ".png"));
			}
		});

		arma2 = new JComboBox();
		setComboBox(arma2, 820);

		arma2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Jugador 2 escoge: " + arma2.getSelectedItem().toString());
				armaImg2.setIcon(new ImageIcon("./img/armas/" + arma2.getSelectedItem() + ".png"));

			}
		});

	}

	private void textLabelSetters() {
		titlePage = new JLabel("DRAGON WARS:");
		titlePage.setBounds(360, 0, 303, 76);
		setlabelStyle(titlePage, 53, "FONTS/LifeCraft_Font.ttf", Color.black);

		p1Lbl = new JLabel("Luchador 1");
		p1Lbl.setBounds(90, 0, 303, 76);
		setlabelStyle(p1Lbl, 40, "FONTS/RF.otf", Color.red);

		p2Lbl = new JLabel("Luchador 2");
		p2Lbl.setBounds(730, 0, 303, 76);
		setlabelStyle(p2Lbl, 40, "FONTS/RF.otf", Color.red);

	}

	private void radioButtonsSetters() {
		int x1 = 0, y = 50, x2 = 580;

		guerrero1 = new JRadioButton("Guerrero");
		initializeRadiobuttons(guerrero1, Jugador1, 25 + x1, 99 + y, 100, 23, personaje1, 1);
		contentPane.add(guerrero1);
		mago1 = new JRadioButton("Mago");
		initializeRadiobuttons(mago1, Jugador1, 25 + x1, 196 + y, 80, 23, personaje1, 1);
		curandero1 = new JRadioButton("Curandero");
		initializeRadiobuttons(curandero1, Jugador1, 25 + x1, 287 + y, 100, 23, personaje1, 1);

		// Jugador 2
		guerrero2 = new JRadioButton("Guerrero");
		initializeRadiobuttons(guerrero2, Jugador2, 300 + x2, 99 + y, 141, 23, personaje2, 2);
		contentPane.add(guerrero2);
		mago2 = new JRadioButton("Mago");
		initializeRadiobuttons(mago2, Jugador2, 300 + x2, 196 + y, 141, 23, personaje2, 2);
		curandero2 = new JRadioButton("Curandero");
		initializeRadiobuttons(curandero2, Jugador2, 300 + x2, 287 + y, 141, 23, personaje2, 2);

	}

	private void lblImageSeters() {
		// Imagen Versus
		versusLbl = new JLabel("");
		setPhotoConfig(versusLbl, 430, 50, 400, 400, "./img/personajes/versus.png");
		// Imagen personajes
		personaje1 = new JLabel("");
		setPhotoConfig(personaje1, 150, 0, 500, 500, "./img/personajes/interrogacion.png");
		personaje2 = new JLabel("");
		setPhotoConfig(personaje2, 600, 0, 500, 500, "./img/personajes/interrogacion.png");

		// Imagen Arma

		armaImg1 = new JLabel("");
		setPhotoConfig(armaImg1, 200, 420, 100, 120, "./img/armas/espada.png");

		armaImg2 = new JLabel("");
		setPhotoConfig(armaImg2, 680, 420, 100, 120, "./img/armas/espada.png");

	}

	private void buttonGroupsInitialize() {
		this.Jugador1 = new ButtonGroup();
		this.Jugador2 = new ButtonGroup();
	}

	private void contentPaneConfiguration() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.white);
		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	private void basicCaracteristics() {
		setTitle("Dragon Wars");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 1000, 600);
		setLocationRelativeTo(null);// centra la ventana en el medio

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
			JLabel personaje, int p) {

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

	public void setComboBox(JComboBox comboBox, int x) {

		comboBox.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		comboBox.setBounds(x, 480, 130, 20);
		comboBox.addItem("espada");
		comboBox.addItem("arco");
		comboBox.addItem("hechizo");
		comboBox.addItem("rezo");
		contentPane.add(comboBox);

	}

}