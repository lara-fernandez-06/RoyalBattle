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
	private static int counter;
	
	private int[][] posicion;
	
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
		counter++;
	}
	
	
	//Métodos sin definir
	public void atacar() {
		// TODO Auto-generated method stub
		
	}

	public void quitarVida(int dmg) {
		// TODO Auto-generated method stub
		
	}

	public boolean checkBuff() {
		// TODO Auto-generated method stub
		return false;
	}

	public void checkSurroundings() {
		// TODO Auto-generated method stub
		
	}
	
	public void setPosicion(int[][] posicion) {
		this.posicion = posicion;
	}
	
	public int[][] getPosicion() {
		return this.posicion;
	}
}
