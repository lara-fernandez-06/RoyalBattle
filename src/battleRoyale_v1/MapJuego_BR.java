package battleRoyale_v1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MapJuego_BR {

	
	
	public static void mapJuego_BR(int alto, int ancho) {
		System.out.println("HAS ABIERTO EL MAPA DEL JUEGO");
//---VARIABLES---
		//Sacar el ancho y alto que ha decidido el usuario			
				//System.out.println("Ancho:"+ancho+" Alto: "+alto);
		//---FONT--- 
			//La fuente que voy a usar, sitiene algún tipo especial y el tamaño
				Font fuenteTitulo=new Font("Times New Roman", Font.BOLD, 40); 
				Font fuenteSubtitulo=new Font("Times New Roman", Font.PLAIN, 20); 
				Font fuenteTexto=new Font("Times New Roman", Font.BOLD, 15); 
				Font fuentepiePagina=new Font("Times New Roman", Font.ITALIC, 10); 

//---INICIALIZAR JFRAME---
			JFrame jFrame = new JFrame("RoyalBattle_MapaJuego");

			//---JFRAME---				
		    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    jFrame.setSize(alto, ancho);  //Tamaño de la ventana
		    jFrame.setResizable(false); //Para que en esta pantalla no pueda agrandar la pantalla -> Queda más aestethic aka parecido a un programa antes de inicializar
		    jFrame.setLocationRelativeTo(null); //Cerrar proceso al cerrar la ventana

//---IMAGEN FONDO---
		    Imagenfondo imagenFondo = new Imagenfondo("fondoImagen.jpg");
			imagenFondo.setLayout(new BorderLayout());
			imagenFondo.setBorder(new EmptyBorder(20,15,5,15));//Para ponerle margen alrededor (Arriba, derecha, abajo, izquierda)		
//---IMAGEN MAPA---
		    Imagenfondo imagenMapa = new Imagenfondo("mapa.jpg");
			imagenFondo.setLayout(new BorderLayout());
			imagenFondo.setBorder(new EmptyBorder(20,15,5,15));//Para ponerle margen alrededor (Arriba, derecha, abajo, izquierda)		  
		    
//---CREACIÓN DE LAS INTERFAZ DE CREACIÓN DE PERSONAJE ---	
			 //---TÍTULO---
		    JLabel titulo = new JLabel(); 
		    titulo.setText("ROYALBATTLE");
		    titulo.setFont(fuenteTitulo);
		    titulo.setHorizontalAlignment(SwingConstants.CENTER);//Para que se quede en el centro de la pantalla
		    titulo.setForeground(Color.white);
		    titulo.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		    
		   
		    //---PIE DE PÁGINA---
		    JLabel piePagina = new JLabel();
		    piePagina.setText("<html><br>Trabajo creado por:<br>Carlos Bravo, Lara Fernandez, Alonnso López, Cecilia Muñoz, Adriana Remiro</html>");
		    piePagina.setFont(fuentepiePagina);
		    piePagina.setForeground(Color.white);
		    
		    
// ---CONTAINERS Y JPANELS---	   	    
		    //---CONTENEDOR GENERAL---
		    Container contentPane = jFrame.getContentPane(); 
	        contentPane.setLayout(new BorderLayout());  
	        
		    //---SOBRE TEXTOS---		
	        JPanel posicionTitulo = new JPanel();
	        posicionTitulo.setOpaque(false); // Transparente para que se vea la imagen
	        posicionTitulo.setLayout(new GridLayout(2,1,1,1));	
	        
	        JPanel posicionPiePagina = new JPanel();
		    posicionPiePagina.setOpaque(false); 
		    posicionPiePagina.setLayout(new GridLayout(2,1,1,1));	
		    
		    //---COSITAS DEL CENTRO---    
		    	
		    
		    
		    	
		    
		    	//---AÑADIR TODAS LAS COSAS---
		    JPanel posicionCentral = new JPanel();
		    posicionCentral.setOpaque(false); 
		    posicionCentral.setLayout(new GridLayout(4,1,1,1));	
		    
	//	    posicionCentral.add(posicionNombre);


 //--SETTINGS PARA QUE FUNCIONEN LOS ACCTIONLISTENERS---
		    
//---ADDS---
			//---TÍTULO---
		    posicionTitulo.add(titulo);
	  
			//---PANEL CENTRAL---
			    //Añadido arriba
			    
			//---PIE DE PÁGINA---
		    posicionPiePagina.add(piePagina);
		    		    
			//---IMAGENES---
		    imagenMapa.add(posicionCentral,BorderLayout.CENTER);   
		    imagenFondo.add(posicionCentral,BorderLayout.CENTER);   
		    imagenFondo.add(posicionTitulo,BorderLayout.NORTH);   
		    imagenFondo.add(imagenMapa, BorderLayout.CENTER);
		    imagenFondo.add(posicionPiePagina,BorderLayout.SOUTH); 
		    
			//--CONTENTPANE--
			contentPane.add(imagenFondo, BorderLayout.CENTER);
		    
//---SE VE---	    
	    jFrame.setVisible(true);  
	}
	
}
