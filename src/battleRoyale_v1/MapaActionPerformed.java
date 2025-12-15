
	package battleRoyale_v1;

	import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import javax.swing.JLabel;
import javax.swing.SwingConstants;


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
		
				 CasillaEliminada(1, 1,casillas);
				 CasillaMoverse(2, 2,casillas);
				 ponerLoot(3,3,casillas);
				 
				Container tablero = casillas[0][0].getParent();
				tablero.revalidate();
				tablero.repaint();
				String resultado = "LOLOLOLLOLLOLOLOL ACTUALIZADOOO";//Esto será lo que tome de lo que pasa en la partida

				 
				texto.setText(resultado);

			}
			
			private void limpiarCasillas(JLabel[][] casillas) {

		        for (int i = 0; i < casillas.length; i++) {
		            for (int j = 0; j < casillas[i].length; j++) {
		                casillas[i][j].setBackground(new Color(0, 0, 0, 0));
		                casillas[i][j].setText(" ");
		            }
		          
		        }
		     }
			
			private void ponerLoot(int fila, int columna,JLabel[][] casillas) {
				casillas[fila][columna].setHorizontalAlignment(SwingConstants.CENTER);
				casillas[fila][columna].setText("*");
		     }
			
			public void CasillaEliminada(int fila, int columna,JLabel[][] casillas) {
				casillas[fila][columna].setBackground(new Color(158, 27, 17, 100)); 
		    }

			public void CasillaMoverse(int fila, int columna,JLabel[][] casillas) {
				int id=0;
				 char raza ='M';
				 casillas[fila][columna].setHorizontalAlignment(SwingConstants.CENTER);
				 casillas[fila][columna].setBackground(new Color(0, 0, 0, 100));
				 
				 if(id==0){
						switch(raza) {
						case 'M':
								casillas[fila][columna].setText("M");
							break;
						case 'O':
								casillas[fila][columna].setText("O");
							break;
						case 'E':
								casillas[fila][columna].setText("E");
							break;
						case 'L':
								casillas[fila][columna].setText("L");
							break;
						case 'C':
								casillas[fila][columna].setText("C");
							break;
					}
						casillas[fila][columna].setForeground(Color.WHITE);
				 }
				 else {

					switch(raza) {
						case 'M':
								casillas[fila][columna].setText("M");
								casillas[fila][columna].setForeground(new Color(204, 0, 255));
							break;
						case 'O':
								casillas[fila][columna].setText("O");
								casillas[fila][columna].setForeground(new Color(0, 255, 4));
								
							break;
						case 'E':
								casillas[fila][columna].setText("E");
								casillas[fila][columna].setForeground(new Color(234, 255, 0));
							break;
						case 'L':
								casillas[fila][columna].setText("L");
								casillas[fila][columna].setForeground(new Color(255, 0, 0));
							break;
						case 'C':
								casillas[fila][columna].setText("C");
								casillas[fila][columna].setForeground(new Color(21, 0, 255));
							break;
					}
				 }
		    }
			
		}
			
	}
