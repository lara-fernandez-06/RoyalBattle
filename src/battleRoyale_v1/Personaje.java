package battleRoyale_v1;

public abstract class Personaje implements AccionesPersonaje {

	//Atributos
	private int id;
	private Rol rol;
	private String nombre;
	private int vida;
	private int pasos;
	private int vision;
	private Arma arma;
	private boolean buff;
	private int[] posicionEnemiga;
	private boolean heSidoAtacado;
	private static int counter;
	
	//al final vamos a hacer el roll for attack??
	
	private int[] posicion; //cambio de la matriz de ints a un array que va a ser de dos, el [0] para la x y el [1] para la y
	//Lara los getters y setters te los he `puesto abajo con el resto
	
	
	//Falta gestionar el buff
	//Constructor
	public Personaje(Rol rol, String nombre, int vida, int pasos, int vision, Arma arma) {
		this.id = counter;
		this.rol = rol;
		this.nombre = nombre;
		this.vida = vida;
		this.pasos = pasos;
		this.vision = vision;
		this.arma = arma;
		this.buff = checkBuff();
		this.posicion =  new int[2]; //inicializamos el array para que solo tenga 2 elementos
		this.posicionEnemiga = new int[2];
		this.heSidoAtacado = false;
		counter++;
	}
	
	
	public void atacar(Personaje enemigo) {
		//TODO: NO SE SI ESTO ES CORRECTO PORQUE LUEGO EN TODOS LOS
		//PEQUEÑOS PERSONAJES ME HACE PONER LOS MÉTODOS
		if(this.buff == true) {
			enemigo.quitarVida(arma.getDmg() * 2);
		} else {
			enemigo.quitarVida(arma.getDmg());
		}
		
		//Comprobación si mi enemigo ha muerto
		if(this.heSidoAtacado == true) {
			if(enemigo.getVida() <= 0) {
				this.heSidoAtacado = false; //El enemigo ha muerto
			}
		}
	}

	public void quitarVida(int dmg) {
		this.vida -= dmg;
	}

	public boolean checkBuff() {
		return rol.getId() == arma.id;
	}
	
	//Aqui he cambiado la lógica para que devuelva casillas en vez de booleanos
	public void checkSurroundings(Tablero tablero) {
		
		Casilla objetivo; //Sea enemigo o loot
		
		if(this.heSidoAtacado == false) {
			if((objetivo = checkEnemies(tablero)) == null) {
				if((objetivo = checkLoot(tablero)) == null) {
					objetivo = tablero.casillas[5][5];
					this.moverLoot(objetivo, tablero);
				}else {
					moverLoot(objetivo, tablero);
					if(this.posicion == objetivo.getPosicion()) {
						//TODO método para ejecutar el buff
						objetivo.setLoot(null);
					}
				}
			}else {
				
				this.moverEnemigo(objetivo, tablero);
				if(this.checkGolpear(tablero)) {
					this.atacar(objetivo.getPersonaje());
					objetivo.getPersonaje().posicionEnemiga = tablero.casillas[this.posicion[0]][this.posicion[1]].getPosicion();
					objetivo.getPersonaje().heSidoAtacado = true;
				}
			}
		}else {
			objetivo = tablero.casillas[this.posicionEnemiga[0]][this.posicionEnemiga[1]];
			this.moverEnemigo(objetivo, tablero);
			if(this.checkGolpear(tablero)) {
				this.atacar(objetivo.getPersonaje());
			}
		}
		
		
		//TODO Comprobar si el rango del arma es suficiente como para darle al enemigo, si no lo es, sse mueve hacia el
		
	}
	
	//deberiamos devolver donde está el enemigo para que se pueda mover hacia el, deberiamos devolver la casilla entera??
	private Casilla checkEnemies(Tablero tablero) {
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
					if(tablero.casillas[i][j].getPersonaje() != null) return tablero.casillas[i][j]; //si hay un personaje en la casilla, devuelve la casilla
				}
				
			}
		}
		
		return null; //donde llamemos a esta función hay que poner un if(checkEnemies == null), y solo hacer algo si no lo es (pero no comparar con true/false)
	}
	
	private Casilla checkLoot(Tablero tablero) {
		
		int i=0, j=0;
		
		for(i=Math.max(posicion[0]-this.vision, 0); i<=Math.min(this.posicion[0]+this.vision, (tablero.getLongitudTablero()-1)); i++) {
			for(j=Math.max(posicion[1]-this.vision, 0); j<=Math.min(this.posicion[1]+this.vision, (tablero.getLongitudTablero()-1)); j++) {
				//esta condicón no estoy segura todavía si vale para gestionar que el tablero se haya hecho más pequeño
				if(tablero.casillas[i][j].getIsDestroyed() == false) {
					if(tablero.casillas[i][j].getLoot() != null) return tablero.casillas[i][j]; //si la casilla tiene loot, la devuelve la casilla
				}
				
			}
		}
		
		
		return null; // si llega hasta aqui es que no ha encontrado nada, asi que devuelve null
	}
	
	public boolean checkGolpear(Tablero tablero) {
		int i=0, j=0;
		for(i=Math.max(posicion[0]-this.arma.getRango(), 0); i<=Math.min(this.posicion[0]+this.arma.getRango(), (tablero.getLongitudTablero()-1)); i++) {
			for(j=Math.max(posicion[1]-this.arma.getRango(), 0); j<=Math.min(this.posicion[1]+this.arma.getRango(), (tablero.getLongitudTablero()-1)); j++) {
				//esta condicón no estoy segura todavía si vale para gestionar que el tablero se haya hecho más pequeño
				if(tablero.casillas[i][j].getIsDestroyed() == false) {
					if(tablero.casillas[i][j].getPersonaje() != null) return true; //si le puede dar devulve true
				}
				
			}
		}
		
		return false; //si no puede dar al personaje devuelve false
	}
	
	//TODO: hay que pensar que le vamos a pasar en el caso que se mueva al centro
	private void moverLoot(Casilla objetivo, Tablero tablero) {
		//lo más fácil sería hacer que se mueva en el eje x hasta que coincida con la x del objetivo, y luego se mueva en la y
		//creo que podría dar problemas si los dos se tienen de objetivos entre sí (si son dos personajes, si uno es loot da igual)
		//si no lo que se podría hacer es que calcule si está a más casillas de la x o de la y y que se mueva para cerrar la distancia más grande
		
		
		int[] objetivoPosicion; //Una variable donde guardaremos la posicion del objetivo
		int[] diferencia = new int[2]; //Array donde guardamos la diferencia entre personaje y objetivo
		objetivoPosicion = objetivo.getPosicion();
		
		//eliminar el personaje de la casilla en el que empieza
		//tablero.casillas[this.posicion[0]][this.posicion[1]].setIsOccupied(false);
		tablero.casillas[this.posicion[0]][this.posicion[1]].setPersonaje(null);
		
		for(int i=0; i<this.pasos; i++) {
			
			diferencia[0] = objetivoPosicion[0]-this.posicion[0];
			diferencia[1] = objetivoPosicion[1]-this.posicion[1];
			
			//las comparaciones están en absoluto para que no influya el signo
			//si está mas lejos en la x que en la y -> se mueve en x
			if(Math.abs(diferencia[0])>Math.abs(diferencia[1])) {
				//mira el signo de diferencia y me mueve hacia la derecha o izquierda
				if(diferencia[0]>0)
					this.posicion[0]+= 1;
				if(diferencia[0]<0)
					this.posicion[0]-= 1;
				
			//si está mas lejos en la y que en la x -> se mueve en y
			}else if(Math.abs(diferencia[1])>Math.abs(diferencia[0])){
				//mira el signo de diferencia y se mueve arriba o abajo
				if(diferencia[1]>0)
					this.posicion[1]+= 1;
				if(diferencia[1]<0)
					this.posicion[1]-= 1;
				
			//si está a la misma distacia -> se mueve en diagonal
			}else {
				//se mueve en x
				if(diferencia[0]>0)
					this.posicion[0]+= 1;
				if(diferencia[0]<0)
					this.posicion[0]-= 1;
				
				//se mueve en y
				if(diferencia[1]>0)
					this.posicion[1]+= 1;
				if(diferencia[1]<0)
					this.posicion[1]-= 1;
			}
		}
		
		//updatear la casilla en la que está el personaje
		//tablero.casillas[this.posicion[0]][this.posicion[1]].setIsOccupied(true);
		tablero.casillas[this.posicion[0]][this.posicion[1]].setPersonaje(this);
	}
	
	private void moverEnemigo(Casilla objetivo, Tablero tablero) {
		//lo más fácil sería hacer que se mueva en el eje x hasta que coincida con la x del objetivo, y luego se mueva en la y
		//creo que podría dar problemas si los dos se tienen de objetivos entre sí (si son dos personajes, si uno es loot da igual)
		//si no lo que se podría hacer es que calcule si está a más casillas de la x o de la y y que se mueva para cerrar la distancia más grande
		//TODO: logica de movimiento
		
		
		int[] objetivoPosicion; //Una variable donde guardaremos la posicion del objetivo
		int[] diferencia = new int[2]; //Array donde guardamos la diferencia entre personaje y objetivo
		objetivoPosicion = objetivo.getPosicion();
		
		//eliminar el personaje de la casilla en el que empieza
		//tablero.casillas[this.posicion[0]][this.posicion[1]].setIsOccupied(false);
		tablero.casillas[this.posicion[0]][this.posicion[1]].setPersonaje(null);
		
		for(int i=0; i<this.pasos; i++) {
			if(this.checkGolpear(tablero) == false) {
				diferencia[0] = objetivoPosicion[0]-this.posicion[0];
				diferencia[1] = objetivoPosicion[1]-this.posicion[1];
				
				//las comparaciones están en absoluto para que no influya el signo
				//si está mas lejos en la x que en la y -> se mueve en x
				if(Math.abs(diferencia[0])>Math.abs(diferencia[1])) {
					//mira el signo de diferencia y me mueve hacia la derecha o izquierda
					if(diferencia[0]>0)
						this.posicion[0]+= 1;
					if(diferencia[0]<0)
						this.posicion[0]-= 1;
					
				//si está mas lejos en la y que en la x -> se mueve en y
				}else if(Math.abs(diferencia[1])>Math.abs(diferencia[0])){
					//mira el signo de diferencia y se mueve arriba o abajo
					if(diferencia[1]>0)
						this.posicion[1]+= 1;
					if(diferencia[1]<0)
						this.posicion[1]-= 1;
					
				//si está a la misma distacia -> se mueve en diagonal
				}else {
					//se mueve en x
					if(diferencia[0]>0)
						this.posicion[0]+= 1;
					if(diferencia[0]<0)
						this.posicion[0]-= 1;
					
					//se mueve en y
					if(diferencia[1]>0)
						this.posicion[1]+= 1;
					if(diferencia[1]<0)
						this.posicion[1]-= 1;
				}
			}
		}
		
		//updatear la casilla en la que está el personaje
		tablero.casillas[this.posicion[0]][this.posicion[1]].setPersonaje(this);
	}
	
	public boolean checkAlive() {
		if(this.vida<=0) return true;
		else return false;
	}
	
	//toString
	@Override
	public String toString() {
		return "Nombre: " + this.nombre + " Rol: " + this.rol.toString() + " Arma: " + this.arma.toString();
	}
	
	public String toStringWithStats() {
		return this.toString() + " Vida: " + this.vida + " Vision: " + this.vision + " Pasos: " + this.pasos + " Ataque: " + this.arma.getDmg() +" Rango de ataque: " + this.arma.getRango() + " Buff: " + toStringBuff();
	}
	
	private String toStringBuff() {
		if(buff == true) {
			return "Sí";
		}else {
			return "No";
		}
	}
	
	//Getters y Setters
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getPasos() {
		return pasos;
	}

	public void setPasos(int pasos) {
		this.pasos = pasos;
	}

	public int getVision() {
		return vision;
	}

	public void setVision(int vision) {
		this.vision = vision;
	}
	
	public void setPosicion(int posicionX, int posicionY) {
		this.posicion[0] = posicionX;
		this.posicion[1] = posicionY;
	}
	
	public int[] getPosicion() {
		return this.posicion;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}
}