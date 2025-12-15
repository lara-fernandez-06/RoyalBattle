
	package battleRoyale_v1;

	import java.awt.Color;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.JLabel;


	public class MapaActionPerformed {
		
		class BotonNextListener implements ActionListener {
			
			private JLabel texto;
			private  JLabel[][] casillas;
			
			public BotonNextListener(JLabel texto, JLabel[][] casillas) {
				this.texto = texto;
				this.casillas = casillas;
			}

			public void actionPerformed(ActionEvent e) {
		    	 //@Override
				limpiarCasillas(casillas);
				System.out.println("NEXT");			
				String resultado = "LOLOLOLLOLLOLOLOL ACTUALIZADOOO";//Esto será lo que tome de lo que pasa en la partida
				 CasillaEliminada(1, 1,casillas);
				 CasillaMoverse(2, 2,casillas);
				 
				texto.setText(resultado);

			}
			
			private void limpiarCasillas(JLabel[][] casillas) {

		        for (int i = 0; i < casillas.length; i++) {
		            for (int j = 0; j < casillas[i].length; j++) {
		                casillas[i][j].setBackground(new Color(0, 0, 0, 0));
		            }
		          
		        }
		     }
			
			public void CasillaEliminada(int fila, int columna,JLabel[][] casillas) {
				
				casillas[fila][columna].setBackground(new Color(158, 27, 17, 100)); 
				
		    }

			public void CasillaMoverse(int fila, int columna,JLabel[][] casillas) {
				
				 char raza ='C';

				switch(raza) {
				
					case 'M':
							casillas[fila][columna].setText("\t M");
						break;
					case 'O':
							casillas[fila][columna].setText("\t O");
						break;
					case 'E':
							casillas[fila][columna].setText("\t E");
						break;
					case 'L':
							casillas[fila][columna].setText("\t L");
						break;
					case 'C':
							casillas[fila][columna].setText("\t C");
						break;
						
				
				}
				
				
				
		    }
			
		}
			
	}
