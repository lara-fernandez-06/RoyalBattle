package battleRoyale_v1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import battleRoyale_v1.SettingsActionPerformed.BotonNextListener;

public class Menu_BR {
	
	public static void Menu_BR(int alto, int ancho) {
System.out.println("HAS ABIERTO EL MENNNNNÚ");
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
		JFrame jFrame = new JFrame("RoyalBattle_Menú");
		MenuActionPerformed inicializandoMenu = new MenuActionPerformed();
		inicializandoMenu.setNombreVentana(jFrame);
//---JFRAME---		
		//TamInterfaz profile = tamSeleccionado;
		//frame.setSize(profile.width, profile.height);
		//label.setFont(new Font("SansSerif", Font.PLAIN, profile.fontSize));
		
	    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jFrame.setSize(alto, ancho);  //Tamaño de la ventana
	    jFrame.setResizable(false); //Para que en esta pantalla no pueda agrandar la pantalla -> Queda más aestethic aka parecido a un programa antes de inicializar
	    jFrame.setLocationRelativeTo(null); //Cerrar proceso al cerrar la ventana

//---IMAGEN FONDO---
	    Imagenfondo imagenFondo = new Imagenfondo("fondoImagen.jpg");
		imagenFondo.setLayout(new BorderLayout());
		imagenFondo.setBorder(new EmptyBorder(20,15,5,15));//Para ponerle margen alrededor (Arriba, derecha, abajo, izquierda)

//---CREACIÓN DE LAS INTERFAZ DE MENÚ---     
	    //---TÍTULO---
	    JLabel titulo = new JLabel(); 
	    titulo.setText("ROYALBATTLE THE GAME");
	    titulo.setFont(fuenteTitulo);
	    titulo.setHorizontalAlignment(SwingConstants.CENTER);//Para que se quede en el centro de la pantalla
	    titulo.setForeground(Color.white);	    
	    titulo.setBorder(BorderFactory.createLineBorder(new Color(29, 74, 41),5));
	    
	    //---TEXTO---
	    JLabel texto1 = new JLabel(); 
	    texto1.setText("<html><br>Escriba el nombre de la partida que desea cargar<br>En caso de no existir, se creará una nueva</html>");
	    texto1.setForeground(Color.white);
	    texto1.setHorizontalAlignment(SwingConstants.CENTER);//Para que se quede en el centro de la pantalla
	    texto1.setFont(fuenteTexto);
	    
	    JLabel texto2 = new JLabel(); 
	    texto2.setText("<html><br>Evite el uso de espacios, comas y caracteres extraños</html>");
	    texto2.setForeground(Color.red);
	    texto2.setHorizontalAlignment(SwingConstants.CENTER);//Para que se quede en el centro de la pantalla
	    texto2.setFont(fuenteTexto);
	    
	    //---PIE DE PÁGINA---
	    JLabel piePagina = new JLabel();
	    piePagina.setText("<html><br>Trabajo creado por:<br>Carlos Bravo, Lara Fernandez, Alonnso López, Cecilia Muñoz, Adriana Remiro</html>");
	    piePagina.setFont(fuentepiePagina);
	    piePagina.setForeground(Color.white);
	    
	    //---BOTÓN DE COMENZAR PARTIDA---
	    JButton buttonComenzar = new JButton("CREAR PERSONAJE");
	    //Para que salga de un tamaño pequeño 
	    buttonComenzar.setPreferredSize(new Dimension(200,60));
	    
	    
	    //---DONDE ESCRIBIR EL TEXTO---
	    JTextField nombrePartida = new JTextField(); 
	    nombrePartida.setPreferredSize(new Dimension(200,60));
	    
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
	    
	    //---COSASAS EN EL CENTRO---
		  //---ATECNCIÓN TIENE AQUÍ LOS ADDS PORQUE NO SE PORQUE SI NO ME LOS PONE MAL---
	    		
	    		JPanel posicionTexto1 = new JPanel();
	    		posicionTexto1.setOpaque(false); 
			    GridBagConstraints texto_1 = new GridBagConstraints();
			    texto_1.gridx = 0; // columna
			    texto_1.gridy = 0; //fila 
			    texto_1.insets = new Insets(0, 0, 20, 20); // margen (arriba,izquierda,abajo,derecha)
			    posicionTexto1.add(texto1, texto_1);
			    
			    JPanel posicionNombre = new JPanel();
			    posicionNombre.setOpaque(false); 
			    GridBagConstraints escribirfichero = new GridBagConstraints();
			    escribirfichero.gridx = 0; // columna
			    escribirfichero.gridy = 1; //fila 
			    escribirfichero.insets = new Insets(0, 0, 20, 20); // margen
			    posicionNombre.add(nombrePartida, escribirfichero);
			    
			    JPanel posicionBoton = new JPanel();
			    posicionBoton.setOpaque(false); 
			    GridBagConstraints comenzarBoton = new GridBagConstraints();
			    comenzarBoton.gridx = 0; // columna
			    comenzarBoton.gridy = 2; //fila 
			    comenzarBoton.insets = new Insets(0, 0, 20, 20); // margen
			    posicionBoton.add(buttonComenzar, comenzarBoton);
			     
			    JPanel posicionTexto2 = new JPanel();
			    posicionTexto2.setBackground( new Color(0, 0, 0, 100) );
			  //  posicionTexto2.setOpaque(false); 
			    GridBagConstraints texto_2 = new GridBagConstraints();
			    texto_2.gridx = 0; // columna
			    texto_2.gridy = 3; //fila 
			    texto_2.insets = new Insets(0, 0, 20, 20); // margen (arriba,izquierda,abajo,derecha)
			    posicionTexto2.add(texto2, texto_2);
			    
			    	//--TODAS LAS COSAS QUE VAN EN PANELCENTRAL---
			    JPanel panelCentral = new JPanel();	
			    panelCentral.setOpaque(false); 
			    panelCentral.setLayout(new GridLayout(4,1,1,1));  
			    
			    panelCentral.add(posicionTexto1);
			    panelCentral.add(posicionNombre);
			    panelCentral.add(posicionBoton);
			    panelCentral.add(posicionTexto2);
			    

//--SETTINGS PARA QUE FUNCIONEN LOS ACCTIONLISTENERS---
			    MenuActionPerformed menuActionPerformed = new MenuActionPerformed(); //Como es una clase en una clase tengo primero que crear la clase principal
			    //---BOTTON NEXT Y TOMAR EL JTEXTFIELD UNA VEZ SE PULSA EL BOTÓN---
				MenuActionPerformed.BotonNextListener listenerBN = menuActionPerformed.new BotonNextListener(nombrePartida);
				buttonComenzar.addActionListener(listenerBN);
//---ADDS---

	//---TÍTULO Y SUBTÍTULO---
		posicionTitulo.add(titulo);
	    
	//---PANEL CENTRAL---
	    //Añadido arriba
	    
	//---PIE DE PÁGINA---
	    posicionPiePagina.add(piePagina);
	    
	//---IMAGEN FONDO---
	    imagenFondo.add(posicionTitulo, BorderLayout.NORTH);
	    imagenFondo.add(panelCentral, BorderLayout.CENTER);
	    imagenFondo.add(posicionPiePagina, BorderLayout.SOUTH);
	    
	    //--CONTENTPANE--
	    contentPane.add(imagenFondo, BorderLayout.CENTER);
	    
 //---SE VE---	    
	    jFrame.setVisible(true);       
	}
}
