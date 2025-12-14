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
		int fila = 11;
		int columna = 11;
		//---FONT--- 
			//La fuente que voy a usar, sitiene algún tipo especial y el tamaño
				Font fuenteTexto=new Font("Times New Roman", Font.BOLD, 15); 

//---INICIALIZAR JFRAME---
			JFrame jFrame = new JFrame("RoyalBattle_MapaJuego");

			//---JFRAME---				
		    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    jFrame.setSize(alto, ancho);  //Tamaño de la ventana
		    jFrame.setResizable(false); //Para que en esta pantalla no pueda agrandar la pantalla -> Queda más aestethic aka parecido a un programa antes de inicializar
		    jFrame.setLocationRelativeTo(null); //Cerrar proceso al cerrar la ventana

//---IMAGEN FONDO---
		    Imagenfondo imagenFondo = new Imagenfondo("mesa.jpeg");
			imagenFondo.setLayout(new BorderLayout());
			imagenFondo.setBorder(new EmptyBorder(20,15,5,15));//Para ponerle margen alrededor (Arriba, derecha, abajo, izquierda)		
//---IMAGEN MAPA---
		    Imagenfondo imagenMapa = new Imagenfondo("mapa.jpg");
		    imagenMapa.setLayout(new BorderLayout());
			//imagenFondo.setBorder(new EmptyBorder(20,15,5,15));//Para ponerle margen alrededor (Arriba, derecha, abajo, izquierda)		  

		    
// ---CONTAINERS Y JPANELS---	   	    
		    //---CONTENEDOR GENERAL---
		    Container contentPane = jFrame.getContentPane(); 
	        contentPane.setLayout(new BorderLayout());  
	        //--POSICIÓN MAPA---
	        JPanel tablero = new JPanel();
	        tablero.setOpaque(false); 
	        tablero.setLayout(new GridLayout(fila,columna,5,5));	

	        	//TABLERO


	        //---POSICIÓN TEXTP---
	        JPanel posicionTexto = new JPanel();
	        posicionTexto.setOpaque(false); 
	        posicionTexto.setLayout(new GridLayout(2,1,0,0));	
	        
	        //---POSICIÓN BOTÓN---
	        JPanel buttonNextposicion = new JPanel(new GridBagLayout());
		    buttonNextposicion.setOpaque(false); 
	        
//---CREACIÓN DE LAS INTERFAZ DE CREACIÓN DE PERSONAJE ---	
		  //---TEXTO---
			  JLabel texto = new JLabel(); 
			  texto.setText( "<html>Wow cuanto texto<br> Si efectivamente aquí va a ir todo lo del juego<br> me veo guapa señor cangrejo<br> uwuwuwuwwu<br> cositas<br> no se cuanto podrán escribir<br> OWO</html>");
			  texto.setFont(fuenteTexto);
			  texto.setHorizontalAlignment(SwingConstants.CENTER);//Para que se quede en el centro de la pantalla
			  texto.setForeground(Color.white);
			  
			//---BOTÓN NEXT---
		        JButton buttonNext = new JButton("SIGUIENTE TURNO");
			  
			 //---TABLERO/MAPA---
			  JLabel[][] casillas = new JLabel[fila][columna];
				
			  for (int i = 0; i < fila; i++) {
				  for (int j = 0; j < columna; j++) {
					  casillas[i][j] = new JLabel();
					  casillas[i][j].setOpaque(true); 
					  casillas[i][j].setBackground(new Color(0, 0, 0, 0)); //ES transparente más adelante puedo hacer que se vea de color rojo para que se vea que se ha eliminado
					  casillas[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
					  casillas[i][j].setText(" ");
					  tablero.add(casillas[i][j]);	//Van entrando por orden
				    }
				}    
			  //---BOTTON NEXT---
			  MapaActionPerformed mapPerActionPerformed = new MapaActionPerformed();
			    //Guarda la info del nombre dentro
			  MapaActionPerformed.BotonNextListener listenerBN = mapPerActionPerformed.new BotonNextListener();
			    buttonNext.addActionListener(listenerBN);

 //--SETTINGS PARA QUE FUNCIONEN LOS ACCTIONLISTENERS---
		    
//---ADDS---
			  //---TEXTO---
		        posicionTexto.add(texto,  BorderLayout.CENTER);
				//---BOTÓN---
			    buttonNextposicion.add(buttonNext);
			    posicionTexto.add(buttonNextposicion,BorderLayout.SOUTH);
			//---IMAGENES---
			    imagenMapa.add(tablero);   
			    
			    imagenFondo.add(posicionTexto,BorderLayout.SOUTH); 
		    imagenFondo.add(imagenMapa, BorderLayout.CENTER);
		    
			//--CONTENTPANE--
			contentPane.add(imagenFondo, BorderLayout.CENTER);
		    
//---SE VE---	    
	    jFrame.setVisible(true);  
	}
	
}
