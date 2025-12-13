package battleRoyale_v1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
	//Atributos
	private ArrayList<Personaje> jugadores;
	Tablero tablero;
	String nombreFichero = new String("datosOrigen.txt");
	
	public Partida() {
		jugadores = new ArrayList<Personaje>();
		tablero = new Tablero(jugadores);
		
	}
	
	public void jugarPartida() {
		//inicializamos la partida: leemos ficheros y creamos los jugadores, armas y tablero
		inicializarPartida();
		
		tablero.inicializarTablero();
		tablero.mostrarTablero();
		
		//se repite hasta que solo queda 1
		while(jugadores.size() > 1) { //rondas
			
			//turno:
			//TODO: recorrer el arrayList para que participen todos
			
			
				
		}
	}
	
	private void inicializarPartida() {
		//Añadimos a jugadores el personaje creado por el usuario
		jugadores.add(crearPersonajeUsuario());
		leerFicheroPartida(nombreFichero);
		for(int i=0; i<jugadores.size(); i++) {
			System.out.println(jugadores.get(i).toStringWithStats());
		}
		
		
	}
	
	
	private Personaje crearPersonajeUsuario() {
		Scanner escaner = new Scanner(System.in);
		String rol;
		boolean error = false;
		
		do {
			System.out.println("Elige un personaje (Caballero, Ogro, Elfo, Mago, Ladrón): ");
			rol = escaner.nextLine();
			if(rol.equalsIgnoreCase("Caballero")) {
				return new Caballero(escogerNombre(escaner), escogerArma(escaner));
			}else if(rol.equalsIgnoreCase("Ogro")) {
				return new Ogro(escogerNombre(escaner), escogerArma(escaner));
			}else if(rol.equalsIgnoreCase("Elfo")) {
				return new Elfo(escogerNombre(escaner), escogerArma(escaner));
			}else if(rol.equalsIgnoreCase("Mago")) {
				return new Mago(escogerNombre(escaner), escogerArma(escaner));
			}else if(rol.equalsIgnoreCase("Ladrón")) {
				return new Ladron(escogerNombre(escaner), escogerArma(escaner));
			}else {
				System.err.println("Error, no has escrito ninguno de los roles disponibles. Inténtalo de nuevo.");
				error = true;
			}
		}while(error == true);
		
		return null;
		
	}
	
	private String escogerNombre(Scanner escaner) {
		System.out.println("Escribe el nombre de tu personaje:");
		return escaner.nextLine();
	}
	
	private Arma escogerArma(Scanner escaner) {
		//definimos las variables
		String arma;
		boolean error = false;
		
		do {
			System.out.println("Escoge un arma(Espada, Maza, Arco, Báculo, Daga): ");
			arma = escaner.nextLine();
			if(arma.equalsIgnoreCase("Espada")) {
				return new Espada();
			}else if(arma.equalsIgnoreCase("Maza")) {
				return new Maza();
			}else if(arma.equalsIgnoreCase("Arco")) {
				return new Arco();
			}else if(arma.equalsIgnoreCase("Báculo")) {
				return new Baculo();
			}else if(arma.equalsIgnoreCase("Daga")) {
				return new Daga();
			}else {
				System.err.println("Error, no has escrito ninguno de las armas disponibles. Inténtalo de nuevo.");
				error = true;
			}
		}while(error == true);
		
		return null;
	}
	
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
	
	private Arma crearArma(String nombreArma) throws ArmaNotExistException{
		if(nombreArma.equalsIgnoreCase("Espada")) {
			return new Espada();
		}else if(nombreArma.equalsIgnoreCase("Maza")) {
			return new Maza();
		}else if(nombreArma.equalsIgnoreCase("Arco")) {
			return new Arco();
		}else if(nombreArma.equalsIgnoreCase("Báculo")) {
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
		}else if(nuevoPersonaje.equalsIgnoreCase("Ladrón")) {
			this.jugadores.add(new Ladron(nombre, crearArma(arma)));
		}else {
			throw new PersonajeNotExistException();
		}
	}
}
