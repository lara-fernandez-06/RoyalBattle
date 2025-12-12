package battleRoyale_v1;

public enum TipoArma {
	ESPADA(0), MAZA(1), ARCO(2), BACULO(3), DAGA(4);
	
	private final int id;

    TipoArma(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
