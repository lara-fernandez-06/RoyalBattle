package battleRoyale_v1;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Imagenfondo extends JPanel{
	
//---VARIABLES---
	private Image fondo;

//---FUNCIONES---	
	 public Imagenfondo(String pathImagen) {
	        // Cargar la imagen
	        ImageIcon icon = new ImageIcon(pathImagen);
	        fondo = icon.getImage();
	    }
	
	 @Override
	 protected void paintComponent(Graphics g) {
		 super.paintComponent(g);
		 //Para que lo cubra todo
	        if (fondo != null) {
	            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
	    }
  }
}

