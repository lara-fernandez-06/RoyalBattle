package battleRoyale_v1;

import java.util.ArrayList;

public class Tablero {

	private int ladoTablero;
	private ArrayList<Personaje> jugadores; //para que tenemos el arrayList de jugadores aqui? 
	Casilla[][] casillas = new Casilla[ladoTablero][ladoTablero];
	
	public Tablero(ArrayList<Personaje> jugadores) {
		this.jugadores = jugadores;
		this.ladoTablero = 25; //de momento es el valor default, luego si eso hacemos que se pueda elegir
		for(int i=0; i<this.ladoTablero; i++) {
			for(int j=0; j<this.ladoTablero; j++) {
				casillas[i][j] = new Casilla(i, j);
			}
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
