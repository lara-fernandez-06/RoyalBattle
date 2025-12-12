package battleRoyale_v1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FicheroInicial {
	
	private static int numJugadores = 25;
	
	public static void main(String[] args) throws IOException {
		
		String ruta = "datosIniciales.csv"; 
		Personaje [] JUGADORES = new Personaje[numJugadores];
		
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			
			String linea;
            while ((linea = br.readLine()) != null) {
            	
            	String [] campos = linea.split(",");
            	
            	//Comprobacion:
            	for (String campo : campos) {
                    System.out.println(campo);
                }
            	
            	//Creación de personajes (un tipo + un arma):
            	for(int i = 0; i < numJugadores; i++) {
            		JUGADORES[i].rol = (Rol)(Math.random() * 5);
            		JUGADORES[i].arma = (Arma)(Math.random() * 5);
            	}
            	
            	
            	
            }
			
			
		} catch(FileNotFoundException e) {
			System.out.println("This file does not exist.");
		}

	}
	
}