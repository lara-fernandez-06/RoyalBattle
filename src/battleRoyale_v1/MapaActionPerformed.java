
	package battleRoyale_v1;

	import java.awt.Color;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	import javax.swing.JButton;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JTextField;

	public class MapaActionPerformed {

		public void CasillaEliminada(int fila, int columna,JLabel[][] casillas) {
			
	        casillas[fila][columna].setBackground(new Color(158, 27, 17, 100)); 
	    }
		
		
		class BotonNextListener implements ActionListener {
			
			public void actionPerformed(ActionEvent e) {
		    	 //@Override
				System.out.println("NEXT");
		    
		    }    
		}
			
		/*class TextoActualizado implements ActionListener{
			public void actionPerformed(ActionEvent e) {	

						resultado = resultado + botton.getText();		
						operacion.setText(resultado);
						
						if (resultado.charAt(resultado.length() - 1) >= '9' || resultado.charAt(resultado.length() - 1) <= '0')
						{
							guardarDatos(resultado);
						}
						
					
				}
			}
			}*/
			
	}
