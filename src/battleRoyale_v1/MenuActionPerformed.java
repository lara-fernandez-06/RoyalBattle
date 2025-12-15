package battleRoyale_v1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class MenuActionPerformed {

//---VARIABLES---
	
	private static JFrame menu_Ventana;
	private static JTextField nombreFichero;
	
//---CLASES INTERNAS PARA LOS ACTIONLISTENERS---
	//Para que el usuario ponga el nombre del fichero que tiene los datos guardados
	//Si no existe, crea una nueva con ese nombre
	//ESTO SOLO FUNCIONA SI SE LE DA AL ENTER 
	/*class NombreFichero implements ActionListener {
	    public void actionPerformed(ActionEvent e) {
	    	
	        JTextField nombre = (JTextField) e.getSource();
	        nombreFichero = nombre.getText();
	        System.out.println("El nombre del fichero es: " + nombreFichero);
	        
	    }
	}*/
	
	//Lo que se supone que va a hacer es que al hacerle click va a ir al siguiente JFrame
	class BotonNextListener implements ActionListener {
		
	    public BotonNextListener(JTextField nombrePartida) {
	        nombreFichero = nombrePartida;
	    } 
	    
		public void actionPerformed(ActionEvent e) {
	    	 //@Override
	    	CerrarVentanaListener();
	    }
	    
	    private void CerrarVentanaListener() {	   
	    
	    
	    	int tamAlto = SettingsActionPerformed.getAlto();
	    	int tamAncho = SettingsActionPerformed.getAncho();
	    	
	    	System.out.println("NOMBRE DEL FICHERO: " + getnombreFichero());
	    		    	
	    	CreacionPersonaje_BR.CreacionPersonaje_BR(tamAlto,tamAncho);  			 // Abrir la ventana de menú
	    	
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
		public static String getnombreFichero() {
			return nombreFichero.getText();
		}
}
