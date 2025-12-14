package battleRoyale_v1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PersonajeActionPerformed {

//---VARIABLES---
		private static JFrame menu_Ventana;
		private String armaSeleccionada;
		private String razaSeleccionada;
		private JTextField nombrePersonaje;
		
		class ArmaJRBListener implements ActionListener {
			@Override
			 public void actionPerformed(ActionEvent e) {
			     JRadioButton arma = (JRadioButton) e.getSource();
			     
			     armaSeleccionada = arma.getText(); // o radio.getActionCommand()
			     
			     System.out.println("ARMA SELECCIONADA: " + armaSeleccionada);
			   }
			
			 }
			
		class RazaJRBListener implements ActionListener {			
			@Override
			 public void actionPerformed(ActionEvent e) {
			     JRadioButton raza = (JRadioButton) e.getSource();
			     
			     razaSeleccionada = raza.getText(); // o radio.getActionCommand()
			     
			     System.out.println("RAZA SELECCIONADA: " + razaSeleccionada);
			   }
			 }
		
		class BotonNextListener implements ActionListener {
						
			 public BotonNextListener(JTextField nombrePartida) {
				 nombrePersonaje = nombrePartida;
			    } 
			
			public void actionPerformed(ActionEvent e) {
		    	 //@Override
		    	CerrarVentanaListener();
		    }
		    
		    private void CerrarVentanaListener() {	   
		    	int tamAlto = SettingsActionPerformed.getAlto();
		    	int tamAncho = SettingsActionPerformed.getAncho();
		        
		        System.out.println("EL NOMBRE DEL PERSONAJE ES: " + getNombrePJ());
		        
		        if(getRaza()==null) {
		        	razaSeleccionada="Caballero";
		        }
		        if(getArma()==null) {
		        	armaSeleccionada="Espada";
		        }
		        
		       System.out.println("RAZA SELECCIONADA: " + getRaza());
		        System.out.println("ARMA SELECCIONADA: " + getArma());
		        
		    	MapJuego_BR.mapJuego_BR(tamAlto,tamAncho);  			 // Abrir la ventana de mapa 

		    	menu_Ventana = getNombreVentana();
		    
		    	menu_Ventana.dispose();   // Cerrar la ventana settings
		    	System.out.println("Se ha cerrado la ventana de Menú_BR");
		    }		    
		}

//---FUNCIONES---
	//---SETTERS Y GETTERS---
			//Sacar el valor del JFrame actual
			public void setNombreVentana(JFrame menu_Ventana) {
				this.menu_Ventana = menu_Ventana;  
			}
			public JFrame getNombreVentana() {
				return this.menu_Ventana;
			}	
			
			public String getNombrePJ() {
				return nombrePersonaje.getText();
			}
			public String getArma() {
		  		return armaSeleccionada;
		  	}
			 public String getRaza() {
			  	return razaSeleccionada;
			  }

}
