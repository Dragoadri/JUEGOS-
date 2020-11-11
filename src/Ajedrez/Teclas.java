package Ajedrez;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Toolkit;
import java.awt.Point;

public class Teclas extends KeyAdapter {
	public void KeyPressed(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}
}
