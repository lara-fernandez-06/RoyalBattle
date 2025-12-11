package battleRoyale_v1;

public class Casilla {

	private boolean isDestroyed;
	private boolean isOccupied;
	
	private Personaje jugador;
	
	public Casilla() {
		
	}
	
	
	//CheckSurroundings y sus funciones, no sé si van aquí o en el personaje
	public void checkSurroundings() {
		// TODO Auto-generated method stub
		final boolean enemyDetected;
		final boolean lootDetected;
		enemyDetected = checkEnemies();
		if(enemyDetected == false) {
			lootDetected = checkLoot();
			if(lootDetected == true) {
				//TODO Mover hacia el loot
			}else {
				//TODO Mover hacia el centro
			}
		}else {
			//TODO Comprobar si el rango del arma es suficiente como para darle al enemigo, si no lo es, sse mueve hacia el
		}
	}
	public boolean checkEnemies() {
		/*Si encuentra enemigos devuelve true, si encuentra multiples que vaya a por el que más cerca está, si hay multiples en una distancia igual, que vaya a por el que menos vida tenga, 
		y si tienen la misma vida pues que elija al azar
		Si no false*/
	}
	public boolean checkLoot() {
		
	}
	
	
	
	public void setIsOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	
	public boolean getIsOccupied() {
		return this.isOccupied;
	}
	
	public void setJugador(Personaje jugador) {
		this.jugador = jugador;
	}
}
