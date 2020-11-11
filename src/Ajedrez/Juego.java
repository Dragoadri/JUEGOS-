package Ajedrez;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.Point;


public class Juego extends JFrame{
	int width=640,height=480;
	
	
// Constructor
public Juego() {
	
	
	setTitle("Ajedrez");
	setSize(width,height);
	
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();// para saber las dimensones de la pantalla del ordenador
	this.setLocation(dim.width / 2 - width / 2, dim.height / 2 - height / 2);// para poner la ventana del juego en todo el medio
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	Teclas teclas= new Teclas();
	this.addKeyListener(teclas);
	

	
	Tablero tablero= new Tablero();
	tablero.setSize(50, 100);
	// añade lo que sea tablero y ademas el fondo de la ventana
    this.getContentPane().add(tablero);//.setBackground(Color.yellow);
	
    
	this.setVisible(true);
}
}
