package battleRoyale_v1;

public abstract class Personaje implements AccionesPersonaje {

	//Atributos
	private int id;
	private Rol rol;
	private String nombre;
	private int vidaMax; //!!!!!!!AÑADO VIDA ACTUAL Y VIDA MAX, PERO NO LO AÑADO EN EL CONSTRCUTOR PORQUE NO ESTOT SEGURA DE COMO ESTÁ PENSADO PARA LAS SUBCLASES
						//QUE OPINE ALONSO QUE HA HECHO EL CONSTRUCTOR
	private int vidaActual;
	private int pasos;
	private int vision;
	private Arma arma;
	private boolean buff;
	private static int counter;
	
	//al final vamos a hacer el roll for attack??
	
	private int[] posicion; //cambio de la matriz de ints a un array que va a ser de dos, el [0] para la x y el [1] para la y
	
	//Falta gestionar el buff
	//Constructor
	public Personaje(Rol rol, String nombre, int vida, int pasos, int vision, Arma arma) {
		this.id = counter;
		this.rol = rol;
		this.nombre = nombre;
		this.vidaMax = vida;
		this.pasos = pasos;
		this.vision = vision;
		this.arma = arma;
		counter++;
		this.posicion =  new int[2]; //inicializamos el array para que solo tenga 2 elementos
	}
	
	
	//Métodos sin definir
	public void atacar() {
		// TODO Auto-generated method stub
		
		//aqui llamar a checkBuff
		
	}

	public void quitarVida(int dmg) {
		
	}

	public boolean checkBuff() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setPosicion(int posicionX, int posicionY) {
		this.posicion[0] = posicionX;
		this.posicion[1] = posicionY;
	}
	
	public int[] getPosicion() {
		return this.posicion;
	}
	
	//Aqui he cambiado la lógica para que devuelva casillas en vez de booleanos
	public void checkSurroundings(Tablero tablero) {
		// TODO Auto-generated method stub
		
		Casilla objetivo; //Sea enemigo o loot
		
		objetivo = checkEnemies(tablero);
		if(objetivo == null) {
			objetivo = checkLoot(tablero);
			if(objetivo == null) {
				//TODO Mover hacia el centro
			}else {
				//TODO Mover hacia el loot
			}
		}else {
			//TODO Comprobar si el rango del arma es suficiente como para darle al enemigo, si no lo es, sse mueve hacia el
			//para esto tenemos que encontrar una forma de calcular la distancia entre casillas
			//hay que pensar que pasa si están situados el L, como un caballo de ajedrez:
			/* [x][ ][ ]
			 * [ ][ ][ ]  -> esto cuantas casillas son?? podriamos decir q son 2 porque está en el segundo "anillo"
			 * [ ][x][ ]
			 */
		}
	}
	
	//deberiamos devolver donde está el enemigo para que se pueda mover hacia el, deberiamos devolver la casilla entera??
	public Casilla checkEnemies(Tablero tablero) {
		/*Si encuentra enemigos devuelve true, si encuentra multiples que vaya a por el que más cerca está, si hay multiples en una distancia igual, que vaya a por el que menos vida tenga, 
		y si tienen la misma vida pues que elija al azar
		Si no false*/
		
		int i=0, j=0;
		
		//inicializamos i a la posicion - la vision y recorrerá hasta la posición + la visión
		//los math .max y .min están para clampear (y que si el personaje esté en la casilla 0,1 no intente leer la -1,0)
		//TODO: esto solo funciona con el tablero completo. Habría que mirar como hacerlo, quizá comprobando la condicón de isDestroyed
		//pero aun así el clampeo funciona para que no haga IndexOutOfBounds
		for(i=Math.max(posicion[0]-this.vision, 0); i<=Math.min(this.posicion[0]+this.vision, (tablero.getLongitudTablero()-1)); i++) {
			for(j=Math.max(posicion[1]-this.vision, 0); j<=Math.min(this.posicion[1]+this.vision, (tablero.getLongitudTablero()-1)); j++) {
				//esta condicón no estoy segura todavía si vale para gestionar que el tablero se haya hecho más pequeño
				if(tablero.casillas[i][j].getIsDestroyed() == false) {
					if(tablero.casillas[i][j].getIsOccupied() == true) return tablero.casillas[i][j]; //si la casilla está ocupada, la devuelve
				}
				
			}
		}
		
		return null; //donde llamemos a esta función hay que poner un if(checkEnemies == null), y solo hacer algo si no lo es (pero no comparar con true/false)
	}
	
	public Casilla checkLoot(Tablero tablero) {
		
		int i=0, j=0;
		
		for(i=Math.max(posicion[0]-this.vision, 0); i<=Math.min(this.posicion[0]+this.vision, (tablero.getLongitudTablero()-1)); i++) {
			for(j=Math.max(posicion[1]-this.vision, 0); j<=Math.min(this.posicion[1]+this.vision, (tablero.getLongitudTablero()-1)); j++) {
				//esta condicón no estoy segura todavía si vale para gestionar que el tablero se haya hecho más pequeño
				if(tablero.casillas[i][j].getIsDestroyed() == false) {
					if(tablero.casillas[i][j].getHasLoot() == true) return tablero.casillas[i][j]; //si la casilla tiene loot, la devuelve
				}
				
			}
		}
		
		
		return null; // si llega hasta aqui es que no ha encontrado nada, asi que devuelve null
	}
	
	//hay que pensar que le vamos a pasar en el caso que se mueva al centro
	public void mover(Casilla objetivo) {
		//lo más fácil sería hacer que se mueva en el eje x hasta que coincida con la x del objetivo, y luego se mueva en la y
		//creo que podría dar problemas si los dos se tienen de objetivos entre sí (si son dos personajes, si uno es loot da igual)
		//si no lo que se podría hacer es que calcule si está a más casillas de la x o de la y y que se mueva para cerrar la distancia más grande
		//TODO: logica de movimiento
	}
}
