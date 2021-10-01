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
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;

public class Arena extends JFrame {
	
	
	private Personaje p1,p2;

	private JLabel titlePage, personaje1, personaje2, p1Lbl, p2Lbl, armaImg1, armaImg2, versusLbl,arma1Lbl,arma2Lbl;
	private JPanel contentPane;
	private JButton ataqueP1,ataqueEspecialP1,ataqueP2,ataqueEspecialP2;
	private StyledButton bStyle;

	public Arena(Personaje p1,Personaje p2) {

		
		this.p1=p1;
		this.p2=p2;
		initialize();
		this.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */

	
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
		
		// Imagenes
		lblImageSeters();

		
		// Labels
		textLabelSetters();

		
		// Botones
		buttonsSetters();

	}

	
	
	private void buttonsSetters() {
		bStyle=new StyledButton();
		
		
		
		ataqueP1 = new JButton("Ataque con "+p1.getArma().getNombre());
		ataqueP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				p1.atacar(p2);
				//Ataque 
			}
		});
		ataqueP1.setBounds(100, 500, 200, 29);
		ataqueP1.setUI(bStyle);
		getContentPane().add(ataqueP1);
		
		
		
		
		ataqueEspecialP1 = new JButton("Ataque ESPECIAL");
		ataqueEspecialP1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				p1.ataqueEspecial(p2);;
				//Ataque 
			}
		});
		ataqueEspecialP1.setBounds(300, 500, 200, 29);
		ataqueEspecialP1.setUI(bStyle);
		getContentPane().add(ataqueEspecialP1);
		
		
		ataqueP2 = new JButton("Ataque con "+p2.getArma().getNombre());
		ataqueP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				p2.atacar(p1);
				//Ataque 
			}
		});
		ataqueP2.setBounds(600, 500, 200, 29);
		ataqueP2.setUI(bStyle);
		getContentPane().add(ataqueP2);
		
		ataqueEspecialP2 = new JButton("Ataque ESPECIAL");
		ataqueEspecialP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				p1.ataqueEspecial(p2);;
				//Ataque 
			}
		});
		ataqueEspecialP2.setBounds(800, 500, 200, 29);
		ataqueEspecialP1.setUI(bStyle);
		getContentPane().add(ataqueEspecialP2);
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
		
		
		arma1Lbl = new JLabel("Arma de luchador");
		arma1Lbl.setBounds(30, 400, 303, 76);
		setlabelStyle(arma1Lbl, 20, "FONTS/TitleFont.ttf", Color.black);
		
		arma2Lbl = new JLabel("Arma de luchador");
		arma2Lbl.setBounds(800, 400, 303, 76);
		setlabelStyle(arma2Lbl, 20, "FONTS/TitleFont.ttf", Color.black);
		
		
		

	}

	

	private void lblImageSeters() {
		// Imagen Versus
		versusLbl = new JLabel("");
		setPhotoConfig(versusLbl, 430, 50, 400, 400, "./img/personajes/versus.png");
		// Imagen personajes
		personaje1 = new JLabel("");
		setPhotoConfig(personaje1, 150, 0, 500, 500, p1.getUrlPhoto());
		personaje2 = new JLabel("");
		setPhotoConfig(personaje2, 600, 0, 500, 500, p2.getUrlPhoto());

		// Imagen Arma

		armaImg1 = new JLabel("");
		setPhotoConfig(armaImg1, 200, 420, 100, 120, p1.getArma().getUrlPhoto());

		armaImg2 = new JLabel("");
		setPhotoConfig(armaImg2, 680, 420, 100, 120, p2.getArma().getUrlPhoto());

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

	

}