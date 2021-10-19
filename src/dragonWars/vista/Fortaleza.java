package dragonWars.vista;

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

import dragonWars.Personaje.Monstruo;
import dragonWars.Personaje.Personaje;
import dragonWars.logic.Logic;

public class Fortaleza extends JFrame {

	private Personaje p1, p2;
	private Monstruo m;
	private JLabel fight, personaje1, personaje2, p1Lbl, p2Lbl, armaImg1, armaImg2, versusLbl, arma1Lbl, arma2Lbl,
			atributo1Lbl, atributo2Lbl, atributoImg1, atributoImg2, vida1LBL, vida2LBL, vida1, vida2, warningLbl,
			danioInfl1, danioInfl2;
	private JPanel contentPane;
	private JButton ataqueP1, ataqueEspecialP1, ataqueP2, ataqueEspecialP2;
	private ArrayList<JButton> botones;
	private StyledButton bStyle;
	private JProgressBar pVida1, pVida2;
	private int turno;
	private Logic logic;
	private Thread t0, t1, t2;

	public Fortaleza(Personaje p1, Personaje p2, Monstruo m) {

		this.p1 = p1;
		this.p2 = p2;
		this.m = m;

		initialize();
		this.logic = new Logic(this);
		logic.muestraTurnoFort();
		setVisible(true);

		this.p1.setFort(this);
		this.p2.setFort(this);

		t1 = new Thread(p1);
		t2 = new Thread(p2);

		t1.start();
		t2.start();

	}

	public synchronized void atacarAMonstruo(Personaje p) {

		while (p.getVida() > 0 && m.getVida() > 0) {
			System.out.println("*******" + p.getNombre() + " va a intentar acabar con " + m.getNombre());

			// actualizarVida(p,m);
			switch (turno) {
		
			case 1:
				logic.eventoAtaqueNormalFort(turno, p, m);
				break;

			case 2:
				logic.eventoAtaqueNormalFort(turno, m, p);
				break;
			}
			if (m.getVida()<=0) {
				System.out.println(p.getNombre() + " ha acabado con "+ m.getNombre());
			}

			actualizarVida(p, m);
			repaint();

			try {
				
				Thread.sleep(1000);

			} catch (Exception e) {
				System.out.println(e);
			}

		}
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
		ataqueNormalEvent(ataqueP1, p1, m, 1);

//		ataqueEspecialP1 = new JButton("Ataque ESPECIAL");
//		buttonConfig(ataqueEspecialP1, 50, 470, 150, 29);
//		ataqueEspecialEvent(ataqueEspecialP1, p1, p2, 1);

//		ataqueP2 = new JButton("Ataque con " + p2.getArma().getNombre());
//		buttonConfig(ataqueP2, 800, 430, 150, 29);
//		ataqueNormalEvent(ataqueP2, p2, m, 2);
//
//		ataqueEspecialP2 = new JButton("Ataque ESPECIAL");
//		buttonConfig(ataqueEspecialP2, 800, 470, 150, 29);
//		ataqueEspecialEvent(ataqueEspecialP2, p2, p1, 2);

	}

//	private void ataqueEspecialEvent(JButton boton, Personaje agresor, Personaje victima, int t) {
//		boton.addActionListener(new ActionListener() {
//
//			public void actionPerformed(ActionEvent e) {
//				logic.eventoAtaqueEspecial(t, agresor, victima);
//			}
//		});
//
//	}

	protected void ataqueNormalEvent(JButton boton, Personaje agresor, Personaje victima, int t) {

		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				logic.eventoAtaqueNormalFort(t, agresor, victima);

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

		danioInfl1 = new JLabel("");
		danioInfl1.setVisible(true);
		danioInfl1.setBounds(220, 450, 303, 76);
		setlabelStyle(danioInfl1, 20, "FONTS/Normal.ttf", Color.black);

		danioInfl2 = new JLabel("");
		danioInfl2.setVisible(true);
		danioInfl2.setBounds(620, 450, 303, 76);
		setlabelStyle(danioInfl2, 20, "FONTS/Normal.ttf", Color.black);

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

	public void actualizarVida(Personaje p, Monstruo mon) {

		vida1.setText(p.getNombre() + " " + (p.getVida() > 0 ? p.getVida() : 0));
		vida2.setText("" + (mon.getVida() > 0 ? mon.getVida() : 0));

		actualizarProgressBar(p, pVida1);
		actualizarProgressBar(mon, pVida2);

	}

	private void actualizarProgressBar(Personaje p, JProgressBar pVida) {

		pVida.setValue(p.getVida());
		pVida.setForeground(this.logic.devuelveColorBarraVida(p.getVida()));

	}

	public void juegoAcabado() {
		disableAllButons();
		warningLbl.setText("EL JUEGO HA ACABADO.");
		warningLbl.setVisible(true);

		if (turno == 2) {
			p1Lbl.setText("<html>" + p1Lbl.getText() + "<br> GANADOR</html>");
		} else if (turno == 1) {
			p2Lbl.setText("<html>" + p2Lbl.getText() + "<br> GANADOR</html>");
		}
	}

	public void lblTurno2() {

		p2Lbl.setText("-" + p2.getNombre() + "-");
		p2Lbl.setForeground(Color.red);
		p1Lbl.setText(p1.getNombre());
		p1Lbl.setForeground(Color.black);
		warningLbl.setVisible(false);

	}

	public void lblTurno1() {

		p1Lbl.setText("-" + p1.getNombre() + "-");
		p1Lbl.setForeground(Color.red);
		p2Lbl.setText(p2.getNombre());
		p2Lbl.setForeground(Color.black);
		warningLbl.setVisible(false);

	}

	private void disableAllButons() {
		for (JButton boton : botones) {
			boton.setEnabled(false);
		}

	}

	public void warningTurno() {
		System.out.println("Es el turno del jugador: " + turno);
		warningLbl.setText("Es el turno del jugador: " + turno);
		warningLbl.setVisible(true);
	}

	public void warningAtaqueEspecial() {
		warningLbl.setText("Ataque especial no disponible");
		warningLbl.setVisible(true);

	}

	private void buttonConfig(JButton boton, int x, int y, int width, int height) {

		boton.setBounds(x, y, width, height);
		boton.setUI(bStyle);
		contentPane.add(boton);
		botones.add(boton);

	}

	public void setDanioInfl1(int x) {
		danioInfl2.setVisible(false);
		danioInfl1.setVisible(true);
		danioInfl1.setText("Danio recibido(" + x + ")");

	}

	public void setDanioInfl2(int x) {
		danioInfl1.setVisible(false);
		danioInfl2.setVisible(true);
		danioInfl2.setText("Danio recibido(" + x + ")");

	}
//-------------------------Geters and setters

	public Personaje getP1() {
		return p1;
	}

	public Personaje getP2() {
		return p2;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public Monstruo getM() {
		return m;
	}

	public void setM(Monstruo m) {
		this.m = m;
	}

}