package battleRoyale_v1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;

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

public class CreacionPersonaje_BR {

	public static void CreacionPersonaje_BR(int alto, int ancho) {
		System.out.println("HAS ABIERTO EL CREADOR DE PERSONAJES");
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
			JFrame jFrame = new JFrame("RoyalBattle_CreacionPersonaje");
			PersonajeActionPerformed inicializandoPersonaje = new PersonajeActionPerformed();
			inicializandoPersonaje.setNombreVentana(jFrame);
			//---JFRAME---		
			
		    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    jFrame.setSize(alto, ancho);  //Tamaño de la ventana
		    jFrame.setResizable(false); //Para que en esta pantalla no pueda agrandar la pantalla -> Queda más aestethic aka parecido a un programa antes de inicializar
		    jFrame.setLocationRelativeTo(null); //Cerrar proceso al cerrar la ventana

//---IMAGEN FONDO---
		    Imagenfondo imagenFondo = new Imagenfondo("fondo2.png");
			imagenFondo.setLayout(new BorderLayout());
			imagenFondo.setBorder(new EmptyBorder(20,15,5,15));//Para ponerle margen alrededor (Arriba, derecha, abajo, izquierda)		    
		    
//---CREACIÓN DE LAS INTERFAZ DE CREACIÓN DE PERSONAJE ---	
			 //---TÍTULO---
		    JLabel titulo = new JLabel(); 
		    titulo.setText("CREACIÓN DE PERSONAJE");
		    titulo.setFont(fuenteTitulo);
		    titulo.setHorizontalAlignment(SwingConstants.CENTER);//Para que se quede en el centro de la pantalla
		    titulo.setForeground(Color.white);
		    titulo.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		    
		    //---SUBTÍTULO---
		    JLabel subtitulo = new JLabel(); 
		    subtitulo.setText("No olvide completar todos los campos con (*)");
		    subtitulo.setFont(fuenteSubtitulo);
		    subtitulo.setHorizontalAlignment(SwingConstants.CENTER);//Para que se quede en el centro de la pantalla
		    subtitulo.setForeground(Color.white);
		    
		    //---TÍTULO---
		    JLabel texto1 = new JLabel(); 
		    texto1.setText("Nombre del personaje:");
		    texto1.setFont(fuenteTexto);
		    texto1.setHorizontalAlignment(SwingConstants.CENTER);//Para que se quede en el centro de la pantalla
		    texto1.setForeground(Color.white);
		    
		    JLabel texto2 = new JLabel(); 
		    texto2.setText("(*)Raza del personaje:");
		    texto2.setFont(fuenteTexto);
		    texto2.setHorizontalAlignment(SwingConstants.CENTER);//Para que se quede en el centro de la pantalla
		    texto2.setForeground(Color.white);
		    
		    JLabel texto3 = new JLabel(); 
		    texto3.setText("(*)Arma del personaje:");
		    texto3.setFont(fuenteTexto);
		    texto3.setHorizontalAlignment(SwingConstants.CENTER);//Para que se quede en el centro de la pantalla
		    texto3.setForeground(Color.white);
		    
		    //---PIE DE PÁGINA---
		    JLabel piePagina = new JLabel();
		    piePagina.setText("<html><br>Trabajo creado por:<br>Carlos Bravo, Lara Fernandez, Alonnso López, Cecilia Muñoz, Adriana Remiro</html>");
		    piePagina.setFont(fuentepiePagina);
		    piePagina.setForeground(Color.white);
		    
		    //--RADIO BUTTON---
		    ButtonGroup GroupRazas = new ButtonGroup();

		        JRadioButton c  = new JRadioButton("Caballero"); 
		        GroupRazas.add(c);
		        JRadioButton m  = new JRadioButton("Mago");  
		        GroupRazas.add(m);
		        JRadioButton o  = new JRadioButton("Orco"); 
		        GroupRazas.add(o);
		        JRadioButton e = new JRadioButton("Elfo"); 
		        GroupRazas.add(e);
		        JRadioButton l  = new JRadioButton("Ladron"); 
		        GroupRazas.add(l);
		        
		    ButtonGroup GroupArmas = new ButtonGroup();

		        JRadioButton maz  = new JRadioButton("Maza"); 
		        GroupArmas.add(maz);
		        JRadioButton esp  = new JRadioButton("Espada");  
		        GroupArmas.add(esp);
		        JRadioButton bac  = new JRadioButton("Baculo"); 
		        GroupArmas.add(bac);
		        JRadioButton arc = new JRadioButton("Arco"); 
		        GroupArmas.add(arc);
		        JRadioButton dag  = new JRadioButton("Daga"); 
		        GroupArmas.add(dag);
		    
		    //---DONDE ESCRIBIR EL TEXTO---
			    JTextField nombrePersonaje = new JTextField(20);  // Tamaño visible del campo

		   //---BOTÓN NEXT---
		        JButton buttonNext = new JButton("COMENZAR LA PARTIDA");
		    
// ---CONTAINERS Y JPANELS---	   	    
		    //---CONTENEDOR GENERAL---
		    Container contentPane = jFrame.getContentPane(); 
	        contentPane.setLayout(new BorderLayout());  
	        
		    //---SOBRE TEXTOS---		
	        JPanel posicionTitulo_Subtitulo = new JPanel();
	        posicionTitulo_Subtitulo.setOpaque(false); // Transparente para que se vea la imagen
	        posicionTitulo_Subtitulo.setLayout(new GridLayout(2,1,1,1));	
	        
	        JPanel posicionPiePagina = new JPanel();
		    posicionPiePagina.setOpaque(false); 
		    posicionPiePagina.setLayout(new GridLayout(2,1,1,1));	
		    
		    //---COSITAS DEL CENTRO---    
		    
			//---JTEXT FIELD---
		    JPanel posicionNombre = new JPanel(new GridBagLayout());
		    posicionNombre.setOpaque(false); 
		    GridBagConstraints ps = new GridBagConstraints();
		    nombrePersonaje.setPreferredSize(new Dimension(180, 30));
		    ps.gridx = 0;
		    ps.gridy = 0;
		    posicionNombre.add(texto1);
		    ps.gridx = 0;
		    ps.gridy = 20;
		    ps.fill = GridBagConstraints.NONE; // No rellenar
		    posicionNombre.add(nombrePersonaje, ps);
		    
		    	//---RAZAS---
		    JPanel posicionRazaGeneral = new JPanel();
		    posicionRazaGeneral.setOpaque(false); 
		    posicionRazaGeneral.setLayout(new GridLayout(2,1,1,1));	
		    
		    posicionRazaGeneral.add(texto2);
		    
		    JPanel posicionRazaRB = new JPanel();
		    posicionRazaRB.setOpaque(false); 
		    posicionRazaRB.setLayout(new GridLayout(3,2,1,1));	
		    posicionRazaRB.add(c);
		    posicionRazaRB.add(m);
		    posicionRazaRB.add(o);
		    posicionRazaRB.add(l);
		    posicionRazaRB.add(e);
		    
		    posicionRazaGeneral.add(posicionRazaRB);
		    
		    	//---ARMAS---
		    JPanel posicionArmaGeneral = new JPanel();
		    posicionArmaGeneral.setOpaque(false); 
		    posicionArmaGeneral.setLayout(new GridLayout(2,1,1,1));	
		    
		    posicionArmaGeneral.add(texto3);
		    
		    JPanel posicionArmaRB = new JPanel();
		    posicionArmaRB.setOpaque(false); 
		    posicionArmaRB.setLayout(new GridLayout(3,2,1,1));	
		    posicionArmaRB.add(esp);
		    posicionArmaRB.add(bac);
		    posicionArmaRB.add(maz);
		    posicionArmaRB.add(dag);
		    posicionArmaRB.add(arc);
		    
		    posicionArmaGeneral.add(posicionArmaRB);
		 		//---BOTÓN NEXT---
		    JPanel buttonNextposicion = new JPanel(new GridBagLayout());
		    buttonNextposicion.setOpaque(false); 
		    ps.gridx = 0;
		    ps.gridy = 0;
		    buttonNextposicion.add(buttonNext);
		    
		    	//---AÑADIR TODAS LAS COSAS---
		    JPanel posicionCentral = new JPanel();
		    posicionCentral.setOpaque(false); 
		    posicionCentral.setLayout(new GridLayout(4,1,1,1));	
		    
		    posicionCentral.add(posicionNombre);
		    posicionCentral.add(posicionRazaGeneral);
		    posicionCentral.add(posicionArmaGeneral);
		    posicionCentral.add(buttonNextposicion);

 //--SETTINGS PARA QUE FUNCIONEN LOS ACCTIONLISTENERS---
		    PersonajeActionPerformed crePerActionPerformed = new PersonajeActionPerformed(); //Como es una clase en una clase tengo primero que crear la clase principal
		 //---BOTTON NEXT---
		    //Guarda la info del nombre dentro
		    PersonajeActionPerformed.BotonNextListener listenerBN = crePerActionPerformed.new BotonNextListener(nombrePersonaje);
		    buttonNext.addActionListener(listenerBN);
		//---JRADIOBUTTON---
		    //Para que aparezcan ya como default
		    c.setSelected(true);
		    esp.setSelected(true);
		    //Para ver cual está seleccionado
		    PersonajeActionPerformed.ArmaJRBListener listenerAJL = crePerActionPerformed.new ArmaJRBListener();
		    esp.addActionListener(listenerAJL);
		    bac.addActionListener(listenerAJL);
		    maz.addActionListener(listenerAJL);
		    arc.addActionListener(listenerAJL);
		    dag.addActionListener(listenerAJL);
		    PersonajeActionPerformed.RazaJRBListener listenerRJL = crePerActionPerformed.new RazaJRBListener();
		    c.addActionListener(listenerRJL);
		    m.addActionListener(listenerRJL);
		    o.addActionListener(listenerRJL);
		    e.addActionListener(listenerRJL);
		    l.addActionListener(listenerRJL);
		    

		    
//---ADDS---

			//---TÍTULO Y SUBTÍTULO---
	        posicionTitulo_Subtitulo.add(titulo);
	        posicionTitulo_Subtitulo.add(subtitulo);
	        
			//---PANEL CENTRAL---
			    //Añadido arriba
			    
			//---PIE DE PÁGINA---
		    posicionPiePagina.add(piePagina);
		    		    
			//---IMAGEN FONDO---
		    imagenFondo.add(posicionTitulo_Subtitulo,BorderLayout.NORTH);   
		    imagenFondo.add(posicionCentral,BorderLayout.CENTER);   
		    imagenFondo.add(posicionPiePagina,BorderLayout.SOUTH);   
			//--CONTENTPANE--
			contentPane.add(imagenFondo, BorderLayout.CENTER);
		    
//---SE VE---	    
	    jFrame.setVisible(true);  
	}
}
