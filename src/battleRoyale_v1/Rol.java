package battleRoyale_v1;

public enum Rol {
	CABALLERO(0), OGRO(1), ELFO(2), MAGO(3), LADRON(4);
	
	private int id;
	
	 Rol(int id) {
	        this.id = id;
	    }

	    public int getId() {
	        return id;
	    }
	
}
