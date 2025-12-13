package battleRoyale_v1;

import java.util.ArrayList;

public class Tablero {

	private final int ladoTablero; //Ponemos esto en mayúculas porque es una constantte??? LARA, CECILIA, ADRIANA, CARLOS
	private ArrayList<Personaje> jugadores; //para que tenemos el arrayList de jugadores aqui? 
	Casilla[][] casillas;
	
	public Tablero(ArrayList<Personaje> jugadores) {
		this.jugadores = jugadores;
		this.ladoTablero = 11; //de momento es el valor default, luego si eso hacemos que se pueda elegir
		this.casillas = new Casilla[this.ladoTablero][this.ladoTablero];
		for(int i=0; i<this.ladoTablero; i++) {
			for(int j=0; j<this.ladoTablero; j++) {
				casillas[i][j] = new Casilla(i, j);
			}
		}
	}
	
	public void mostrarTablero() {
		for(int i=0; i<this.ladoTablero; i++) {
			for(int j=0; j<this.ladoTablero; j++) {
				System.out.print("[ ]");
			}
			System.out.println();
		}
	}
	
	public void checkCharactersPosition() {
		for(int i=0; i < jugadores.size(); i++) {
			int[] posicionJugador = jugadores.get(i).getPosicion();
			
			//Separamos las coordenadas
			int x = posicionJugador[0];
	        int y = posicionJugador[1];
	        
			Casilla casilla = casillas[x][y];
			casilla.setIsOccupied(true);
			casilla.setJugador(jugadores.get(i));
		}
	}
	
	public int getLongitudTablero() {
		return this.ladoTablero;
	}
}
