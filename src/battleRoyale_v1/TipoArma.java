package battleRoyale_v1;

public enum TipoArma {
	ESPADA(0), MAZA(1), ARCO(2), BACULO(3), DAGA(4);
	
	//Atributos
	private int id;
	
	//Constructor
    private TipoArma(int id) {
        this.id = id;
    }
    
    //toString
    @Override
    public String toString() {
    	switch(this.id){
    	case 0: return "Espada";
    	case 1: return "Maza";
    	case 2: return "Arco";
    	case 3: return "Báculo";
    	case 4: return "Daga";
    	default: return "Error";
    	}
    }
    //Getters y Setters
    public int getId() {
        return id;
    }
}
