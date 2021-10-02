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
import javax.swing.JProgressBar;

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
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;

public class Arena extends JFrame {

	private Personaje p1, p2;

	private JLabel titlePage, personaje1, personaje2, p1Lbl, p2Lbl, armaImg1, armaImg2, versusLbl, arma1Lbl, arma2Lbl,
			atributo1Lbl, atributo2Lbl, atributoImg1, atributoImg2, vida1LBL, vida2LBL, vida1, vida2;
	private JPanel contentPane;
	private JButton ataqueP1, ataqueEspecialP1, ataqueP2, ataqueEspecialP2;
	private StyledButton bStyle;
	private JProgressBar pVida1, pVida2;

	public Arena(Personaje p1, Personaje p2) {

		this.p1 = p1;
		this.p2 = p2;
		initialize();
		this.setVisible(true);

	}

	private void initialize() {
		// Configuraciones basicas
		basicCaracteristics();

		// Configuracion JPanel
		contentPaneConfiguration();

		// Imagenes
		lblImageSeters();

		// Labels
		textLabelSetters();

		// Botones
		buttonsSetters();

		// progres Bar

		progresBarSetter();

	}

	private void progresBarSetter() {
		// Progreso vida personaje 1
		pVida1 = new JProgressBar();
		progresConfig(pVida1, 120, 515);

		// Progreso vida personaje 2
		pVida2 = new JProgressBar();
		progresConfig(pVida2, 610, 515);
	}

	private void progresConfig(JProgressBar progres, int x, int y) {
		progres.setValue(100);
		progres.setForeground(Color.green);
		progres.setBounds(x, y, 250, 30);
		contentPane.add(progres);

	}

	private void buttonsSetters() {
		bStyle = new StyledButton();

		ataqueP1 = new JButton("Ataque con " + p1.getArma().getNombre());
		ataqueP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				p1.atacar(p2);
				actualizarVida();
				// Ataque
			}
		});
		ataqueP1.setBounds(50, 430, 150, 29);
		ataqueP1.setUI(bStyle);
		getContentPane().add(ataqueP1);

		ataqueEspecialP1 = new JButton("Ataque ESPECIAL");
		ataqueEspecialP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				p1.ataqueEspecial(p2);
				actualizarVida();
				// Ataque
			}
		});
		ataqueEspecialP1.setBounds(50, 470, 150, 29);
		ataqueEspecialP1.setUI(bStyle);
		getContentPane().add(ataqueEspecialP1);

		ataqueP2 = new JButton("Ataque con " + p2.getArma().getNombre());
		ataqueP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				p2.atacar(p1);
				actualizarVida();
				// Ataque
			}
		});
		ataqueP2.setBounds(800, 430, 150, 29);
		ataqueP2.setUI(bStyle);
		getContentPane().add(ataqueP2);

		ataqueEspecialP2 = new JButton("Ataque ESPECIAL");
		ataqueEspecialP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				p2.ataqueEspecial(p1);
				actualizarVida();
				// Ataque
			}
		});
		ataqueEspecialP2.setBounds(800, 470, 150, 29);
		ataqueEspecialP2.setUI(bStyle);
		getContentPane().add(ataqueEspecialP2);
	}

	private void textLabelSetters() {
		titlePage = new JLabel("ARENA");
		titlePage.setBounds(460, 0, 303, 76);
		setlabelStyle(titlePage, 53, "FONTS/LifeCraft_Font.ttf", Color.black);

		p1Lbl = new JLabel(p1.getNombre().toUpperCase());
		p1Lbl.setBounds(90, -20, 303, 76);
		setlabelStyle(p1Lbl, 40, "FONTS/RF.otf", Color.red);

		p2Lbl = new JLabel(p2.getNombre().toUpperCase());
		p2Lbl.setBounds(730, -20, 303, 76);
		setlabelStyle(p2Lbl, 40, "FONTS/RF.otf", Color.red);

		arma1Lbl = new JLabel("Arma de " + p1.getNombre());
		arma1Lbl.setBounds(300, 100, 303, 76);
		setlabelStyle(arma1Lbl, 15, "FONTS/Normal.ttf", Color.black);

		arma2Lbl = new JLabel("Arma de " + p2.getNombre());
		arma2Lbl.setBounds(590, 100, 303, 76);
		setlabelStyle(arma2Lbl, 15, "FONTS/Normal.ttf", Color.black);

		atributo1Lbl = new JLabel("Atributo: " + p1.getAtributo().getNombreAtributo());
		atributo1Lbl.setBounds(300, 280, 303, 76);
		setlabelStyle(atributo1Lbl, 15, "FONTS/Normal.ttf", Color.black);

		atributo2Lbl = new JLabel("Atributo: " + p2.getAtributo().getNombreAtributo());
		atributo2Lbl.setBounds(590, 280, 303, 76);
		setlabelStyle(atributo2Lbl, 15, "FONTS/Normal.ttf", Color.black);

		vida1LBL = new JLabel("Vida: ");
		vida1LBL.setBounds(20, 490, 303, 76);
		setlabelStyle(vida1LBL, 20, "FONTS/Normal.ttf", Color.black);

		vida1 = new JLabel(p1.getVida() + "");
		vida1.setBounds(70, 490, 303, 76);
		setlabelStyle(vida1, 25, "FONTS/Normal.ttf", Color.black);

		vida2LBL = new JLabel("Vida: ");
		vida2LBL.setBounds(870, 490, 303, 76);
		setlabelStyle(vida2LBL, 20, "FONTS/Normal.ttf", Color.black);

		vida2 = new JLabel(p1.getVida() + "");
		vida2.setBounds(920, 490, 303, 76);
		setlabelStyle(vida2, 25, "FONTS/Normal.ttf", Color.black);

	}

	private void lblImageSeters() {
		// Imagen Versus
		versusLbl = new JLabel("");
		setPhotoConfig(versusLbl, 430, 50, 400, 400, "./img/personajes/versus.png");
		// Imagen personajes
		personaje1 = new JLabel("");
		setPhotoConfig(personaje1, 20, 0, 500, 500, p1.getUrlPhoto());

		personaje2 = new JLabel("");
		setPhotoConfig(personaje2, 730, 0, 500, 500, p2.getUrlPhoto());

		// Imagen Arma

		armaImg1 = new JLabel("");
		setPhotoConfig(armaImg1, 310, 150, 100, 120, p1.getArma().getUrlPhoto());

		armaImg2 = new JLabel("");
		setPhotoConfig(armaImg2, 600, 150, 100, 120, p2.getArma().getUrlPhoto());

		atributoImg1 = new JLabel("");
		setPhotoConfig(atributoImg1, 310, 330, 100, 120, p1.getAtributo().getUrlPhoto());

		atributoImg2 = new JLabel("");
		setPhotoConfig(atributoImg2, 600, 330, 100, 120, p2.getAtributo().getUrlPhoto());

	}

	private void contentPaneConfiguration() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.white);
		setContentPane(contentPane);
		contentPane.setLayout(null);

	}

	private void basicCaracteristics() {

		setTitle("Arena FIGHT!");
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

	private void setPhotoConfig(JLabel icon, int x, int y, int width, int height, String IconUrl) {
		icon.setBounds(x, y, width, height);
		icon.setIcon(new ImageIcon(IconUrl));
		contentPane.add(icon);

	}

	private void actualizarVida() {
		vida1.setText("" + p1.getVida());
		vida2.setText("" + p2.getVida());

		actualizarProgressBar(p1, pVida1);
		actualizarProgressBar(p2, pVida2);

	}

	private void actualizarProgressBar(Personaje p, JProgressBar pVida) {
		pVida.setValue(p.getVida());
		if (p.getVida() <= 20) {
			pVida.setForeground(Color.red);
		} else if (p.getVida() <= 60) {
			pVida.setForeground(Color.orange);

		}
	}

}