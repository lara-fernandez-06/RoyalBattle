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
	private int[] posicion; //cambio de la matriz de ints a un array que va a ser de dos, el [0] para la x y el [1] para la y	
	
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
		if(enemigo != null) {
			if(enemigo.getVida() > 0) {
				//si tiene el buff o no
				if(this.buff == true) {
					System.out.println(this.id + " esta atacando a " + enemigo.id + " con este daño: " + arma.getDmg() * 2);
					enemigo.quitarVida(arma.getDmg() * 2);
					System.out.println("Enemigo "+enemigo.id+" después de ser atacado:" + enemigo.vida);
				} else {
					enemigo.quitarVida(arma.getDmg());
					System.out.println(this.id + " esta atacando a " + enemigo.id + " con este daño: "  + arma.getDmg());
					System.out.println("Enemigo "+enemigo.id+" después de ser atacado:" + enemigo.vida);
				}
				
				//Comprobación si mi enemigo ha muerto (si me habia atacado previamente)
				if(enemigo.getVida() <= 0) {
						this.heSidoAtacado = false; //El enemigo ha muerto
						this.posicionEnemiga[0]=0;
						this.posicionEnemiga[1]=0;
					System.out.println(this.id +" ha matado a "+ enemigo.id);
				}
				
			}
		}
	}

	public void quitarVida(int dmg) {
		this.vida -= dmg;
		System.out.println(this.id + " ha sufrido "+dmg+" de danio");
	}

	public boolean checkBuff() {
		return rol.getId() == arma.id;
	}
	
	public void checkSurroundings(Tablero tablero) {
		
		Casilla objetivo; //Sea enemigo o loot
		
		//comprobar que el que me ha atacado sigue vivo. Si no lo está, hago turno normal
		if(this.heSidoAtacado && (tablero.casillas[this.posicionEnemiga[0]][this.posicionEnemiga[1]].getPersonaje()==null || tablero.casillas[this.posicionEnemiga[0]][this.posicionEnemiga[1]].getPersonaje().checkAlive()==false) ) {
			this.heSidoAtacado=false;
		}
		
		if(this.heSidoAtacado == false) {
			
			if((objetivo = checkEnemies(tablero)) == null) { //si no hay enemigos
				
				if((objetivo = checkLoot(tablero)) == null) { //si no hay loot
					
					objetivo = tablero.casillas[5][5]; //nos vamos al centro
					this.moverCentro(objetivo, tablero); 
					System.out.println(this.id + " se está moviendo hacia el centro ");
					
				}else { //hay loot y vamos hacia allí
					System.out.println(this.id + " se está moviendo hacia el loot " + objetivo.getLoot().getTipo()+" que ha visto");
					moverLoot(objetivo, tablero);
					if(this.posicion[0] == objetivo.getPosicionX() && this.posicion[1] == objetivo.getPosicionY()) {
						objetivo.getLoot().aplicar(this);
						objetivo.setLoot(null);
						System.out.println(this.id + " ha recogido loot");
					}
					
				}
			}else { //si se detecta un enemigo
							
				System.out.println(objetivo.getPersonaje().getId()+ " ha sido avistado");
				//miramos si está en rango de ataque
				if(checkGolpear(tablero, objetivo.getPersonaje())) { //si se puede atacar
					this.atacar(objetivo.getPersonaje());
					//después de ser atacado, el enemigo se da cuenta
					objetivo.getPersonaje().posicionEnemiga[0] = this.posicion[0];
					objetivo.getPersonaje().posicionEnemiga[1] = this.posicion[1];
					objetivo.getPersonaje().heSidoAtacado = true;
					System.out.println(objetivo.getPersonaje().getId()+ " ha sido atacado");
				}else { //si no tiene rango, se mueve hacia el enemigo
					this.moverEnemigo(objetivo, tablero);
					//como puede ser que aunque se haya movido no pueda atacar, volvemos a mirarlo
					//si está en rango, golpea, si no, se acaba su turno
					if(this.checkGolpear(tablero, objetivo.getPersonaje())){
						this.atacar(objetivo.getPersonaje());
						System.out.println("El enemigo "+objetivo.getPersonaje().getId()+" está en el rango de "+this.id+" después de moverse y ha sido atacado");
						objetivo.getPersonaje().posicionEnemiga[0] = this.posicion[0];
						objetivo.getPersonaje().posicionEnemiga[1] = this.posicion[1];
						objetivo.getPersonaje().heSidoAtacado = true;
					}else System.out.println("El enemigo sigue fuera de rango");
				}	
				
					
				
			}
			
		}else { //he sido atacado
			objetivo = tablero.casillas[this.posicionEnemiga[0]][this.posicionEnemiga[1]];
			System.out.println(objetivo.getPersonaje().getId()+ " ha sido atacado y va a contraatacar");
			if(this.checkGolpear(tablero, objetivo.getPersonaje())) {
				this.atacar(objetivo.getPersonaje());
			}else {
				this.moverEnemigo(objetivo, tablero);
				//como puede ser que aunque se haya movido no pueda atacar, volvemos a mirarlo
				//si está en rango, golpea, si no, se acaba su turno
				if(this.checkGolpear(tablero, objetivo.getPersonaje())){
					this.atacar(objetivo.getPersonaje());
					objetivo.getPersonaje().posicionEnemiga = tablero.casillas[this.posicion[0]][this.posicion[1]].getPosicion();
					objetivo.getPersonaje().heSidoAtacado = true;
				}
			}
		}
		
	}
	
	private Casilla checkEnemies(Tablero tablero) {
		
		int i=0, j=0;
		
		//inicializamos i a la posicion - la vision y recorrerá hasta la posición + la visión
		//los math .max y .min están para clampear (y que si el personaje esté en la casilla 0,1 no intente leer la -1,0)
		//pero aun así el clampeo funciona para que no haga IndexOutOfBounds
		for(i=Math.max(posicion[0]-this.vision, 0); i<Math.min(this.posicion[0]+this.vision, (tablero.getLongitudTablero()-1)); i++) {
			for(j=Math.max(posicion[1]-this.vision, 0); j<Math.min(this.posicion[1]+this.vision, (tablero.getLongitudTablero()-1)); j++) {
				if(tablero.casillas[i][j].getIsDestroyed() == false) {
					if(tablero.casillas[i][j].getPersonaje() != this) {
						//hay que mirar que haya un personaje y que no esté muerto
						if(tablero.casillas[i][j].getPersonaje() != null && tablero.casillas[i][j].getPersonaje().checkAlive()==true) return tablero.casillas[i][j]; //si hay un personaje en la casilla, devuelve la casilla
					}
				}
				
			}
		}
		
		return null; 
	}

	private Casilla checkLoot(Tablero tablero) {
		
		int i=0, j=0;
		
		for(i=Math.max(posicion[0]-this.vision, 0); i<Math.min(this.posicion[0]+this.vision, (tablero.getLongitudTablero()-1)); i++) {
			for(j=Math.max(posicion[1]-this.vision, 0); j<Math.min(this.posicion[1]+this.vision, (tablero.getLongitudTablero()-1)); j++) {
				if(tablero.casillas[i][j].getIsDestroyed() == false) {
					if(tablero.casillas[i][j].getPersonaje() != this) {
						if(tablero.casillas[i][j].getLoot() != null) return tablero.casillas[i][j]; //si la casilla tiene loot, la devuelve la casilla
					}
				}
				
			}
		}
		
		
		return null; // si llega hasta aqui es que no ha encontrado nada, asi que devuelve null
	}
	
	public boolean checkGolpear(Tablero tablero, Personaje enemigo) {
		int i=0, j=0;
		for(i=Math.max(posicion[0]-this.arma.getRango(), 0); i<Math.min(this.posicion[0]+this.arma.getRango(), (tablero.getLongitudTablero()-1)); i++) {
			for(j=Math.max(posicion[1]-this.arma.getRango(), 0); j<Math.min(this.posicion[1]+this.arma.getRango(), (tablero.getLongitudTablero()-1)); j++) {
				if(tablero.casillas[i][j].getIsDestroyed() == false) {
					if(tablero.casillas[i][j].getPersonaje() != this) {
						if(tablero.casillas[i][j].getPersonaje() == enemigo) {
							return true; //si le puede dar al enemigo del objetivo devulve true
						}
					}
				}
				
			}
		}
		
		return false; //si no puede dar al personaje devuelve false
	}
	
	private void moverLoot(Casilla objetivo, Tablero tablero) {		
		
		int[] objetivoPosicion; //Una variable donde guardaremos la posicion del objetivo
		objetivoPosicion = objetivo.getPosicion();
		
		//eliminar el personaje de la casilla en el que empieza
		tablero.casillas[this.posicion[0]][this.posicion[1]].setPersonaje(null);
		
		for(int i=0; i<this.pasos; i++) {	
			if(!(this.posicion[0]==objetivoPosicion[0] && this.posicion[1]==objetivoPosicion[1])) {
				int[] aux = mirarPaso(objetivoPosicion).getPosicion();
				if(tablero.casillas[aux[0]][aux[1]].getPersonaje() == null  || tablero.casillas[aux[0]][aux[1]].getPersonaje().checkAlive()==false) {
					this.moverPaso(objetivoPosicion);
				}else System.out.println("Ha parado porque hay alguien");
			}
		}
		
		//updatear la casilla en la que está el personaje
		tablero.casillas[this.posicion[0]][this.posicion[1]].setPersonaje(this);
	}
	
	private void moverEnemigo(Casilla objetivo, Tablero tablero) {
		
		int[] objetivoPosicion; //Una variable donde guardaremos la posicion del objetivo
		
		objetivoPosicion = objetivo.getPosicion();
		
		//eliminar el personaje de la casilla en el que empieza
		tablero.casillas[this.posicion[0]][this.posicion[1]].setPersonaje(null);
		
		for(int i=0; i<this.pasos; i++) {
			if(this.checkGolpear(tablero, objetivo.getPersonaje()) == false) { //mira primero si ya está en rango para pegar al enemigo
				//aunque está enfocado en un solo enemigo, si se encuentra con otro para
				int[] aux = mirarPaso(objetivoPosicion).getPosicion();
				if(tablero.casillas[aux[0]][aux[1]].getPersonaje() == null  || tablero.casillas[aux[0]][aux[1]].getPersonaje().checkAlive()==false) {
					this.moverPaso(objetivoPosicion);
				}else System.out.println("Ha parado porque hay alguien");
			}
		}
		
		//updatear la casilla en la que está el personaje
		tablero.casillas[this.posicion[0]][this.posicion[1]].setPersonaje(this);
	}
	
private void moverCentro(Casilla objetivo, Tablero tablero) {
		
		int[] objetivoPosicion; //Una variable donde guardaremos la posicion del objetivo
		objetivoPosicion = objetivo.getPosicion();
		
		//eliminar el personaje de la casilla en el que empieza
		tablero.casillas[this.posicion[0]][this.posicion[1]].setPersonaje(null);
		
		for(int i=0; i<this.pasos; i++) {	
			if(!(this.posicion[0]==objetivoPosicion[0] && this.posicion[1]==objetivoPosicion[1])) {
				int[] aux = mirarPaso(objetivoPosicion).getPosicion();
				if(tablero.casillas[aux[0]][aux[1]].getPersonaje() == null  || tablero.casillas[aux[0]][aux[1]].getPersonaje().checkAlive()==false) {
					this.moverPaso(objetivoPosicion);
				}
			}
		}
		
		//updatear la casilla en la que está el personaje
		tablero.casillas[this.posicion[0]][this.posicion[1]].setPersonaje(this);

	}
	
	private Casilla mirarPaso(int[] objetivoPosicion) {
		int[] diferencia = new int[2]; //Array donde guardamos la diferencia entre personaje y objetivo
		Casilla aux=new Casilla(this.posicion[0], this.posicion[1]);
		
		diferencia[0] = objetivoPosicion[0]-this.posicion[0];
		diferencia[1] = objetivoPosicion[1]-this.posicion[1];
		
		//las comparaciones están en absoluto para que no influya el signo
		//si está mas lejos en la x que en la y -> se mueve en x
		if(Math.abs(diferencia[0])>Math.abs(diferencia[1])) {
			//mira el signo de diferencia y me mueve hacia la derecha o izquierda
			if(diferencia[0]>0)
				aux.setPosicionX(this.posicion[0]+ 1);
			if(diferencia[0]<0)
				aux.setPosicionX(this.posicion[0]-1);
			
		//si está mas lejos en la y que en la x -> se mueve en y
		}else if(Math.abs(diferencia[1])>Math.abs(diferencia[0])){
			//mira el signo de diferencia y se mueve arriba o abajo
			if(diferencia[1]>0)
				aux.setPosicionY(this.posicion[1]+ 1);
			if(diferencia[1]<0)
				aux.setPosicionY(this.posicion[1]-1);
			
		//si está a la misma distacia -> se mueve en diagonal
		}else {
			//se mueve en x
			if(diferencia[0]>0)
				aux.setPosicionX(this.posicion[0]+ 1);
			if(diferencia[0]<0)
				aux.setPosicionX(this.posicion[0]-1);
			
			//se mueve en y
			if(diferencia[1]>0)
				aux.setPosicionY(this.posicion[1]+ 1);
			if(diferencia[1]<0)
				aux.setPosicionY(this.posicion[1]-1);
		}
		
		return aux;
	}
	
	//logica para decidir hacia donde se mueve el personaje
	//calcula si está a más casillas de la x o de la y y que se mueve para cerrar la distancia más grande
	private void moverPaso(int[] objetivoPosicion) {
		
		int[] diferencia = new int[2]; //Array donde guardamos la diferencia entre personaje y objetivo
		
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
	
	public boolean checkAlive() {
		if(this.vida>0) return true;
		else return false;
	}
	

	public void checkTormenta(Tablero tablero) {
		if(tablero.casillas[this.posicion[0]][this.posicion[1]].getIsDestroyed() == true) this.quitarVida(5);
		
	}
	
	//toString
	@Override
	public String toString() {
		return "ID: " + this.id + " Nombre: " + this.nombre + " Rol: " + this.rol.toString() + " Arma: " + this.arma.toString();
	}
	
	public String toStringWithStats() {
		return this.toString() + " Vida: " + this.vida + " Vision: " + this.vision + " Pasos: " + this.pasos + " Ataque: " + this.arma.getDmg() +" Rango de ataque: " + this.arma.getRango() + " Posicion: [" + this.getPosicionX() + ", " + this.getPosicionY() + "]" + " Buff: " + toStringBuff();
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
		return this.vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getPasos() {
		return this.pasos;
	}

	public void setPasos(int pasos) {
		this.pasos = pasos;
	}

	public int getVision() {
		return this.vision;
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
	
	public int getPosicionX() {
		return this.posicion[0];
	}
	
	public int getPosicionY() {
		return this.posicion[1];
	}
	
	public Rol getRol() {
		return this.rol;
	}


	public Arma getArma() {
		return this.arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

}