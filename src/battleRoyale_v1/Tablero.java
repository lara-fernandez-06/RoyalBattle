package battleRoyale_v1;

import java.util.ArrayList;

public class Tablero {

	private int ladoTablero;
	private ArrayList<Personaje> jugadores;
	Casilla[][] casillas = new Casilla[ladoTablero][ladoTablero];
	
	public Tablero(ArrayList jugadores) {
		this.jugadores = jugadores;
	}
	
	public void checkCharactersPosition() {
		for(int i=0; i < jugadores.size(); i++) {
			int[][] posicionJugador = jugadores.get(i).getPosicion();
			
			//Separamos las coordenadas
			int x = posicionJugador[0][0];
	        int y = posicionJugador[0][1];
	        
			Casilla casilla = casillas[x][y];
			casilla.setIsOccupied(true);
			casilla.setJugador(jugadores.get(i));
		}
	}
}
