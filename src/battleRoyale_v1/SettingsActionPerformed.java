package battleRoyale_v1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class SettingsActionPerformed implements ActionListener {

//---VARIABLES---
	private static String patronAlto;
	private static String patronAncho;	
	private static JFrame settingsVentana;
	private static int tamAncho;
	private static int tamAlto; 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 
	}
	
//---CLASES INTERNAS PARA LOS ACTIONLISTENERS---
	
	//Para guardar el tamaño que quiere de alto el usuario
	class BoxAltoListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	 //@Override
	    	JComboBox cbAN = (JComboBox)e.getSource(); //Toma toda la info de JComboBox
			String newSelection = (String)cbAN.getSelectedItem(); //Selecciona lo que haya elegido el jugador
			patronAncho = newSelection;
	        tamAncho = Integer.parseInt(patronAncho);
	    	System.out.println("HAS ELEGIDO: " +patronAncho+" ANCHO");
	    }
	}
	 // Para guardar el tamaño que quiere de ancho el usuario	
	class BoxAnchoListener implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	 //@Override
	    	JComboBox cbAL = (JComboBox)e.getSource(); //Toma toda la info de JComboBox
			String newSelection = (String)cbAL.getSelectedItem(); //Selecciona lo que haya elegido el jugador
			patronAlto = newSelection;
			tamAlto = Integer.parseInt(patronAlto);
	    	System.out.println("HAS ELEGIDO: " +patronAlto+ " ALTO" );
	    }
	}
	
	//Lo que se supone que va a hacer es que al hacerle click va a ir al siguiente JFrame
	class BotonNextListener implements ActionListener {
	
		public void actionPerformed(ActionEvent e) {
	    	 //@Override
	    	CerrarVentanaListener();
	    }
	    
	    private void CerrarVentanaListener() {	    	
	    	 if (patronAlto == null) {
	                tamAlto = 600;
	            }
	    	 if (patronAncho == null) {
	                tamAncho = 800;
	            }
	    	Menu_BR.Menu_BR(tamAlto,tamAncho);  			 // Abrir la ventana de menú
	    	
	    	
	    	settingsVentana = getNombreVentana();
	    	settingsVentana.dispose();   // Cerrar la ventana settings
	    	System.out.println("Se ha cerrado la ventana de settings");
	    }
	}
//---FUNCIONES---	
	//---SETTERS Y GETTERS---
		//Sacar el valor del JFrame actual
	public void setNombreVentana(JFrame settingsVentana) {
		this.settingsVentana = settingsVentana;  
	}
	public JFrame getNombreVentana() {
		return this.settingsVentana;
	}
	
		//Sacar el ancho que ha decidido el usuario
	public static int getAncho() {
		return tamAncho;
	}
	
		//Sacar el alto que ha decidido el usuario
	public static int getAlto() {
		return tamAlto;
	}
}
