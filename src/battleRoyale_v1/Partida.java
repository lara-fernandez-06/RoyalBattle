package battleRoyale_v1;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
	//Atributos
	private ArrayList<Personaje> jugadores;
	//private ArrayList<ArrayList<Personaje>> tablero;
	//Tablero tablero = new Tablero(jugadores);
	String nombreFichero = new String("datosOrigen.txt");
	
	public Partida() {
		jugadores = new ArrayList<Personaje>();
		//tablero = new ArrayList<ArrayList<Personaje>>();
		
	}
	
	public void jugarPartida() {
		//Añadimos a jugadores el personaje creado por el usuario
		jugadores.add(crearPersonajeUsuario());
		leerFicheroPartida(nombreFichero);
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
				System.err.println("Error, no has escrito ninguno de los roles disponibles.Intentalo de nuevo.");
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
				System.err.println("Error, no has escrito ninguno de los roles disponibles.Intentalo de nuevo.");
				error = true;
			}
		}while(error == true);
		
		return null;
	}
	
	private void leerFicheroPartida(String nombreFichero) {
		//definimos las variables
		File f;
		Scanner s;
		
		try {
			//Incializamos las variables
			f = new File(nombreFichero);
			s = new Scanner(f);
			
			//Leemos línea y separamos por demilitadores
			while(s.hasNextLine()) {
				Scanner sl = new Scanner(s.nextLine());
				sl.useDelimiter(";");
				String nuevoPersonaje = sl.next();
				String arma = sl.next();
				String nombre = sl.next();
				
				try {
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
				}catch(ArmaNotExistException armaE) {
					System.out.println(armaE.getMessage());
				}catch(PersonajeNotExistException personajeE) {
					System.out.println(personajeE.getMessage());
				}finally {
					sl.close();
				}
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			
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
}
