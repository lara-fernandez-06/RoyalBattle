package battleRoyale_v1;

public class Casilla {

	private boolean isDestroyed;
	private Personaje personaje;
	private Loot loot; 
	private int[] posicion; //para tener guardada la posicion en el tablero
	
	public Casilla(int x, int y) {
		this.isDestroyed=false;
		this.personaje=null; //empezamos sin jugadores en las casillas 
		this.loot=null;
		this.posicion = new int[2];
		this.posicion[0]=x;
		this.posicion[1]=y;
	}
	
	
	
	//getters
	public boolean getIsDestroyed() {
		if(personaje!=null)personaje.quitarVida(10);
		return this.isDestroyed;
	}
	
	public int[] getPosicion() {
		return this.posicion;
	}
	
	public int getPosicionX() { //Setter
		return this.posicion[0];
	}
	
	public int getPosicionY() { //Setters
		return this.posicion[1];
	}
	
	public Personaje getPersonaje() {
		return this.personaje;
	}
	
	public Loot getLoot() {
		return this.loot;
	}
	
	//setters
	public void setIsDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}
	
	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}
	
	public void setLoot(Loot loot) {
		this.loot = loot;
	}
}
