
package Juego;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.Point;

public class Snake extends JFrame {

	int width = 640, height = 480;
	ArrayList<Point> lista;
	boolean gameOver = false;
	Point snake, comida;
	int widthPoint = 10, heightPoint = 10;
	ImagenSnake imagenSnake;
	int direccion = KeyEvent.VK_LEFT;
	long frecuencia = 25;// velocidad de la serpiente

	public Snake() {
		setTitle("Snake");
		setSize(width, height);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();// para saber las dimensones de la pantalla
		this.setLocation(dim.width / 2 - width / 2, dim.height / 2 - height / 2);// para poner la ventana en el centro
																					// de la pantalla
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// cuando se cierra la ventana cierra la app

		Teclas teclas = new Teclas();// para que funcione el esc se crea el objeto de la clase Teclas
		this.addKeyListener(teclas);

		startGame();

		imagenSnake = new ImagenSnake();
		this.getContentPane().add(imagenSnake);

		Momento momento = new Momento();// hace que se empiece a mover la snake
		Thread trid = new Thread(momento);
		trid.start();

		setVisible(true);
	}

	public void startGame() {
		comida = new Point((int) (Math.random() * 600), (int) (Math.random() * 400));
		snake = new Point(width / 2, height / 2);
		lista = new ArrayList<Point>();
		lista.add(snake);
	}

	public static void main(String[] args) {
		Snake s = new Snake();
	}

	public void actualizar() {// volver a dibujar el panel donde estan los graficos
		imagenSnake.repaint();
		lista.add(0, new Point(snake.x, snake.y));
		lista.remove((lista.size() - 1));

		if ((snake.x > (comida.x - 10)) && (snake.x < (comida.x + 10)) && (snake.y > (comida.y - 10))
				&& (snake.y < (comida.y + 10))) {
			comida = new Point((int) (Math.random() * 640), (int) (Math.random() * 480));
			lista.add(0, new Point(snake.x, snake.y));
		}

		for (int i = 0; i < lista.size(); i++) {
			Point p = lista.get(i);
			// error--------------------------------------------------
			if (snake.x == p.x && snake.y == p.y) {
				gameOver = true;
			//-------------------------------------------------------
			}
		}
	}

	public class ImagenSnake extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(new Color(0, 0, 255));// color de serpiente en azul
			g.fillRect(snake.x, snake.y, widthPoint, heightPoint);// dibuja cuadrado
			for (int i = 0; i < lista.size(); i++) {
				Point p = (Point) lista.get(i);
				g.fillRect(p.x, p.y, widthPoint, heightPoint);// dibuja cuadrado

			}

			g.setColor(new Color(255, 0, 0));// color de comida en rojo
			g.fillRect(comida.x, comida.y, widthPoint, heightPoint);// dibuja cuadrado
			
			if (gameOver==true) {
				g.drawString("Game Over",width / 2, height / 2);
			}
		}
	}

	public class Teclas extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {// si pulsas la tecla ESC se sale de la app
				System.exit(0);
			} else if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (direccion != KeyEvent.VK_DOWN) {
					direccion = KeyEvent.VK_UP;
				}
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (direccion != KeyEvent.VK_UP) {
					direccion = KeyEvent.VK_DOWN;
				}
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (direccion != KeyEvent.VK_LEFT) {
					direccion = KeyEvent.VK_RIGHT;
				}
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (direccion != KeyEvent.VK_RIGHT) {
					direccion = KeyEvent.VK_LEFT;
				}
			}
		}
	}

	public class Momento extends Thread {
		long last = 0;

		public void run() {
			while (true) {
				if ((java.lang.System.currentTimeMillis() - last) > frecuencia) {
					if (!gameOver) {

						if (direccion == KeyEvent.VK_UP) {
							snake.y = snake.y - heightPoint;

							// Si la serpiente se pasa por alto o bajo aparece en el otro extremo
							if (snake.y < 0) {
								snake.y = height - heightPoint;
							}
							if (snake.y > height) {
								snake.y = 0;
							}
						} else if (direccion == KeyEvent.VK_DOWN) {
							snake.y = snake.y + heightPoint;
							if (snake.y < 0) {
								snake.y = height - heightPoint;
							}
							if (snake.y > height) {
								snake.y = 0;
							}
						} else if (direccion == KeyEvent.VK_RIGHT) {
							snake.x = snake.x + widthPoint;
							if (snake.x < 0) {
								snake.x = width - widthPoint;
							}
							if (snake.x > width) {
								snake.x = 0;
							}
						} else if (direccion == KeyEvent.VK_LEFT) {
							snake.x = snake.x - widthPoint;
							if (snake.x < 0) {
								snake.x = width - widthPoint;
							}
							if (snake.x > width) {
								snake.x = 0;
							}
						}
					}
					actualizar();
					last = java.lang.System.currentTimeMillis();
				}

			}
		}
	}
}
