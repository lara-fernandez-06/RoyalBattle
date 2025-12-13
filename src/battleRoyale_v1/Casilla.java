package battleRoyale_v1;

public class Casilla {

	private boolean isDestroyed;
	private boolean isOccupied;
	private boolean hasLoot;
	
	private Personaje personaje;
	//private Loot loot; //TEMPORAL!!!!! es que no hay clase hecha y no lo hemos hablado como para hacerla yo
					   //en esta deberían entrar armas también, asi que a lo mejor habría que hacer una genérica
	
	private int[] posicion; //para tener guardada la posicion en el tablero
	
	public Casilla(int x, int y) {
		this.isDestroyed=false;
		this.isOccupied=false;
		this.hasLoot=false;
		this.personaje=null; //empezamos sin jugadores en las casillas 
		//this.loot=null;
		this.posicion = new int[2];
		this.posicion[0]=x;
		this.posicion[1]=y;
	}
	
	
	//getters
	public boolean getIsOccupied() {
		return this.isOccupied;
	}
	
	public boolean getIsDestroyed() {
		return this.isDestroyed;
	}
	
	public boolean getHasLoot() {
		return this.hasLoot;
	}
	
	public int[] getPosicion() {
		return this.posicion;
	}
	
	//setters
	public void setJugador(Personaje personaje) {
		this.personaje = personaje;
	}
	
	public void setIsOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
}
