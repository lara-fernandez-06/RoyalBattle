package battleRoyale_v1;

public class PocionVida extends Loot {
	
	public PocionVida(String nombre, TipoLoot tipo) {
		super(nombre, tipo);
		// TODO Auto-generated constructor stub
	}

	@Override
    public void aplicar(Personaje p) {
       p.setVida(p.getVida() + 10); //aumenta la vida en 15
    }
}