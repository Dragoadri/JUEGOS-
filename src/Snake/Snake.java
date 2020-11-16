
package Snake;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.Point;

public class Snake extends JFrame {

	int width = 640, height = 480;// se usara para la dimension de la pantalla
	ArrayList<Point> lista;// se usara para el cuerpo de la snake
	boolean gameOver = false;// se usara para acabar o no el juego
	Point snake, comida;// se usrara para el comienzo de los puntos de la cabeza de la snake y la comida
	int widthPoint = 10, heightPoint = 10;// se usara para determinar el tamaño de un cuadrado
	ImagenSnake imagenSnake;
	int direccion = KeyEvent.VK_LEFT;// se usara para dterminar la direccion de la snake
	long frecuencia = 35;// velocidad de actualizacion (velocidad de serpiente)

	public Snake() {
		setTitle("Snake");// titulo de laventana
		setSize(width, height);// Para poner las dimensiones de la ventana que en este caso estan guardadas en las variables width y height

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();// para saber las dimensones de la pantalla del ordenador
		this.setLocation(dim.width / 2 - width / 2, dim.height / 2 - height / 2);// para poner la ventana del juego en todo el medio
																					
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// cuando se cierra la ventana cierra la app o la ejecucion del programa

		Teclas teclas = new Teclas();// crea un objeto de la clase teclas que se usaran para escuchar que teclas se pulsan y segun cuales se hacen unas acciones u otras
		this.addKeyListener(teclas);// this refiriendose a snake y add... para escuchar las teclas 

		startGame();// llama a la funcion

		imagenSnake = new ImagenSnake();// se crea el objeto
		this.getContentPane().add(imagenSnake);//

		Momento momento = new Momento();// crea el objeto momento hace que se empiece a mover la snake
		/*
		 * Thread (hilo, tarea) es la clase base de Java para definir hilos de ejecución concurrentes dentro de un mismo programa. ... Son los objetos los que actúan concurrentemente con otros.
		 */
		Thread trid = new Thread(momento);
		trid.start();//comienza el thread

		setVisible(true);// para que se muestre la ventana
	}

	public void startGame() {// todo lo necesario para iniciar el juego
		comida = new Point((int) (Math.random() * 600), (int) (Math.random() * 400));// se crea el puntito de comida rojo en un sitio random de la pantalla cada vez con la var tipo point comida
		snake = new Point(width / 2, height / 2);// se crea el primer punto (cabeza) de la serpiente
		lista = new ArrayList<Point>();// se crea un array que sera el cuerpo de la serpiente
		lista.add(snake);// añade la snake al array/ lista
	}

	public static void main(String[] args) {// el main donde se ejecuta muy peque 
		Snake s = new Snake();
	}

	public void actualizar() {// volver a dibujar el panel donde estan los graficos
		imagenSnake.repaint();
		lista.add(0, new Point(snake.x, snake.y));
		lista.remove((lista.size() - 1));// reduce los arrays

		if ((snake.x > (comida.x - 10)) && (snake.x < (comida.x + 10)) && (snake.y > (comida.y - 10))//si la cabeza de la snake se encuentra con la manzana
				&& (snake.y < (comida.y + 10))) {
			comida = new Point((int) (Math.random() * 600), (int) (Math.random() * 400));// como ya ha comido la manzana se crea otra en un lugar diferente
			lista.add(0, new Point(snake.x, snake.y));// añade un cuadradito mas al cuerpo de la snake
		}

		for (int i = 0; i < lista.size(); i++) {// revisara que la cabeza de la snake no se ha encontrado con su propio juego que seria gameOver
			if(i>1) {
			Point p = lista.get(i);
			// error--------------------------------------------------
			if (snake.x == p.x  && snake.y == p.y ) { // si la posicion snake.x y snake.y que es la cabeza del sanke se encuentra con alguno de sus cuadrados del cuerpo
				gameOver = true;// acaba el juego
			//-------------------------------------------------------
			}}
		}
	}

	public class ImagenSnake extends JPanel {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(new Color(0, 143, 57));// color de serpiente en azul
			g.fillRect(snake.x, snake.y, widthPoint, heightPoint);// dibuja cuadrado rellenado
			for (int i = 0; i < lista.size(); i++) {// por cada cuadradito de mas que habra se crea otro cuadradito
				Point p = (Point) lista.get(i);
				g.fillRect(p.x, p.y, widthPoint, heightPoint);// dibuja cuadrado

			}

			g.setColor(new Color(255, 0, 0));// color de comida en rojo
			g.fillRect(comida.x, comida.y, widthPoint, heightPoint);// dibuja cuadrado
			
			if (gameOver==true) {// cuando acaba el juego
				g.drawString("Game Over",width / 2, height / 2);
			}
		}
	}

	public class Teclas extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {// si pulsas la tecla ESC se sale de la app
				System.exit(0);// todo acaba se sale de la app
			} else if (e.getKeyCode() == KeyEvent.VK_UP) {// se se pulsa la tecla up
				if (direccion != KeyEvent.VK_DOWN) {// y la direccion es diferente de ir para abajo
					direccion = KeyEvent.VK_UP;//entonces SI la serpiente irá hacia arriba 
				}
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {// si se pulsa la tecla de abajo
				if (direccion != KeyEvent.VK_UP) {// y la direccion de la snake NO es hacia arriba
					direccion = KeyEvent.VK_DOWN;// entonces la direccion se actualiza hacia abajo
				}
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // si se pulsa la tecla derecha
				if (direccion != KeyEvent.VK_LEFT) {// y la direccion es diferente de la izquierda
					direccion = KeyEvent.VK_RIGHT;// la direccion se cambia a la drch
				}
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {// si se pulsa la tecla izq 
				if (direccion != KeyEvent.VK_RIGHT) {// y la direccion de la snake va diferente de derecha
					direccion = KeyEvent.VK_LEFT;// la snake ira a la izquierda
				}
			}
		}
	}

	public class Momento extends Thread {
		long last = 0;// el numero largo que se usara con la frecuencia

		public void run() {
			while (true) {// se ejcuta siempre
				if ((java.lang.System.currentTimeMillis() - last) > frecuencia) {
					if (!gameOver) {

						if (direccion == KeyEvent.VK_UP) {// si la direccion es hacia arriba
							snake.y -= heightPoint; // Se actualiza el punto de la snake.y y le se resta 10

							// Si la serpiente se pasa por alto o bajo aparece en el otro extremo
							if (snake.y < 0) {// si la snake pasa la linea del 0 de las ys
								snake.y = height - heightPoint;// la snake aparece arriba del todo
							}
							
						} else if (direccion == KeyEvent.VK_DOWN) {// si loa direccion es hacia abajo
							snake.y += heightPoint;// se actualiza el punto de la snake.y y se le suma 10
							
							if (snake.y > height) {// si la snake se pasa de la altura
								snake.y = 0;// la snake aparece abajo
							}
						} else if (direccion == KeyEvent.VK_RIGHT) {// si se pulsa la tecla para ir a la derecha
							snake.x += widthPoint;// la posicion en x de snake se incrementa en 10
							
							if (snake.x > width) {// si la snake se va mas alla del ancho, aparecera en la izq
								snake.x = 0;
							}
						} else if (direccion == KeyEvent.VK_LEFT) {// si se pulsa la tecla para ir a la izq
							snake.x -= widthPoint;// se decrementa en 10 la pos de snake.x
							if (snake.x < 5) {// si la snake se va por la izq
								snake.x = width - widthPoint;// aparece en la derecha
							}
							
						}
					}
					actualizar();// se llama a actualizar
					last = java.lang.System.currentTimeMillis();// se renueva el valor de la variable last
				}

			}
		}
	}
}
