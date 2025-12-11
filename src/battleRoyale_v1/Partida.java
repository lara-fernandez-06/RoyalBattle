package battleRoyale_v1;

import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
	//Atributos
	private ArrayList<Personaje> jugadores;
	//private ArrayList<ArrayList<Personaje>> tablero;
	Tablero tablero = new Tablero(jugadores);
	
	public Partida() {
		jugadores = new ArrayList<Personaje>();
		//tablero = new ArrayList<ArrayList<Personaje>>();
		
	}
	
	public void jugarPartida() {
		jugadores.add(crearPersonajeUsuario());
		System.out.println(jugadores.getFirst().toString());
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
}
