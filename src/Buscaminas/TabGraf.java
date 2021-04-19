package Buscaminas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class TabGraf extends JFrame {
	
	 private Container contenedor;
	    private GridLayout layout;
	    private JButton[][] botones;
	    
	    
	    public TabGraf() {
	    layout=new GridLayout(8,8);
	    contenedor=getContentPane();
	    contenedor.setLayout(layout);
	    botones=new JButton[8][8];
	    
	       Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	      int height = pantalla.height;
	      int width = pantalla.width;
	      setSize(693, 557);        

	      setLocationRelativeTo(null);
	      
	 
	        
	        
	        for (int i = 0; i < 8; i++) {
	            for (int j = 0; j <8; j++) {
	               
	                if (i==7) {
	                    botones[i][j]=new JButton();
	                }else{
	                    if (i==0) {
	                        botones[i][j]=new JButton("0"); 
	                        
	                       
	                    }else{
	                         botones[i][j]=new JButton("0");
	                    }
	                    
	                }
	               
	                contenedor.add(botones[i][j]);
	            }
	        }
	     
	    }
	            
	}




//public class TabGraf extends JFrame {
//	
//	public static JButton[][] boton;
//	
//	public TabGraf() {
//		this.boton=new JButton[8][8];
//		setTitle("Buscaminas");
//		setBounds(0, 500, 600, 600);
//		setVisible(true);
//		Container contentpane = getContentPane();
//		contentpane.setLayout(new GridLayout(8, 8));
//
//		for (int f = 0; f < 6; f++) {// recorre todo el array con 64 casillas (de 0 a 63)
//			for (int c = 0; c < 6; c++) {
//				contentpane.add(boton[f][c] = new JButton(f+"-"+c));
//				
//			}}
//		
//		
//	}
//}
