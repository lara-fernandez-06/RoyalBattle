package battleRoyale_v1;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Partida {
	
	private ArrayList<Personaje> jugadores;
	Tablero tablero;
	String nombreFichero = new String("datosOrigen.txt");
	private int numRonda = 0;
	
	public Partida() {
		jugadores = new ArrayList<Personaje>();
		tablero = new Tablero();
		
	}
	
	
	public void jugarPartida() {
		
		//Settings
		Settings settings = new Settings();
		SettingsActionPerformed SettingAP = new SettingsActionPerformed();
		Menu_BR menu_BR = new Menu_BR(SettingsActionPerformed.getAncho() ,SettingsActionPerformed.getAlto());
	    
	    LogPartida log = null;

	    try {
	        //Creación del log
	        log = new LogPartida("resultados.log");
	        log.log(LocalDateTime.now() + " | INFO | Empieza la partida. Jugadores iniciales: " + jugadores.size());
		    
	        //Inicializamos el tablero
	        tablero.inicializarTablero(this.jugadores);
	        tablero.mostrarTablero();

	        //LÓGICA DE PARTIDA (RONDAS Y MUERTES)
	        numRonda = 0;
	        while (jugadores.size() > 1 && numRonda<25) { // Rondas
	            numRonda++;
	            
	            System.out.println("----------RONDA "+numRonda+"----------");
	            
	            if(numRonda != 0) {
		            if((numRonda%2 == 0)&&numRonda<10) {
		            	tablero.encogerTablero(numRonda);
		            }
	            }
	            
	            //Log: inicio de ronda
	            log.log(LocalDateTime.now() + " | INFO | Comienza la ronda " + numRonda);

	            //Turnos de cada jugador
	            System.out.println();
	            System.out.printf("MOVIMIENTOS Y ATAQUES\n\n");
	            for (int i = 0; i < jugadores.size(); i++) {
	                if (jugadores.get(i).checkAlive()) {
	                	System.out.println("-----------Turno de "+jugadores.get(i).getId());
	                	tablero.casillas[this.jugadores.get(i).getPosicionX()][this.jugadores.get(i).getPosicionY()].setPersonaje(jugadores.get(i));
	                	System.out.println("Principio del turno: "+jugadores.get(i).toStringWithStats());
	                	jugadores.get(i).checkTormenta(tablero);
	                	if(jugadores.get(i).checkAlive()) {
	                		jugadores.get(i).checkSurroundings(tablero);
	                	}	                    
	                	System.out.println("Final del turno: "+jugadores.get(i).toStringWithStats());
	                }
	            }
	            this.imprimirJugadoresStats();
	            
	            //Eliminamos jugadores muertos y logueamos
	            System.out.printf("MUERTOS:\n\n");
	            for (int i = 0; i < jugadores.size(); i++) {
	                if (!jugadores.get(i).checkAlive()) {
	                    log.log(LocalDateTime.now() + " | INFO | " + jugadores.get(i).getNombre() + " [ID: " + jugadores.get(i).getId() + "] ha sido eliminado");
	                    System.out.println("Este personaje ha muerto: " + jugadores.get(i).toString());
	                    tablero.casillas[jugadores.get(i).getPosicionX()][jugadores.get(i).getPosicionY()].setPersonaje(null);
	                    jugadores.remove(i); //Eliminamos muerto del arraylist
	                    i--; //Para no saltarnos jugadores al borrar
	                }
	            }
	            
	            System.out.printf("VIVOS\n\n");
    		    System.out.println("Los siguientes personajes siguen vivos:");
    		    for(int i = 0; i < jugadores.size(); i++) {
    		    	System.out.println(jugadores.get(i).toStringWithStats());
    		    }
    		    
    		    System.out.printf("TABLERO\n\n");
    		    this.tablero.mostrarTablero();
	            
	        }
	        
	        //FIN DE PARTIDA: GANADOR
	        //Log: ganador
	        if (jugadores.size() == 1) {
	        	System.out.println("El ganador ha sido: " + jugadores.getFirst().toStringWithStats());
	            log.log(LocalDateTime.now() + " | INFO | GANADOR: " + jugadores.get(0).getNombre() + " [ID: " + jugadores.get(0).getId() + "]");
	        }
	        if(jugadores.size()>1) {
	        	System.out.println("Ha habido un empate!! Los ganadores son: ");
	        	log.log(LocalDateTime.now() +  " | INFO | EMPATE, LOS GANADORES SON: ");
	        	for(int i = 0; i < jugadores.size(); i++) {
    		    	System.out.println(jugadores.get(i).toStringWithStats());
    	            log.log(LocalDateTime.now() + " | INFO | GANADOR (EMPATE): " + jugadores.get(i).getNombre() + " [ID: " + jugadores.get(i).getId() + "]");
    		    }
	        }
	        if(jugadores.size()<1) {
	        	System.out.println("Todos los personajes perecieron en el campo de batalla. No hay ganador");
	        	log.log(LocalDateTime.now() + " | INFO | TODOS LOS JUGADORES PERECIERON EN EL CAMPO DE BATALLA. ");
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	       if (log != null) log.cerrar();
	    }
	}


	public void inicializarPartida() {
		//definimos las variables
		String nombreFichero;
		char [] arrayNombreFichero;
				
		//Añadimos a jugadores el personaje creado por el usuario
		nombreFichero = MenuActionPerformed.getnombreFichero();
		try {
			if(nombreFichero == null || nombreFichero.equals("")) {
				leerFicheroPartida("datosOrigen.txt");
			}else {
				leerFicheroPartida(nombreFichero);
			}
		}catch(Exception e) {
			leerFicheroPartida("datosOrigen.txt");
		}
		crearPersonajeUsuario();
		imprimirJugadores();
		barajar();
		imprimirJugadoresStats();
		
	}
	
	
	//CREACIÓN DEL PERSONAJE DEL JUGADOR
	private void crearPersonajeUsuario() {
		
		String raza = PersonajeActionPerformed.getRaza();
		String arma = PersonajeActionPerformed.getArma();
		String nombre = PersonajeActionPerformed.getNombrePJ();
		
		if(raza == null) {
			raza = "Caballero";
		}
		if(arma == null) {
			arma = "Espada";
		}
		
		System.out.println("RAZA: "+raza );
		System.out.println("ARMA: "+arma );
		System.out.println("NOMBRE: "+nombre );
		
		try {
			this.crearPersonaje(raza, arma, nombre);
		}catch(ArmaNotExistException armaE) {
			System.out.println(armaE.getMessage());
		}catch(PersonajeNotExistException personajeE) {
			System.out.println(personajeE.getMessage());
		}
		
	}
	
	
	//GESTION FICHERO DATOS
	private void leerFicheroPartida(String nombreFichero) {
		//definimos las variables
		File f;
		Scanner s;
		final int TAM_MAX = 25;
		
		try {
			//Incializamos las variables
			f = new File(nombreFichero);
			s = new Scanner(f);
			int counter = 0;
			
			//Leemos línea y separamos por demilitadores
			while(s.hasNextLine() && counter < TAM_MAX) {
				Scanner sl = new Scanner(s.nextLine());
				sl.useDelimiter(";");
				
				try {
					crearPersonaje(sl.next(), sl.next(), sl.next());
					counter++;
				}catch(ArmaNotExistException armaE) {
					System.err.println(armaE.getMessage());
				}catch(PersonajeNotExistException personajeE) {
					System.err.println(personajeE.getMessage());
				}finally {
					sl.close();
				}
			}
			s.close();
		}catch(FileNotFoundException e) {
			try {
				//definimos las variables
				String[] tiposPersonaje = {"Caballero", "Ogro", "Elfo", "Mago", "Ladrón"};
				String[] tiposArma = {"Espada", "Maza", "Arco", "Báculo", "Daga"};
				
				FileWriter fichero = new FileWriter(nombreFichero);
				PrintWriter pw = new PrintWriter(fichero);
				
				for(int i = 0; i < tiposPersonaje.length; i++) {
					for(int j = 0; j < tiposArma.length; j++) {
						pw.println(tiposPersonaje[i] + ";" + tiposArma[j] + ";" + tiposPersonaje[i] + (j + 1));
					}
				}
				
				//Cerramos el stream
				pw.close();
				fichero.close();
				
				//Leemos el fichero
				//Incializamos las variables
				f = new File(nombreFichero);
				s = new Scanner(f);
				int counter = 0;
				
				//Leemos línea y separamos por demilitadores
				while(s.hasNextLine() && counter < TAM_MAX) {
					Scanner sl = new Scanner(s.nextLine());
					sl.useDelimiter(";");
					
					try {
						crearPersonaje(sl.next(), sl.next(), sl.next());
						counter++;
					}catch(ArmaNotExistException armaE) {
						System.out.println(armaE.getMessage());
					}catch(PersonajeNotExistException personajeE) {
						System.out.println(personajeE.getMessage());
					}finally {
						sl.close();
					}
				}
				s.close();
			}catch(IOException ioE) {
				ioE.printStackTrace();
			}
		}
	}
	
	
	//CREACIÓN DE PERSONAJES
	private Arma crearArma(String nombreArma) throws ArmaNotExistException{
		if(nombreArma.equalsIgnoreCase("Espada")) {
			return new Espada();
		}else if(nombreArma.equalsIgnoreCase("Maza")) {
			return new Maza();
		}else if(nombreArma.equalsIgnoreCase("Arco")) {
			return new Arco();
		}else if(nombreArma.equalsIgnoreCase("Báculo") || nombreArma.equalsIgnoreCase("Baculo")) {
			return new Baculo();
		}else if(nombreArma.equalsIgnoreCase("Daga")) {
			return new Daga();
		}else {
			throw new ArmaNotExistException();
		}
	}
	
	private void crearPersonaje(String nuevoPersonaje, String arma, String nombre) throws PersonajeNotExistException, ArmaNotExistException{
		if(nuevoPersonaje.equalsIgnoreCase("Caballero")) {
			this.jugadores.add(new Caballero(nombre, crearArma(arma)));
		}else if(nuevoPersonaje.equalsIgnoreCase("Ogro")) {
			this.jugadores.add(new Ogro(nombre, crearArma(arma)));
		}else if(nuevoPersonaje.equalsIgnoreCase("Elfo")) {
			this.jugadores.add(new Elfo(nombre, crearArma(arma)));
		}else if(nuevoPersonaje.equalsIgnoreCase("Mago")) {
			this.jugadores.add(new Mago(nombre, crearArma(arma)));
		}else if(nuevoPersonaje.equalsIgnoreCase("Ladrón") || nuevoPersonaje.equalsIgnoreCase("Ladron")) {
			this.jugadores.add(new Ladron(nombre, crearArma(arma)));
		}else {
			throw new PersonajeNotExistException();
		}
	}
	
	private void barajar() {
		//definimos las variables
		Random random = new Random();
		
		//Mezclamos los jugadores
		for(int i = 0; i < jugadores.size(); i++) {
			int num = random.nextInt(jugadores.size() - 1) + 1;
			Personaje temp = jugadores.get(num);
			jugadores.set(num, jugadores.get(i));
			jugadores.set(i, temp);
		}
	}
	
	private void imprimirJugadoresStats() {
		for(int i=0; i<jugadores.size(); i++) {
			System.out.println(jugadores.get(i).toStringWithStats());
			System.out.println("En la casilla de " +jugadores.get(i).getId()+" hay "+ tablero.casillas[jugadores.get(i).getPosicionX()][jugadores.get(i).getPosicionY()].getPersonaje());
		}
	}
	
	private void imprimirJugadores() {
		for(int i = 0; i < jugadores.size(); i++) {
			System.out.println(jugadores.get(i).toString());
		}
	}
}
