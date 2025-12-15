package battleRoyale_v1;

public class Lentes extends Loot {

	public Lentes(String nombre, TipoLoot tipo) {
		super(nombre, tipo);
	}

	@Override
    public void aplicar(Personaje p) {
       p.setVision(p.getVision() + 1); //aumenta la vision en 15
    }

}
