package dragonWars;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

public class Arena extends JFrame {

	private Personaje p1, p2;
	private JLabel fight, personaje1, personaje2, p1Lbl, p2Lbl, armaImg1, armaImg2, versusLbl, arma1Lbl, arma2Lbl,
			atributo1Lbl, atributo2Lbl, atributoImg1, atributoImg2, vida1LBL, vida2LBL, vida1, vida2, warningLbl;
	private JPanel contentPane;
	private JButton ataqueP1, ataqueEspecialP1, ataqueP2, ataqueEspecialP2;
	private ArrayList<JButton> botones;
	private StyledButton bStyle;
	private JProgressBar pVida1, pVida2;
	private int turno;

	public Arena(Personaje p1, Personaje p2) {

		this.p1 = p1;
		this.p2 = p2;
		initialize();
		muestraTurno();
		setVisible(true);

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
		buttonConfig(ataqueP1, 50, 430, 150, 29);
		ataqueNormalEvent(ataqueP1, p1, p2, 1);

		ataqueEspecialP1 = new JButton("Ataque ESPECIAL");
		buttonConfig(ataqueEspecialP1, 50, 470, 150, 29);
		ataqueEspecialEvent(ataqueEspecialP1, p1, p2, 1);

		ataqueP2 = new JButton("Ataque con " + p2.getArma().getNombre());
		buttonConfig(ataqueP2, 800, 430, 150, 29);
		ataqueNormalEvent(ataqueP2, p2, p1, 2);

		ataqueEspecialP2 = new JButton("Ataque ESPECIAL");
		buttonConfig(ataqueEspecialP2, 800, 470, 150, 29);
		ataqueEspecialEvent(ataqueEspecialP2, p2, p1, 2);

	}

	private void ataqueEspecialEvent(JButton boton, Personaje agresor, Personaje victima, int t) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (turno == t && agresor.getVida() <= 40) {
					agresor.ataqueEspecial(victima);
					turno += t == 1 ? 1 : -1;
					actualizarVida();
					muestraTurno();

					// Ataque
				} else if (agresor.getVida() > 40 && turno == t) {
					warningAtaqueEspecial();

				} else {
					warningTurno();
				}

			}
		});

	}

	protected void ataqueNormalEvent(JButton boton, Personaje agresor, Personaje victima, int t) {

		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (turno == t) {
					turno += t == 1 ? 1 : -1;
					agresor.atacar(victima);
					actualizarVida();
					muestraTurno();
					// Ataque
				} else {
					warningTurno();
				}

			}

		});
	}

	private void textLabelSetters() {

		p1Lbl = new JLabel(p1.getNombre().toUpperCase());
		p1Lbl.setBounds(90, 0, 303, 76);
		setlabelStyle(p1Lbl, 40, "FONTS/RF.otf", Color.black);

		p2Lbl = new JLabel(p2.getNombre().toUpperCase());
		p2Lbl.setBounds(680, 0, 303, 76);
		setlabelStyle(p2Lbl, 40, "FONTS/RF.otf", Color.black);

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

		warningLbl = new JLabel("");
		warningLbl.setVisible(false);
		warningLbl.setBounds(380, 450, 303, 76);
		setlabelStyle(warningLbl, 20, "FONTS/Normal.ttf", Color.red);

	}

	private void lblImageSeters() {
		
		fight = new JLabel("");
		setPhotoConfig(fight, 400, -140, 250, 400, "./img/personajes/fight.png");
		
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
		this.turno = 1;
		this.botones = new ArrayList<>();

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
		vida1.setText("" + (p1.getVida()>0?p1.getVida():0));
		vida2.setText("" + (p2.getVida()>0?p2.getVida():0));

		actualizarProgressBar(p1, pVida1);
		actualizarProgressBar(p2, pVida2);

	}

	private void actualizarProgressBar(Personaje p, JProgressBar pVida) {
		pVida.setValue(p.getVida());
		if (p.getVida() <= 20) {
			pVida.setForeground(Color.red);
		} else if (p.getVida() <= 40) {
			pVida.setForeground(Color.orange);

		} else if (p.getVida() <= 60) {
			pVida.setForeground(Color.yellow);

		}
	}

	private void muestraTurno() {

		if (p1.getVida() <= 0 || p2.getVida() <= 0) {

			juegoAcabado();

		} else if (turno == 1) {

			lblTurnoCaracteristics(p1Lbl, p2Lbl, p1, p2);

		} else if (turno == 2) {

			lblTurnoCaracteristics(p2Lbl, p1Lbl, p2, p1);

		}

	}

	private void juegoAcabado() {
		disableAllButons();
		warningLbl.setText("EL JUEGO HA ACABADO.");
		warningLbl.setVisible(true);
		if (turno == 2) {
			p1Lbl.setText("<html>" + p1Lbl.getText() + "<br> GANADOR<html>");
		} else if (turno == 1) {
			p2Lbl.setText("<html>" + p2Lbl.getText() + "<br> GANADOR<html>");
		}
	}

	private void lblTurnoCaracteristics(JLabel labelTurno, JLabel labelNoTurno, Personaje suTurno,
			Personaje pierdeTurno) {

		labelTurno.setText("->" + suTurno.getNombre() + "<-");
		labelTurno.setForeground(Color.red);
		labelNoTurno.setText(pierdeTurno.getNombre());
		labelNoTurno.setForeground(Color.black);
		warningLbl.setVisible(false);

	}

	private void disableAllButons() {
		for (JButton boton : botones) {
			boton.setEnabled(false);
		}

	}

	private void warningTurno() {
		System.out.println("Es el turno del jugador: " + turno);
		warningLbl.setText("Es el turno del jugador: " + turno);
		warningLbl.setVisible(true);
	}

	private void warningAtaqueEspecial() {
		warningLbl.setText("Ataque especial no disponible");
		warningLbl.setVisible(true);

	}

	private void buttonConfig(JButton boton, int x, int y, int width, int height) {

		boton.setBounds(x, y, width, height);
		boton.setUI(bStyle);
		contentPane.add(boton);
		botones.add(boton);

	}
}