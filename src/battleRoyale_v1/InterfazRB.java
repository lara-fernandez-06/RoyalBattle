package battleRoyale_v1;

import javax.swing.JFrame;

public class InterfazRB {

	
	public static void inicializarInterfaz() {	
		JFrame jFrame = new JFrame("RoyalBattle");
		
		int alto = 500, ancho= 500;
		
		
	    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jFrame.setSize(alto, ancho);  //Tamaño de la ventana
	    jFrame.setLocationRelativeTo(null); //Cerrar proceso al cerrar la ventana
	    
	    
	    
	    
	    jFrame.setVisible(true);       
	}
	
	
}
