package battleRoyale_v1;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Settings {
	public void settingsInicio() {	
	//---INICIALIZAR JFRAME---
			JFrame jFrame = new JFrame("RoyalBattle_Settings");
			SettingsActionPerformed inicializandoSettings = new SettingsActionPerformed();
			inicializandoSettings.setNombreVentana(jFrame);

			
	//---VARIABLES---		
			int alto = 500, ancho= 500;
			//---FONT--- 
			//La fuente que voy a usar, sitiene algún tipo especial y el tamaño
			Font fuenteTitulo=new Font("Times New Roman", Font.BOLD, 35); 
			Font fuenteSubtitulo=new Font("Times New Roman", Font.PLAIN, 20); 
			Font fuenteTexto=new Font("Times New Roman", Font.BOLD, 15); 
			Font fuentepiePagina=new Font("Times New Roman", Font.ITALIC, 10); 

			
	//---JFRAME---		
		    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    jFrame.setSize(alto, ancho);  //Tamaño de la ventana
		    jFrame.setResizable(false); //Para que en esta pantalla no pueda agrandar la pantalla -> Queda más aestethic aka parecido a un programa antes de inicializar
		    jFrame.setLocationRelativeTo(null); //Cerrar proceso al cerrar la ventana
		    
	//---CREACIÓN DE LAS OPCIONES DE CONFIGURACIÓN---  
		    //---TÍTULO---
		    JLabel titulo = new JLabel(); 
		    titulo.setText("SETTINGS ROYALBATTLE");
		    titulo.setFont(fuenteTitulo);
		    titulo.setHorizontalAlignment(SwingConstants.CENTER);//Para que se quede en el centro de la pantalla
		    //---SUBTÍTULOS---
		    JLabel subtitulo = new JLabel(); 
		    subtitulo.setText("Seleccione el tamaño de la pantalla de juego");
		    subtitulo.setFont(fuenteSubtitulo);
		    subtitulo.setHorizontalAlignment(SwingConstants.CENTER);
		    //---TEXTO---
		    JLabel texto1 = new JLabel(); 
		    texto1.setText("Ancho");
		    texto1.setFont(fuenteTexto); 
		    
		    JLabel texto2 = new JLabel();
		    texto2.setText("Alto");
		    texto2.setFont(fuenteTexto);
		    	//---TEXTO BOTÓN---
		    JLabel textoButton = new JLabel();
		    textoButton.setText("<html><br>Pulsa el bottón para comenzar con el juego</html>");
		    textoButton.setFont(fuenteTexto);
		    textoButton.setHorizontalAlignment(SwingConstants.CENTER);
		   
		    //---PIE DE PÁGINA---
		    JLabel piePagina = new JLabel();
		    piePagina.setText("<html><br>Trabajo creado por:<br>Carlos Bravo, Lara Fernandez, Alonnso López, Cecilia Muñoz, Adriana Remiro</html>");
		    piePagina.setFont(fuentepiePagina);
		    
		    //---ANCHO---
	        String[] listaOpcionesAncho = {"800","1024","1920"}; //Opciones para el usuario sobre el tamaño
		    JComboBox tamVentanaAncho = new JComboBox(listaOpcionesAncho);//El boxplot de las opciones
		    tamVentanaAncho.setEditable(false); //Para que el usuario no lo pueda tocar
		    tamVentanaAncho.setSelectedIndex(0);//Para que tengo un default
		    tamVentanaAncho.setAlignmentX(Component.LEFT_ALIGNMENT);//Para que salga a la izquierda
		    tamVentanaAncho.setSize(1,1);

		   //---ALTO---
		    String[] listaOpcionesAlto= {"600","768","1080"}; //Opciones para el usuario sobre el tamaño
		    JComboBox tamVentanaAlto = new JComboBox(listaOpcionesAlto);//El boxplot de las opciones
		    tamVentanaAlto.setEditable(false); //Para que el usuario no lo pueda tocar
		    tamVentanaAlto.setSelectedIndex(0);//Para que tengo un default
		    tamVentanaAlto.setAlignmentX(Component.LEFT_ALIGNMENT);//Para que salga a la izquierda	    
		    tamVentanaAlto.setSize(1,1);
		    
		    //Para el settings
		    
	//---BOTÓN DE SIGUIENTE PASO---
		    JButton buttonNext = new JButton("Confirmar");
		    //Para que salga de un tamaño pequeño 
		    buttonNext.setPreferredSize(new Dimension(120,60));

// ---CONTAINERS Y JPANELS---	   
		    //---CONTENEDOR GENERAL---
		    Container contentPane = jFrame.getContentPane(); 
	        contentPane.setLayout(new BorderLayout()); 
	        ((JComponent) contentPane).setBorder(new EmptyBorder(20,15,5,15));//Para ponerle margen alrededor (Arriba, derecha, abajo, izquierda)
	        
	//---PANELBOXS---
	  //---ATECNCIÓN TIENE AQUÍ LOS ADDS PORQUE NO SE PORQUE SI NO ME LOS PONE MAL---
		    JPanel panelBox = new JPanel();
		    
		    panelBox.setLayout(new GridBagLayout());
		   /* Lo que tenía antes de encontrar  GridBagConstraints (guardado en caso de fallo)
		    panelBox.setLayout(new GridLayout(2,2,5,1));
		    panelBox.setBorder(new EmptyBorder(-100,-0,1,0));*/
		    
		    GridBagConstraints textoAncho = new GridBagConstraints();
		    textoAncho.gridx = 0; // columna
		    textoAncho.gridy = 0; //fila 
		    textoAncho.insets = new Insets(0, 0, 20, 20); // margen (arriba,izquierda,abajo,derecha)
		    panelBox.add(texto1, textoAncho);
		    
		    GridBagConstraints boxAncho = new GridBagConstraints();
		    boxAncho.gridx = 1; // columna
		    boxAncho.gridy = 0; //fila 
		    boxAncho.insets = new Insets(0, 0, 20, 20); // margen
		    panelBox.add(tamVentanaAncho, boxAncho);
		    
		    GridBagConstraints textoAlto = new GridBagConstraints();
		    boxAncho.gridx = 0; // columna
		    boxAncho.gridy = 1; //fila 
		    boxAncho.insets = new Insets(-120, 0, 20, 20); // margen
		    panelBox.add(texto2, boxAncho);

		    
		    GridBagConstraints boxAlto = new GridBagConstraints();
		    boxAncho.gridx = 1; // columna
		    boxAncho.gridy = 1; //fila 
		    boxAncho.insets = new Insets(-120, 0, 20, 20); // margen
		    panelBox.add(tamVentanaAlto, boxAncho);
		    
		    //---SOBRE TEXTOS---
		    JPanel tituloSubtitulo = new JPanel();
		    tituloSubtitulo.setLayout(new GridLayout(2,1,1,1));	    
		   
		    JPanel posicionPiePagina = new JPanel();
		    posicionPiePagina.setLayout(new GridLayout(2,1,1,1));	    

		    //---BOTTONES---
		    JPanel panelBotones = new JPanel();
		    panelBotones.setLayout(new FlowLayout());	//Para que no salga el padre de todos los botones
		    	//---TEXTO y BOTTON---
		    JPanel bottonYTexto = new JPanel();
		    bottonYTexto.setLayout( new GridLayout(2,2,5,5));	
		    
		    //---COSITAS EN EL CENTRO---
		    	//Botton + panelBox
		    JPanel panelCentral = new JPanel();
		    panelCentral.setLayout(new GridLayout(2,1,5,5));	

	//--SETTINGS PARA QUE FUNCIONEN LOS ACCTIONLISTENERS---
		 //---BOTTON NEXT---
		    SettingsActionPerformed settingsBottonNext = new SettingsActionPerformed(); //Como es una clase en una clase tengo primero que crear la clase principal
		    SettingsActionPerformed.BotonNextListener listenerBN = settingsBottonNext.new BotonNextListener();
		    buttonNext.addActionListener(listenerBN);
		 //---COMBOBOX---
		    //ANCHO
		    SettingsActionPerformed settingsAncho = new SettingsActionPerformed(); //Como es una clase en una clase tengo primero que crear la clase principal
		    SettingsActionPerformed.BoxAnchoListener listenerAN = settingsAncho.new BoxAnchoListener();
		    tamVentanaAncho.addActionListener(listenerAN);
		    
		    //ALTO
		    SettingsActionPerformed settingsAlto = new SettingsActionPerformed(); //Como es una clase en una clase tengo primero que crear la clase principal
		    SettingsActionPerformed.BoxAltoListener listenerAL = settingsAlto.new BoxAltoListener();
		    tamVentanaAlto.addActionListener(listenerAL);
		    
		    //---AVISITO---
		    JOptionPane.showMessageDialog(null,"Se recomienda no editar el ancho de pantalla para una mejor experiencia"); 
		    
	//---ADDS---
		    //---TÍTULO Y SUBTÍTULO---
		    tituloSubtitulo.add(titulo);
		    tituloSubtitulo.add(subtitulo);
		    //---PIE DE PÁGINA---

		    posicionPiePagina.add(piePagina);

		    //---PANELBOXS---
		    //Se encuentran en CONTAINERS Y JPANELS -> PANELBOXS
		    
		    //---BOTONES---
		    panelBotones.add(buttonNext,BorderLayout.CENTER);
		    
		    //---BOTONES Y TEXTO---
		    bottonYTexto.add(textoButton,BorderLayout.CENTER);
		    bottonYTexto.add(panelBotones,BorderLayout.SOUTH);
		    
		    //---PANEL CENTRAL---
		    panelCentral.add(panelBox, BorderLayout.CENTER);
		    panelCentral.add(bottonYTexto, BorderLayout.SOUTH);
		    
		    //--CONTENTPANE--
		    contentPane.add(tituloSubtitulo, BorderLayout.NORTH);
		    contentPane.add(panelCentral, BorderLayout.CENTER);
		    contentPane.add(posicionPiePagina,BorderLayout.SOUTH);
		    

		    
	//---SE VE---	    
		    jFrame.setVisible(true);       
		}
}
