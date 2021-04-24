package Buscaminas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TabGraf extends JFrame {

	private JPanel contentPane;
	private Casilla[][] casilla;
	private int filas;
	private int columnas;
	private int minas;
	private Juego jue;

	public TabGraf(int filas, int columnas, int minas) {
		this.filas = filas;
		this.columnas = columnas;
		this.minas = minas;

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(filas, columnas));
		setTitle("Juego");
		casilla = new Casilla[filas][columnas];
		// metodos
		inicio();
		// mas

sizeVentana( columnas);
		jue = new Juego(this);
		if (jue.minaExplota()) {
			System.out.println("perdio");
		}

	}

	public void inicio() {
		ponerBotones();
		rellenarTablero();
		colocar();
		listenerBoton();
	}

	public void listenerBoton() {
		for (int i = 0; i < casilla.length; i++) {
			for (int j = 0; j < casilla[0].length; j++) {
				evento(i, j);
			}
		}

	}

	public void evento(int i, int j) {

		casilla[i][j].getBoton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				getJue().hacerVisible(i, j);

				if (getJue().esGanador()) {
					setTitle("Has Ganado!");
				} else if (getJue().minaExplota()) {
					setTitle("has perdido :(");
				}

				if ((e.getModifiers() & 4) != 0) {
					System.out.println("botonderecho");
				}

				// getJue().hacervisibleTodasLasMinas();

			}
		});

		casilla[i][j].getBoton().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 3) {

					if (!casilla[i][j].getContenido().isBanderinColocado()) {

						casilla[i][j].getContenido().setBanderinColocado(true);
						casilla[i][j].getBoton().setIcon(casilla[i][j].getContenido().getBanderin());
					} else {
						casilla[i][j].getContenido().setBanderinColocado(false);
						casilla[i][j].getBoton().setIcon(new ImageIcon(" "));

					}
				}
			}
		});
	}

	public void ponerBotones() {
		for (int f = 0; f < casilla.length; f++) {
			for (int c = 0; c < casilla[0].length; c++) {
				casilla[f][c] = new Casilla(f, c, new caso("nada", ' ', false), this.getJue());
				// contentPane.add(casilla[f][c].getBoton());
			}
		}
	}

	public void colocar() {
		for (int f = 0; f < casilla.length; f++) {
			for (int c = 0; c < casilla[0].length; c++) {
				contentPane.add(casilla[f][c].getBoton());
			}
		}

	}

	public void rellenarTablero() {
		for (int i = 0; i < this.minas; i++) {
			int f = 0;
			int c = 0;
			do {
				f = (int) (Math.random() * (this.casilla.length - 1 + 1 - 1)) + 1;
				c = (int) (Math.random() * (this.casilla[0].length - 1 + 1 - 1)) + 1;

			} while (casilla[f][c].getContenido().isEsMina());
			casilla[f][c].setContenido(new caso("mina", '@', true));
			// contentPane.add(casilla[f][c].getBoton());

		}

		for (int i = 0; i < casilla.length; i++) {
			for (int j = 0; j < casilla[i].length; j++) {

				if (casilla[i][j].getContenido().getNombre().equals("nada"))

				{
					int contMinas = 0;
					// contentPane.add(casilla[i][j].getBoton());
					try {
						if (casilla[i - 1][j].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {

					}
					try {
						if (casilla[i + 1][j].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					try {
						if (casilla[i - 1][j - 1].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					try {
						if (casilla[i - 1][j + 1].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					try {
						if (casilla[i + 1][j - 1].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					try {
						if (casilla[i + 1][j + 1].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					try {
						if (casilla[i][j + 1].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					try {
						if (casilla[i][j - 1].getContenido().isEsMina()) {
							contMinas++;
						}
					} catch (Exception e) {
					}
					if (contMinas != 0) {
						// casilla[i][j].getContenido().setSimbolo(Integer.toString(contMinas).charAt(0));
						casilla[i][j].setContenido(new caso("numero", Integer.toString(contMinas).charAt(0), false));

					}

				}
//				this.casilla[i][j].actualizarBot();
			}
		}

	}

	public void sizeVentana(int c) {
		switch (c) {
		case 9:
			setBounds(800, 250, 500, 500);

			break;
		case 16:
			setBounds(800, 100, 820, 800);

			break;
		case 30:
			setBounds(300, 150, 1500, 800);

			break;

		default:
			setBounds(100, 50, 1200, 1000);
		}
	}

	public Casilla[][] getCasillas() {
		return casilla;
	}

	public Juego getJue() {
		return jue;
	}

}
