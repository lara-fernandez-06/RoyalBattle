package battleRoyale_v1;

import java.util.ArrayList;
import java.util.Random;

public class Tablero {

	private final int LADOTABLERO;
	//private ArrayList<Personaje> jugadores; //para que tenemos el arrayList de jugadores aqui? 
	Casilla[][] casillas;
	
	Random rd = new Random();
	
	public Tablero() {
		this.LADOTABLERO = 11;
		this.casillas = new Casilla[this.LADOTABLERO][this.LADOTABLERO];
		for(int i=0; i<this.LADOTABLERO; i++) {
			for(int j=0; j<this.LADOTABLERO; j++) {
				casillas[i][j] = new Casilla(i, j);
			}
		}
	}
	
	public void inicializarTablero(ArrayList<Personaje> jugadores) {
		
		//Colocar los 25 personajes en casillas random:
		for (Personaje p : jugadores) {
	        boolean colocado = false;
	        
	        while (colocado == false) {
	            int x = rd.nextInt(LADOTABLERO);
	            int y = rd.nextInt(LADOTABLERO);

	            Casilla c = casillas[x][y];

	            if (c.getPersonaje() == null) {
	                c.setPersonaje(p);
	                p.setPosicion(x, y);
	                colocado = true;
	            }
	        }
	        
		}
		
		//Colocar 10 objetos loot en casillas random (probabilidad de 1/5 cada uno):
		//Voy a hacer que en una misma casilla no puedan aparecer un personaje y un objeto a la vez
		for (int i = 0; i < 10; i++) {
	        boolean colocado = false;

	        while (colocado == false) {
	            int x = rd.nextInt(LADOTABLERO);
	            int y = rd.nextInt(LADOTABLERO);

	            Casilla c = casillas[x][y];

	            if (c.getLoot() == null && c.getPersonaje() == null) {
	                c.setLoot(generarLootRandom());
	                colocado = true;
	            }
	        }
		}
	}
	
	private Loot generarLootRandom() {
	    int tipo = rd.nextInt(5); // 0 a 4

	    switch (tipo) {
		    case 0: return new PocionVida("Poción de vida", TipoLoot.VIDA);
	        case 1: return new Lentes("Lentes graduadas", TipoLoot.VISION);
	        case 2: return new Yunke("Yunke portátil", TipoLoot.DMG);
	        case 3: return new Amuleto("Amuleto de alcance", TipoLoot.RANGO);
	        case 4: return new Botas("Botas de senderismo", TipoLoot.STAMINA);
	        default: return null;
	    }
	}
	
	public void mostrarTablero() {
		for (int i = 0; i < LADOTABLERO; i++) {
	        for (int j = 0; j < LADOTABLERO; j++) {
	            if (this.casillas[i][j].getPersonaje() != null){
	                System.out.print("[" + letraPersonaje(this.casillas[i][j]) + letraArma(this.casillas[i][j]) + "]");
	            } else if (this.casillas[i][j].getLoot() != null) {
	            	System.out.print("[L]");
	            } else {
	            	System.out.print("[ ]");
	            }
	        }
	        
	        System.out.println();
	    }
	}
	
	public char letraPersonaje(Casilla casilla) {
		Rol rol = casilla.getPersonaje().getRol();
		if(rol == Rol.CABALLERO) {
			return 'C';
		}else if(rol == Rol.OGRO) {
			return 'O';
		}else if(rol == Rol.ELFO) {
			return 'E';
		}else if(rol == Rol.MAGO) {
			return 'M';
		}else if(rol == Rol.LADRON) {
			return 'L';
		}else {
			return 'e';
		}
	}
	
	public char letraArma(Casilla casilla) {
		TipoArma tipoArma = casilla.getPersonaje().getArma().getTipoArma();
		if(tipoArma == TipoArma.ESPADA) {
			return 'E';
		}else if(tipoArma == TipoArma.MAZA) {
			return 'M';
		}else if(tipoArma == TipoArma.ARCO) {
			return 'A';
		}else if(tipoArma == TipoArma.BACULO) {
			return 'B';
		}else if(tipoArma == TipoArma.DAGA) {
			return 'D';
		}else {
			return 'e';
		}
	}
	
	public void checkCharactersPosition(ArrayList<Personaje> jugadores) {
		for(int i=0; i < jugadores.size(); i++) {
			int[] posicionJugador = jugadores.get(i).getPosicion();
			
			//Separamos las coordenadas
			int x = posicionJugador[0];
	        int y = posicionJugador[1];
	        
			Casilla casilla = casillas[x][y];
			casilla.setPersonaje(jugadores.get(i));
		}
	}
	
	public int getLongitudTablero() {
		return this.LADOTABLERO;
	}
}
