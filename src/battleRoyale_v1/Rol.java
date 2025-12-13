package battleRoyale_v1;

public enum Rol {
	CABALLERO(0), OGRO(1), ELFO(2), MAGO(3), LADRON(4);
	
	//Atributos
	private int id;
	
	//Constructor
	private Rol(int id) {
		this.id = id;
	}
	
	//toString
	@Override
	public String toString() {
		switch(this.id) {
		case 0: return "Caballero";
		case 1:	return "Ogro";
		case 2: return "Elfo";
		case 3: return "Mago";
		case 4: return "Ladrón";
		default: return "Error";
		}
	}
	
	//Getters y Setters
	public int getId() {
		return this.id;
	}
}
