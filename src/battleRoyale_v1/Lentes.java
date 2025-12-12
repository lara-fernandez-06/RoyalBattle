package battleRoyale_v1;

public class Lentes extends Loot {

	public Lentes(String nombre, TipoLoot tipo) {
		super(nombre, tipo);
		// TODO Auto-generated constructor stub
	}

	@Override
    public void aplicar(Personaje p) {
       p.setVision(p.getVision() + 15); //aumenta la vision en 15
    }

}
